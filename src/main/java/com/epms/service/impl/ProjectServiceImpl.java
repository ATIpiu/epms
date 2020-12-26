package com.epms.service.impl;

import com.epms.dao.projectDao.ProjectDao;
import com.epms.entity.Project;
import com.epms.service.ProjectService;
import com.epms.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

public class ProjectServiceImpl implements ProjectService {
    
    @Autowired
    private ProjectDao projectDao;

    @Override
    public Result managerAddProject(Project project) {
        try{
            if(projectDao.insertIntoProject(project)>0)
            {
                return Result.ok().message("插入成功！");
            }
            else return Result.error().message("插入失败：");
        }catch (DuplicateKeyException e){
            return Result.error().message("插入失败：项目编号已经存在！");
        }
        catch (Exception e){
            return Result.error().message("插入失败："+e.toString());
        }
    }

    @Override
    public Result managerUpdateProject(Project project) {
        try{
            if(projectDao.queryProjectBypId(project.getpId())==null){
                return Result.error().message("更新失败：无对应的项目！");
            }
            if(projectDao.updateProject(project)>0){
                return Result.ok().message("更新成功！");
            }
            else return Result.error().message("更新失败：");
        }catch (DuplicateKeyException e){
            return Result.error().message("更新失败：项目编号已经存在！");
        }
        catch (Exception e){
            return Result.error().message("更新失败："+e.toString());
        }
    }

    @Override
    public Result clientGetProject(int cId, int page, int pageSize) {
        return null;
    }

    @Override
    public Result stuffGetProject(int sId, int page, int pageSize) {
        return null;
    }

    @Override
    public Result getAllProject(int page, int pageSize) {
        return null;
    }
}
