package com.epms.dao.uniteDao;

import com.epms.entity.CommitLog;
import com.epms.entity.Project;

import java.util.List;

public interface UniteDao {
    /**
     * 员工查询自己所负责项目的列表
     * @param sId :员工ID
     * @return 返回被查询的Project对象
     */
    List<Project> staffGetProject(int sId);

    /**
     * 客户查询员工提交记录
     * @param cId：客户ID
     * @return 提交的日志列表
     */
    List<CommitLog> clientGetCommitLog(int cId);

    /**
     * 主管查询员工提交记录
     * @param ：sId ：主管员工ID
     * @param : type : 主管类型（模型、渲染、后期）
     * @return 提交的日志列表
     */
    List<CommitLog> managerGetCommitLog(int sId, int type);

}
