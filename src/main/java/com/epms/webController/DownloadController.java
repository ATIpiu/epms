package com.epms.webController;

import com.epms.service.ProjectService;
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

    public DownloadController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping("/projectFile")
    public ResponseEntity<byte[]> projectFile(@RequestParam("pId") int pId) throws IOException {
        String downLoadPath = projectService.getProjectFile(pId);
        File file = new File(downLoadPath);
        if (file.exists()) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", file.getName());
            return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } else {
            System.out.println("文件不存在,请重试...");
            return null;
        }
    }
    @RequestMapping("/commitLogFile")
    public ResponseEntity<byte[]> commitLogFile(@RequestParam("url") String url) throws IOException {
        String downLoadPath = url;
        File file = new File(downLoadPath);
        if (file.exists()) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", file.getName());
            return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } else {
            System.out.println("文件不存在,请重试...");
            return null;
        }
    }

}
