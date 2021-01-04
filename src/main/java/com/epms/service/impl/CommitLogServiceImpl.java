package com.epms.service.impl;

import com.epms.dao.commitLogDao.CommitLogDao;
import com.epms.dao.projectDao.ProjectDao;
import com.epms.dao.staffDao.StaffDao;
import com.epms.entity.CommitLog;
import com.epms.entity.Project;
import com.epms.entity.UploadFileLog;
import com.epms.service.CommitLogService;
import com.epms.utils.result.Result;
import com.epms.utils.result.ResultCodeEnum;
import com.epms.utils.upLoadFile.UploadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommitLogServiceImpl implements CommitLogService {
    private final StaffDao staffDao;
    private final CommitLogDao commitLogDao;
    private final ProjectDao projectDao;

    public CommitLogServiceImpl(StaffDao staffDao, CommitLogDao commitLogDao, ProjectDao projectDao) {
        this.staffDao = staffDao;
        this.commitLogDao = commitLogDao;
        this.projectDao = projectDao;
    }

    @Override
    public Result managerGetCommitLog(int managerId, int page, int pageSize) {
        try {
            int type = staffDao.getType(managerId);
            if (type == 1 || type == 2 || type == 3) {
                List<CommitLog> commitLogs = commitLogDao.managerGetCommitLog(managerId, type);
                return paging(page, pageSize, commitLogs);
            } else return Result.error().message("查询失败：只有主管才能查询该记录");
        } catch (Exception e) {
            return Result.error().message("获取失败：" + e.toString());
        }
    }

    private Result paging(int page, int pageSize, List<CommitLog> commitLogs) {
        List<CommitLog> results = new ArrayList<CommitLog>();
        for (int i = (page - 1) * pageSize; i < page * pageSize && i < commitLogs.size(); i++) {
            results.add(commitLogs.get(i));
        }
        return Result.ok().message("查询成功").data("commitLogList", results);
    }

    @Override
    public Result clientGetCommitLog(int cId, int page, int pageSize) {
        try {
            List<CommitLog> commitLogs = commitLogDao.clientGetCommitLog(cId);
            return paging(page, pageSize, commitLogs);
        } catch (Exception e) {
            return Result.error().message("获取失败：" + e.toString());
        }
    }

    @Override
    public Result checkCommitLog(CommitLog commitLog) {
        try {
            if (commitLog.getcResponseType() == 0) {
                return Result.error().message("回复失败：请选择同意还是驳回");
            }
            else if(commitLog.getcResponseType() == 2&&commitLog.getcFeedback()==""){
                return Result.error(ResultCodeEnum.ERROR_NEED_REASON);
            }
            else {
                commitLogDao.updateCommitLog(commitLog);
                return Result.ok().message("回复成功");
            }
        } catch (Exception e) {
            return Result.error().message("回复失败：" + e.toString());
        }
    }

    @Override
    public Result staffGetOwnCommitLog(int sId, int page, int pageSize) {
        try {
            List<CommitLog> commitLogs = commitLogDao.queryCommitLogsBysId(sId);
            return paging(page, pageSize, commitLogs);
        } catch (Exception e) {
            return Result.error().message("查询失败：" + e.toString());
        }
    }

    @Override
    public Result staffAddCommitLog(CommitLog commitLog, MultipartFile file) {
        try{
            String url= UploadFileUtil.upload(file,"D:/Epms/"+projectDao.queryProjectBypId(commitLog.getpId()).getpName()+"/小样");
            if(url==null){
                return Result.error().message("文件错误");
            }else commitLog.setcFileUrl(url);
            int sType=staffDao.getType(commitLog.getsId());
            if (sType>=4&&sType<=6&&commitLog.getcType()==2){
                return Result.error().message("该员工经验不足，不能直接向客户提交");
            }
            if(commitLogDao.insertIntoCommitLog(commitLog)>0){
                return Result.ok().message("添加成功");
            }
            else  return Result.error().message("添加失败");
        }catch (Exception e){
            System.err.println(e);
            return Result.error().message("添加失败:"+e.toString());
        }
    }

    @Override
    public Result staffUpdateCommitLog(CommitLog commitLog) {
        try{
            if (commitLogDao.updateCommitLog(commitLog)>0){
                return Result.ok().message("修改成功");
            }
            else return Result.error().message("修改失败：未找到对应记录");
        }catch (DuplicateKeyException e){
            System.err.println(e);
            return Result.error().message("修改失败：已经存在对应记录");
        }
        catch (Exception e){
            System.err.println(e);
            return Result.error().message("修改失败："+e.toString());
        }
    }

    @Override
    public Result getAllCommitLog( int page, int pageSize) {
        try {
            List<CommitLog> commitLogs = commitLogDao.queryAllCommitLogs();
            return paging(page, pageSize, commitLogs);
        } catch (Exception e) {
            return Result.error().message("查询失败：" + e.toString());
        }
    }
}
