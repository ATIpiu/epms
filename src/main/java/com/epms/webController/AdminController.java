package com.epms.webController;

import com.epms.entity.*;
import com.epms.service.*;
import com.epms.utils.exception.SignatureException;
import com.epms.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(value = "/Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UploadFileLogService uploadFileLogService;
    @Autowired
    private SalaryService  salaryService;
    @Autowired
    private WageService wageService;

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
}
