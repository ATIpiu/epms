package com.epms.webController;

import com.epms.service.*;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping(value = "/download")
public class DownloadController {
    private final ProjectService projectService;
    private final StaffService staffService;
    private final ClientService clientService;
    private final CommitLogService commitLogService;
    private final SalaryService salaryService;

    public DownloadController(ProjectService projectService, StaffService staffService, ClientService clientService, CommitLogService commitLogService, SalaryService salaryService) {
        this.projectService = projectService;
        this.staffService = staffService;
        this.clientService = clientService;
        this.commitLogService = commitLogService;
        this.salaryService = salaryService;
    }

    @RequestMapping("/projectFile")
    public ResponseEntity<byte[]> projectFile(@RequestParam("pId") int pId) throws IOException {
        String downLoadPath = projectService.getProjectFile(pId);
        return getResponseEntity(downLoadPath);
    }

    private ResponseEntity<byte[]> getResponseEntity(String downLoadPath) throws IOException {
        File file = new File(downLoadPath);
        if (file.exists()) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", file.getName());
            return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } else {
            System.out.println("文件不存在,请重试...");
            System.out.println(downLoadPath);
            return null;
        }
    }

    @RequestMapping("/commitLogFile")
    public ResponseEntity<byte[]> commitLogFile(@RequestParam("url") String url) throws IOException {
        String downLoadPath = url;
        return getResponseEntity(downLoadPath);
    }
    @RequestMapping("/projectCsv")
    public ResponseEntity<byte[]> projectCsv(@RequestParam("timestamp") String timestamp) throws IOException {
        String downLoadPath = "/Epms/tmp/project"+timestamp+".csv";
        System.out.println(downLoadPath);
        if(projectService.exportCsv(downLoadPath)!=null)
            return getResponseEntity(downLoadPath);
        else return null;
    }
    @RequestMapping("/staffCsv")
    public ResponseEntity<byte[]> staffCsv(@RequestParam("timestamp") String timestamp) throws IOException {
        String downLoadPath = "/Epms/tmp/staff"+timestamp+".csv";
        System.out.println(downLoadPath);
        if(staffService.exportCsv(downLoadPath)!=null)
            return getResponseEntity(downLoadPath);
        else return null;
    }
    @RequestMapping("/clientCsv")
    public ResponseEntity<byte[]> clientCsv(@RequestParam("timestamp") String timestamp) throws IOException {
        String downLoadPath = "/Epms/tmp/client"+timestamp+".csv";
        System.out.println(downLoadPath);
        if(clientService.exportCsv(downLoadPath)!=null)
            return getResponseEntity(downLoadPath);
        else return null;
    }
    @RequestMapping("/commitLogCsv")
    public ResponseEntity<byte[]> commitLogCsv(@RequestParam("timestamp") String timestamp) throws IOException {
        String downLoadPath = "/Epms/tmp/commitLog"+timestamp+".csv";
        System.out.println(downLoadPath);
        if(commitLogService.exportCsv(downLoadPath)!=null)
            return getResponseEntity(downLoadPath);
        else return null;
    }
    @RequestMapping("/salaryCsv")
    public ResponseEntity<byte[]> salaryCsv(@RequestParam("timestamp") String timestamp) throws IOException {
        String downLoadPath = "/Epms/tmp/salary"+timestamp+".csv";
        System.out.println(downLoadPath);
        if(salaryService.exportCsv(downLoadPath)!=null)
            return getResponseEntity(downLoadPath);
        else return null;
    }

}
