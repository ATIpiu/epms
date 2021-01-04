package com.epms.webController;

import com.alibaba.fastjson.JSONObject;
import com.epms.entity.CommitLog;
import com.epms.entity.Staff;
import com.epms.service.CommitLogService;
import com.epms.service.ProjectService;
import com.epms.service.StaffService;
import com.epms.utils.exception.SignatureException;
import com.epms.utils.result.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@RestController
@CrossOrigin
@RequestMapping(value = "/staff")
public class StaffController {
    private final ProjectService projectService;
    private final StaffService staffService;
    private final CommitLogService commitLogService;

    public StaffController(ProjectService projectService, StaffService staffService, CommitLogService commitLogService) {
        this.projectService = projectService;
        this.staffService = staffService;
        this.commitLogService = commitLogService;
    }

    @RequestMapping("/getOwnProject")
    public Result getOwnProjectStaff(@RequestParam("sId") int sId,
                                     @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) throws SignatureException {
        return projectService.stuffGetProject(sId, page, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    public Result updateInfo(Staff staff) {
        return staffService.updateStaff(staff);
    }

    @RequestMapping("/UploadFile")
    public Result clientUploadFile(@RequestParam("sId") int sId,
                                   @RequestParam("pId") int pId,
                                   @RequestParam("cType") int cType,
                                   @RequestParam("cCreateTime") String cCreateTime,
                                   @RequestParam("file") MultipartFile file) throws SignatureException {
        Timestamp timestamp= JSONObject.parseObject(cCreateTime,Timestamp.class);
        System.out.println(new CommitLog(sId,pId,timestamp,cType,0));























































































































































































































































































































































        return commitLogService.staffAddCommitLog(new CommitLog(sId,pId,timestamp,cType,0),file);
    }
}
