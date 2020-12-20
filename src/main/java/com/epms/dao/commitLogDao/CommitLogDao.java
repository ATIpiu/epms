package com.epms.dao.commitLogDao;

import com.epms.entity.CommitLog;

import java.util.List;
import java.util.Map;

public interface CommitLogDao {
    /**
     * @param map 参数为存着一个commit记录 前四条的map类型的对象
     * @return int 若插入成功返回1，失败返回0；
     */
    int insertIntoCommitLog(Map<String, Object> map);

    /**
     * @param commitlog 参数为一次commit的记录
     * @return int 若删除成功返回1，失败返回0；
     */
    int deleteCommitLog(CommitLog commitlog);

    /**
     * @param commitlog 参数为一次提交的记录
     * @return int 若更新成功返回1，失败返回0；
     */
    int updateCommitLog(CommitLog commitlog);

    /**
     * 获取commit日志（CommitLog）信息；
     *
     * @return list<CommitLog> 根据员工sId查询上传日志(CommitLog)信息
     */
    List<CommitLog> queryCommitLogsBysId(int sId);

    /**
     * 获取commit日志（CommitLog）信息；
     *
     * @return list<CommitLog> 根据项目pId查询所有的commit日志(CommitLog)信息
     */
    List<CommitLog> queryCommitLogsBypId(int pId);

    /**
     * 获取所有的commit日志（CommitLog）信息；
     *
     * @return list<CommitLog> 所有的commit日志(CommitLog)信息
     */
    List<CommitLog> queryAllCommitLogs();


}
