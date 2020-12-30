package com.epms.utils.upLoadFile;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadFileUtil {
    public static String upload(MultipartFile file,String path) throws IOException {
        // 判断文件是否为空，空则返回失败页面
        if (file.isEmpty())
            return null;
        String fileName = file.getOriginalFilename();
        // 创建文件实例
        File filePath=new File(path, fileName);
        // 如果文件目录不存在，创建目录
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录" + filePath);
        }
        // 写入文件
        file.transferTo(filePath);
        return fileName;
    }
}
