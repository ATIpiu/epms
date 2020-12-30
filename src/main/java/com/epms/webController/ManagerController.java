package com.epms.webController;

import com.epms.entity.Project;
import com.epms.service.ProjectService;
import com.epms.service.StaffService;
import com.epms.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping(value = "/manager")
public class ManagerController {
    @Autowired
    private  StaffService staffService;
    @Autowired
    private ProjectService projectService;

    @RequestMapping("/UploadFile")
    public Result managerUploadFile(@RequestParam("type") int type,
                                   @RequestParam("pId") int pId,
                                   @RequestParam("file") MultipartFile file) throws Exception{
        return projectService.managerUploadFile(type, pId, file);
    }
    @ResponseBody
    @RequestMapping("createProject/")
    public Result createProject(Project project) throws Exception{
        return projectService.managerAddProject(project);
    }

}
