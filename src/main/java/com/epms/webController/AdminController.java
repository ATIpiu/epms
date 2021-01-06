package com.epms.webController;

import com.epms.entity.Client;
import com.epms.entity.Staff;
import com.epms.service.AdminService;
import com.epms.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @ResponseBody
    @RequestMapping(value = "/getChoose")
    public Result getChoose(){
        return adminService.getChoose();
    }
}
