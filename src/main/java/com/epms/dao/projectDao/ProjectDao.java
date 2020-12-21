package com.epms.dao.projectDao;

import com.epms.entity.Client;
import com.epms.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
import java.util.Map;

public interface ProjectDao {


    /**
     * @param project 参数为一个project类型的对象
     * @return int 若插入成功返回1，失败返回0；
     */
    int insertIntoProject(Project project);

    /**
     * @param map 参数为项目对应的pId
     * @return int 若删除成功返回1，失败返回0；
     */
    int deleteProjectBypId(Map<String,Object> map);


    /**
     *
     * @param project 要更新的project对象，必须包含pId
     * @return 成功更新返回1，失败返回0
     */
    int updateProject(Project project);

    /**
     * @param map 参数为一个整形Id
     * @return Project 根据pId查询出的某条project(项目)记录
     */
    Project queryProjectBypId(Map<String,Object> map);

    /**
     * @param map 参数为一个整形Id
     * @return List<Project> 根据cId查询出的某条project(项目)记录
     */
    List<Project> queryProjectBycId(Map<String,Object> map);

    /**
     * 获取所有的项目（project）信息；
     * @return List<Project> 所有的client信息
     */
    List<Project> queryAllProjects();

}



