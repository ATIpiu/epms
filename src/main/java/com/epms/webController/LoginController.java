package com.epms.webController;

import com.epms.service.ClientService;
import com.epms.service.StaffService;
import com.epms.utils.exception.SignatureException;
import com.epms.utils.result.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final StaffService staffService;
    private final ClientService clientService;

    public LoginController(StaffService staffService, ClientService clientService) {
        this.staffService = staffService;
        this.clientService = clientService;
    }

    @CrossOrigin
    @RequestMapping(value = "/Login")
    public Result Login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        @RequestParam("type") int type) throws SignatureException {
        try {
            if (type == 2) {
                return clientService.Login(userName, password);
            } else {
                return staffService.Login(userName, password);
            }
        } catch (Exception e) {
            return Result.error().message(e.toString());
        }

    }
}

