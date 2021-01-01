package com.epms.webController;

import com.epms.entity.Client;
import com.epms.entity.CommitLog;
import com.epms.service.ClientService;
import com.epms.service.CommitLogService;
import com.epms.service.ProjectService;
import com.epms.utils.exception.SignatureException;
import com.epms.utils.result.Result;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    public ClientController(ClientService clientService, ProjectService projectService, CommitLogService commitLogService) {
        this.clientService = clientService;
        this.projectService = projectService;
        this.commitLogService = commitLogService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        //转换日期
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

    @RequestMapping(value = "/GetProject")
    public Result clientGetProject(@RequestParam("cId") int cId,
                                   @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) throws SignatureException {
        if (cId == 0) {
            return Result.error().message("用户Id不能为0");
        }
        return projectService.clientGetProject(cId, page, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    public Result updateInfo(Client client) throws Exception {
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
    public Result checkCommitLog(CommitLog commitLog) throws Exception {
        System.out.println(commitLog);
        return commitLogService.checkCommitLog(commitLog);
    }


    @RequestMapping("/filesDownload")
    public ResponseEntity<byte[]> EIToolDownloads(@RequestParam("pId") int pId) throws IOException {
        String downLoadPath = projectService.getProjectFile(pId);
        File file = new File(downLoadPath);
        if (file.exists()) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", file.getName());
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } else {
            System.out.println("文件不存在,请重试...");
            return null;
        }
    }

    @RequestMapping(value = "/setProjectPeriodStatus", method = RequestMethod.POST)
    public Result setStatus(@RequestParam("cId") int cId,
                            @RequestParam("pId") int pId,
                            @RequestParam("status") int status) {
        return projectService.clientSetPeriodStatus(cId, pId, status);
    }

    @RequestMapping("/UploadFile")
    public Result clientUploadFile(@RequestParam("cId") int cId,
                                   @RequestParam("pId") int pId,
                                   @RequestParam("file") MultipartFile file) {
        return projectService.clientUploadFile(cId, pId, file);
    }

}
