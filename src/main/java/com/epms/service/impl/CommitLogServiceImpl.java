package com.epms.service.impl;

import com.epms.dao.commitLogDao.CommitLogDao;
import com.epms.dao.staffDao.StaffDao;
import com.epms.entity.CommitLog;
import com.epms.service.CommitLogService;
import com.epms.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CommitLogServiceImpl implements CommitLogService {
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private CommitLogDao commitLogDao;

    @Override
    public Result managerGetCommitLog(int managerId,int page,int pageSize) {
        try{
            int type=staffDao.getType(managerId);
            if(type==1||type==2||type==3){
                List<CommitLog> commitLogs=commitLogDao.managerGetCommitLog(managerId,type);
                List<CommitLog> results=new ArrayList<CommitLog>();
                for (int i=(page-1)*pageSize;i<page*pageSize&&i<commitLogs.size();i++){
                    results.add(commitLogs.get(i));
                }
                return Result.ok().message("查询成功").data("commitLogList",results);
            }
            else return Result.error().message("查询失败：只有主管才能查询该记录");
        }catch (Exception e){
            return Result.error().message("获取失败："+e.toString());
        }
    }

    @Override
    public Result clientGetCommitLog(int cId) {
        return null;
    }

    @Override
    public Result checkCommitLog(String cFeedBack, int cResponseType) {
        return null;
    }

    @Override
    public Result staffGetOwnCommitLog(int sId) {
        return null;
    }

    @Override
    public Result staffAddCommitLog(CommitLog commitLog) {
        return null;
    }

    @Override
    public Result staffUpdateCommitLog(CommitLog commitLog) {
        return null;
    }

    @Override
    public Result getAllCommitLog(int sId) {
        return null;
    }
}
