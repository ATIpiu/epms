package com.epms.webController;

import com.epms.service.StaffService;
import com.epms.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/User")
public class LoginController {
//    @Autowired
    private StaffService staffService;

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
//    public Map<String, Object> setTutorInfo(@RequestParam("userName")String  userName, @RequestParam("password")String  password) throws Exception{
    public Result Login(String userName, String password) throws Exception {
        System.out.println( staffService.Login(userName,password));
        return null;
    }
}

