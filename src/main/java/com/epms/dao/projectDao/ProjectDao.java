package com.epms.dao.projectDao;

import com.epms.entity.Project;

import java.util.List;

public interface ProjectDao {


    /**
     * @param project 参数为一个project类型的对象
     * @return int 若插入成功返回1，失败返回0；
     */
    int insertIntoProject(Project project);

    /**
     * @param pId 参数为项目对应的pId
     * @return int 若删除成功返回1，失败返回0；
     */
    int deleteProjectBypId(int pId);

    /**
     * @param pId 参数为一个整形Id
     * @return List<Project> 根据pId查询出的某条project(项目)记录
     */
    List<Project> queryProjectBypId(int pId);

    /**
     * @param cId 参数为一个整形Id
     * @return List<Project> 根据cId查询出的某条project(项目)记录
     */
    List<Project> queryProjectBycId(int cId);

    /**
     * 获取所有的项目（project）信息；
     *
     * @return List<Project> 所有的client信息
     */
    List<Project> queryAllProjects();

}


