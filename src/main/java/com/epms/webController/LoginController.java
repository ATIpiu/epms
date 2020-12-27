package com.epms.webController;

import com.epms.aop.SignatureValidation;
import com.epms.service.ClientService;
import com.epms.service.StaffService;
import com.epms.utils.exception.SignatureException;
import com.epms.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private ClientService clientService;

    @CrossOrigin
    @RequestMapping(value = "/Login" )
    public  Result Login(@RequestParam("userName")String  userName,
                         @RequestParam("password")String  password,
                         @RequestParam("type")int  type) throws SignatureException {
        try {
            if(type==2){
                return clientService.Login(userName,password);
            }else {
                return staffService.Login(userName, password);
            }
        }
        catch (Exception e){
            return Result.error().message(e.toString());
        }

    }
}

