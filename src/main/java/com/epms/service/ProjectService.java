package com.epms.service;

import com.epms.entity.Project;
import com.epms.utils.result.Result;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * 主管上传项目文件
     * @param type ：1模型主管，2：渲染主管，3：后期主管；
     * @param pId 项目Id：
     * @param file 上传的文件；
     * @return
     */
    Result managerUploadFile(int type,int pId,MultipartFile file);

    /**
     * 客户上传资料
     * @param cId 客户的ID
     * @param pId 客户需要上传资料的项目的ID
     * @param file 客户上传的资料文件；
     * @return
     */
    Result clientUploadFile(int cId,int pId,MultipartFile file);

    /**
     * 客户确定项目状态
     * @param cId
     * @param pId
     * @param status 项目状态 1：建模阶段，2：渲染阶段；3：后期阶段，4完成阶段，5项目已完工；
     * @return
     */
    Result clientSetPeriodStatus(int cId,int pId,int status);
}
