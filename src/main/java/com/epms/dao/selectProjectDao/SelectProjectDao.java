package com.epms.dao.selectProjectDao;

import com.epms.entity.SelectProject;

import java.util.List;
import java.util.Map;

public interface SelectProjectDao {
    /**
     * @param selectProject 参数为一个SelectProject类型的对象
     * @return int 若插入成功返回1，失败返回0；
     */
    int insertIntoSelectProject(SelectProject selectProject);

    /**
     * @param map  里面含有put进去的"spId"与其值
     * @return int 若删除成功返回1，失败返回0；
     */
    int deleteSelectProjectByspId(Map<String,Object> map);

    /**
     * @param selectProject 参数为一个SelectProject类型的对象
     * @return int 若更改成功返回1，失败返回0；
     */
    int updateSelectProject(SelectProject selectProject);


    /**
     * @param sId 参数为一个整形Id
     * @return List<SelectProject> 根据sId查询出的员工选项目的记录
     */
    List<SelectProject> querySelectProjectBysId(int sId);

    /**
     * @param pId 参数为一个整形Id
     * @return List<SelectProject> 根据pId查询出的员工选项目的记录
     */
    List<SelectProject> querySelectProjectBypId(int pId);

    /**
     * @param spId 参数为一个整形Id
     * @return SelectProject 根据spId查询出的员工选项目的记录
     */
    SelectProject querySelectProjectByspId(int spId);

    /**
     * 获取所有的员工选项目的记录信息；
     *
     * @return list<SelectProject> 所有的员工选项目的记录信息
     */
    List<SelectProject> queryAllSelectProjects();

}
