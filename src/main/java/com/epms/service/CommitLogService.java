package com.epms.service;

import com.epms.entity.CommitLog;
import com.epms.utils.result.Result;

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
    Result clientGetCommitLog(int cId);

    /**
     * 用户或者主管对此次提交进行审核
     * @param cFeedBack 对此次提交文件的反馈意见；
     * @param cResponseType 此次提交文件是否满足要求 0：未处理；1：同意；2：驳回
     * @return 成功与否；
     */
    Result checkCommitLog(String cFeedBack,int cResponseType);

    /**
     * 员工自己查看提交记录；
     * @param sId 员工Id
     * @return  成功则返回对应的Log，失败则返回原因；
     */
    Result staffGetOwnCommitLog(int sId);

    /**
     * 员工提交文件记录
     * @param commitLog
     * @return 返回成功与否
     */
    Result staffAddCommitLog(CommitLog commitLog);

    /**
     * 员工根据反馈修改提交记录；
     * @param commitLog
     * @return
     */
    Result staffUpdateCommitLog(CommitLog commitLog);

    /**
     * 管理员获取所有提交记录
     * @param sId
     * @return 返回对应Log记录表
     */
    Result getAllCommitLog(int sId);
}
