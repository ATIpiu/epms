package com.epms.webController;

import com.epms.service.ClientService;
import com.epms.service.ProjectService;
import com.epms.utils.exception.SignatureException;
import com.epms.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/clientGetProject")
    public Result clientGetProject(@RequestParam("cId") int cId,
                                   @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize)
            throws SignatureException{
        System.out.println(cId);
        return projectService.clientGetProject(cId,page,pageSize);
    }
}