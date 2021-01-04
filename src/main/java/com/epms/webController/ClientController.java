package com.epms.webController;

import com.epms.entity.Client;
import com.epms.entity.CommitLog;
import com.epms.service.ClientService;
import com.epms.service.CommitLogService;
import com.epms.service.ProjectService;
import com.epms.utils.exception.SignatureException;
import com.epms.utils.result.Result;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping(value = "/client")
public class ClientController {
    private final ClientService clientService;
    private final ProjectService projectService;
    private final CommitLogService commitLogService;

    public ClientController(ClientService clientService, ProjectService projectService, CommitLogService commitLogService) throws SignatureException {
        this.clientService = clientService;
        this.projectService = projectService;
        this.commitLogService = commitLogService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        //转换日期
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

    @RequestMapping(value = "/GetProject")
    public Result clientGetProject(@RequestParam("cId") int cId,
                                   @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) throws SignatureException {
        if (cId == 0) return Result.error().message("用户Id不能为0");
        return projectService.clientGetProject(cId, page, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    public Result updateInfo(Client client) {
        return clientService.updateClient(client);
    }

    @RequestMapping(value = "/GetCommitLog")
    public Result clientGetCommitLog(@RequestParam("cId") int cId,
                                     @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) throws SignatureException {
        if (cId == 0) {
            return Result.error().message("用户Id不能为0");
        }
        return commitLogService.clientGetCommitLog(cId, page, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/checkCommitLog", method = RequestMethod.POST)
    public Result checkCommitLog(CommitLog commitLog) throws SignatureException {
        return commitLogService.checkCommitLog(commitLog);
    }

    @RequestMapping(value = "/setProjectPeriodStatus", method = RequestMethod.POST)
    public Result setStatus(@RequestParam("cId") int cId,
                            @RequestParam("pId") int pId,
                            @RequestParam("status") int status) throws SignatureException {
        return projectService.clientSetPeriodStatus(cId, pId, status);
    }

    @RequestMapping("/UploadFile")
    public Result clientUploadFile(@RequestParam("cId") int cId,
                                   @RequestParam("pId") int pId,
                                   @RequestParam("file") MultipartFile file) throws SignatureException {
        return projectService.clientUploadFile(cId, pId, file);
    }


}
