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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping(value = "/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private CommitLogService commitLogService;

    @RequestMapping(value = "/clientGetProject")
    public Result clientGetProject(@RequestParam("cId") int cId,
                                   @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize)
            throws SignatureException{
        if(cId==0){
            return Result.error().message("用户Id不能为0");
        }
        return projectService.clientGetProject(cId,page,pageSize);
    }
    @ResponseBody
    @RequestMapping(value = "/updateInfo",method = RequestMethod.POST)
    public Result updateInfo(Client client)
            throws Exception {
        return clientService.updateClient(client);
    }
    @RequestMapping(value = "/clientGetCommitLog")
    public Result clientGetCommitLog(@RequestParam("cId") int cId,
                                   @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize)
            throws SignatureException {
        if(cId==0){
            return Result.error().message("用户Id不能为0");
        }
        return commitLogService.clientGetCommitLog(cId,page,pageSize);
    }
    @ResponseBody
    @RequestMapping(value = "/checkCommitLog",method = RequestMethod.POST)
    public Result checkCommitLog(CommitLog commitLog)
            throws Exception {
        System.out.println(commitLog);
        return commitLogService.checkCommitLog(commitLog);
    }
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }
    @RequestMapping("/filesDownloads")
    public ResponseEntity<byte[]> EIToolDownloads(@RequestParam("pId") int pId) throws IOException {
        String downLoadPath = projectService.getProjectFile(pId);
        File file = new File(downLoadPath);
        if(file.exists()){
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", file.getName());
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
        }else{
            System.out.println("文件不存在,请重试...");
            return null;
        }
    }

}
