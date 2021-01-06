package com.epms.service;

import com.epms.entity.CommitLog;
import com.epms.utils.result.Result;
import org.springframework.web.multipart.MultipartFile;

public interface CommitLogService {
    /**
     * 主管获取提交记录
     * @param ManagerId 主管Id
     * @return 成功则返回对应的Log，失败则返回原因；
     */
    Result managerGetCommitLog(int ManagerId,int page,int pageSize);

    /**
     *客户获取提交记录
     * @param cId 客户Id
     * @return 成功则返回对应的Log，失败则返回原因；
     */
    Result clientGetCommitLog(int cId,int page,int pageSize);

    /**
     * 用户或者主管对此次提交进行审核
     * @param commitLog 对此次提交文件的反馈意见，和是否同意此次提交
     * @return 成功与否；
     */
    Result checkCommitLog(CommitLog commitLog);

    /**
     * 员工自己查看提交记录；
     * @param sId 员工Id
     * @return  成功则返回对应的Log，失败则返回原因；
     */
    Result staffGetOwnCommitLog(int sId,int page,int pageSize);

    /**
     * 员工提交文件记录
     * @param commitLog
     * @return 返回成功与否
     */
    Result staffAddCommitLog(CommitLog commitLog, MultipartFile file);

    /**
     * 员工根据反馈修改提交记录；
     * @param commitLog
     * @return
     */
    Result staffUpdateCommitLog(CommitLog commitLog);

    /**
     * 管理员获取所有提交记录
     * @return 返回对应Log记录表
     */
    Result getAllCommitLog(int page,int pageSize);

    /**
     * 导出Csv文件
     * @return
     */
    String exportCsv(String url);
}
