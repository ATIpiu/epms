package com.epms.webController;

import com.epms.entity.Staff;
import com.epms.service.ProjectService;
import com.epms.service.StaffService;
import com.epms.utils.exception.SignatureException;
import com.epms.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/staff")
public class StaffController {
    private final ProjectService projectService;
    private final StaffService staffService;

    public StaffController(ProjectService projectService, StaffService staffService) {
        this.projectService = projectService;
        this.staffService = staffService;
    }

    @RequestMapping("/getOwnProject")
    public Result getOwnProjectStaff(@RequestParam("sId") int sId,
                                     @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) throws SignatureException {
        return projectService.stuffGetProject(sId ,page, pageSize);
    }
    @ResponseBody
    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    public Result updateInfo(Staff staff) {
        return staffService.updateStaff(staff);
    }
}
