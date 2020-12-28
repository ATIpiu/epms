package com.epms.service;

import com.epms.entity.Project;
import com.epms.utils.result.Result;

public interface ProjectService {
    /**
     * 主管添加项目
     * @param project
     * @return
     */
    Result managerAddProject(Project project);

    /**
     * 主管修改项目
     * @param project
     * @return
     */
    Result managerUpdateProject(Project project);

    /**
     * 客户查询项目
     * @param cId
     * @param page
     * @param pageSize
     * @return
     */
    Result clientGetProject(int cId,int page,int pageSize);

    /**
     * 员工查询项目
     * @param sId
     * @param page
     * @param pageSize
     * @return
     */
    Result stuffGetProject(int sId,int page,int pageSize);

    /**
     * 查询所有项目
     * @param page
     * @param pageSize
     * @return
     */
    Result getAllProject(int page,int pageSize);

    /**
     * 按照pId查询项目
     * @param pId
     * @return
     */
    Result getProjectBypId(int pId);

    /**
     * 获取项目文件路径
     * @param pId
     * @return
     */
    String getProjectFile(int pId);
}
