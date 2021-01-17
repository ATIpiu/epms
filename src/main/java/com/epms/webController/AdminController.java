package com.epms.webController;

import com.epms.entity.*;
import com.epms.service.*;
import com.epms.utils.exception.SignatureException;
import com.epms.utils.result.Result;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(value = "/admin")
public class AdminController {
    private final AdminService adminService;
    private final ProjectService projectService;
    private final UploadFileLogService uploadFileLogService;
    private final SalaryService  salaryService;
    private final WageService wageService;
    private final CommitLogService commitLogService;

    public AdminController(AdminService adminService, ProjectService projectService, UploadFileLogService uploadFileLogService, SalaryService salaryService, WageService wageService, CommitLogService commitLogService) {
        this.adminService = adminService;
        this.projectService = projectService;
        this.uploadFileLogService = uploadFileLogService;
        this.salaryService = salaryService;
        this.wageService = wageService;
        this.commitLogService = commitLogService;
    }

    @ResponseBody
    @RequestMapping(value = "/getChoose")
    public Result getChoose(){
        return adminService.getChoose();
    }
    @RequestMapping(value = "/getAllProject")
    public Result getAllProject(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) throws SignatureException {
        return projectService.getAllProject(page,pageSize);
    }
    @ResponseBody
    @RequestMapping(value = "/updateProject", method = RequestMethod.POST)
    public Result updateProject(Project project) {
        return projectService.managerUpdateProject(project);
    }
    @RequestMapping(value = "/getAllUploadFileLog")
    public Result getAllUploadFileLog(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) throws SignatureException {
        return uploadFileLogService.getAllUploadFileLog(page,pageSize);
    }
    @RequestMapping(value = "/getAllSalary")
    public Result getAllSalary(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                      @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) throws SignatureException {
        return salaryService.getAllSalary(page,pageSize);
    }
    @ResponseBody
    @RequestMapping(value = "/updateSalary", method = RequestMethod.POST)
    public Result updateSalary(Salary salary) {
        return salaryService.updateSalary(salary);
    }
    @RequestMapping(value = "/getAllWage")
    public Result getAllWage(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) throws SignatureException {
        return wageService.getAllWage(page,pageSize);
    }
    @ResponseBody
    @RequestMapping(value = "/updateWage", method = RequestMethod.POST)
    public Result updateWage(Wage wage) {
        return wageService.updateWage(wage);
    }
    @RequestMapping(value = "/getAllCommitLog")
    public Result getAllCommitLog(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) throws SignatureException {
        return commitLogService.getAllCommitLog(page,pageSize);
    }
    @ResponseBody
    @RequestMapping(value = "/updateCommitLog", method = RequestMethod.POST)
    public Result updateCommitLog(CommitLog wage) {
        return commitLogService.staffUpdateCommitLog(wage);
    }
}
