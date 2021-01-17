package com.epms.service.impl;

import com.epms.dao.uploadFileLogDao.UploadFileLogDao;
import com.epms.entity.Staff;
import com.epms.entity.UploadFileLog;
import com.epms.service.UploadFileLogService;
import com.epms.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UploadFileLogServiceImpl implements UploadFileLogService {
    private final UploadFileLogDao uploadFileLogDao;

    public UploadFileLogServiceImpl(UploadFileLogDao uploadFileLogDao) {
        this.uploadFileLogDao = uploadFileLogDao;
    }

    @Override
    public Result getAllUploadFileLog(int page, int pageSize) {
        try {
            List<UploadFileLog> uploadFileLogList=uploadFileLogDao.queryAllUploadFileLogs();
            List<UploadFileLog> results = new ArrayList<>();
            for(int i=(page-1)*pageSize;i<page*pageSize&&i<uploadFileLogList.size();i++){
                results.add(uploadFileLogList.get(i));
            }
            return Result.ok().message("查询成功").data("uploadFileLogList",results);
        }
        catch (Exception e){
            System.err.println(e.toString());
            return Result.error().message(e.toString());
        }
    }

    @Override
    public Result insertIntoUploadFileLog() {
        return null;
    }
}
