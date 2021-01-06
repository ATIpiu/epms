package com.epms.dao.commitLogDao;

import com.epms.entity.CommitLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommitLogDao {
    /**
     * @param commitLog 参数为存着一个commit记录
     * @return int 若插入成功返回1，失败返回0；
     */
    int insertIntoCommitLog(CommitLog commitLog);

    /**
     * @param commitLog 参数为一次commit的记录
     * @return int 若删除成功返回1，失败返回0；
     */
    int deleteCommitLog(CommitLog commitLog);

    /**
     * 客户查询员工提交记录
     *
     * @param cId：客户ID
     * @return 提交的日志列表
     */
    List<CommitLog> clientGetCommitLog(int cId);

    /**
     * 主管查询员工提交记录
     *
     * @param ：sId ：主管员工ID
     * @param :    type : 主管类型（模型、渲染、后期）
     * @return 提交的日志列表
     */
    List<CommitLog> managerGetCommitLog(@Param("sId") int sId, @Param("type") int type);

    /**
     * @param commitLog 参数为一次提交的记录
     * @return int 若更新成功返回1，失败返回0；
     */
    int updateCommitLog(CommitLog commitLog);

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


    /**
     * 将数据导出成报表
     * @param url ：本地路径；
     * @return
     */
    Integer generateFile(String url);
}
