package com.epms.webController;

import com.epms.service.ClientService;
import com.epms.service.StaffService;
import com.epms.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping(value = "/User")
public class LoginController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private ClientService clientService;

    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }
    @RequestMapping(value = "/Login" )
//    public Map<String, Object> setTutorInfo(@RequestParam("userName")String  userName, @RequestParam("password")String  password) throws Exception{
    public  Result Login(String userName, String password,int type) throws Exception {
        try {
            if(type==2){
                return clientService.Login(userName,password);
            }else {
                return staffService.Login(userName, password);
            }
        }catch (Exception e){
            return Result.error().message(e.toString());
        }

    }
}

