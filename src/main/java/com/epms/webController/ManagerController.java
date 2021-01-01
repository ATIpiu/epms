package com.epms.webController;

import com.epms.entity.CommitLog;
import com.epms.entity.Project;
import com.epms.service.CommitLogService;
import com.epms.service.ProjectService;
import com.epms.service.SelectProjectService;
import com.epms.service.StaffService;
import com.epms.utils.exception.SignatureException;
import com.epms.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping(value = "/manager")
public class ManagerController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private SelectProjectService selectProjectService;
    @Autowired
    private CommitLogService commitLogService;

    @RequestMapping("/UploadFile")
    public Result managerUploadFile(@RequestParam("type") int type,
                                    @RequestParam("pId") int pId,
                                    @RequestParam("file") MultipartFile file) throws Exception {
        return projectService.managerUploadFile(type, pId, file);
    }

    @ResponseBody
    @RequestMapping(value = "createProject", method = RequestMethod.POST)
    public Result createProject(Project project) throws Exception {
        return projectService.managerAddProject(project);
    }

    @RequestMapping("/distributeStaff")
    public Result distributeStaff(@RequestParam("pId") int pId,
                                  @RequestParam(value = "sIds[]") int[] sIds) throws Exception {
        return selectProjectService.managerDistributeStaff(pId, sIds);
    }

    @RequestMapping("/getOwnProjectStaff")
    public Result getOwnProjectStaff(@RequestParam("pId") int pId,
                                     @RequestParam("type") int type,
                                     @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) throws Exception {
        return staffService.managerGetOwnProjectStaff(pId, type, page, pageSize);
    }

    @RequestMapping("/getOwnStaff")
    public Result getOwnStaff(@RequestParam("type") int type,
                              @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) throws Exception {
        return staffService.managerGetOwnStaff(type, page, pageSize);
    }

    @RequestMapping(value = "/GetCommitLog")
    public Result clientGetCommitLog(@RequestParam("sId") int sId,
                                      @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) throws SignatureException {
        if (sId == 0) {
            return Result.error().message("员工Id不能为0");
        }
        return commitLogService.managerGetCommitLog(sId, page, pageSize);
    }
}
