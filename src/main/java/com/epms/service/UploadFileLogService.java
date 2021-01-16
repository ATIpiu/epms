package com.epms.service;

import com.epms.entity.UploadFileLog;
import com.epms.utils.result.Result;

import java.util.List;

public interface UploadFileLogService {
    /**
     * 获取所有的文件上传日志
     * @return
     */
    Result getAllUploadFileLog(int page ,int pageSize);

    /**
     * 插入上传文件日志
     * @return
     */
    Result insertIntoUploadFileLog();

}
