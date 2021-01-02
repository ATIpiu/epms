package com.epms.webController;

import com.alibaba.fastjson.JSONArray;
import com.epms.service.SalaryService;
import com.epms.entity.Project;
import com.epms.entity.Salary;
import com.epms.service.*;
import com.epms.utils.exception.SignatureException;
import com.epms.utils.result.Result;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/manager")
public class ManagerController {
    private final StaffService staffService;
    private final ProjectService projectService;
    private final SelectProjectService selectProjectService;
    private final CommitLogService commitLogService;
    private final SalaryService salaryService;

    public ManagerController(StaffService staffService, ProjectService projectService, SelectProjectService selectProjectService, CommitLogService commitLogService, SalaryService salaryService) {
        this.staffService = staffService;
        this.projectService = projectService;
        this.selectProjectService = selectProjectService;
        this.commitLogService = commitLogService;
        this.salaryService = salaryService;
    }

    @RequestMapping("/UploadFile")
    public Result managerUploadFile(@RequestParam("type") int type,
                                    @RequestParam("pId") int pId,
                                    @RequestParam("file") MultipartFile file) throws SignatureException {
        return projectService.managerUploadFile(type, pId, file);
    }

    @ResponseBody
    @RequestMapping(value = "createProject", method = RequestMethod.POST)
    public Result createProject(Project project) throws SignatureException {
        return projectService.managerAddProject(project);
    }

    @RequestMapping("/distributeStaff")
    public Result distributeStaff(@RequestParam("pId") int pId,
                                  @RequestParam(value = "sIds[]") int[] sIds) throws SignatureException {
        return selectProjectService.managerDistributeStaff(pId, sIds);
    }

    @RequestMapping("/getOwnProjectStaff")
    public Result getOwnProjectStaff(@RequestParam("pId") int pId,
                                     @RequestParam("type") int type,
                                     @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) throws SignatureException {
        return staffService.managerGetOwnProjectStaff(pId, type, page, pageSize);
    }

    @RequestMapping("/getOwnStaff")
    public Result getOwnStaff(@RequestParam("type") int type,
                              @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) throws SignatureException {
        return staffService.managerGetOwnStaff(type, page, pageSize);
    }

    @RequestMapping(value = "/GetCommitLog")
    public Result GetCommitLog(@RequestParam("sId") int sId,
                               @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) throws SignatureException {
        if (sId == 0) {
            return Result.error().message("员工Id不能为0");
        }
        return commitLogService.managerGetCommitLog(sId, page, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/evaluateStaff", method = RequestMethod.POST)
    public Result evaluateStaffWork(@RequestParam("salaryList") String salaryList) {
        List<Salary> salaryLists= JSONArray.parseArray(salaryList,Salary.class);
        return salaryService.EvaluateQuality(salaryLists);
    }
}
