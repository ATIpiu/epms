package com.epms.service.impl;

import com.epms.dao.projectDao.ProjectDao;
import com.epms.dao.selectProjectDao.SelectProjectDao;
import com.epms.entity.Project;
import com.epms.entity.SelectProject;
import com.epms.service.ProjectService;
import com.epms.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private SelectProjectDao selectProjectDao;
    @Override
    public Result managerAddProject(Project project) {
        try{
            if(projectDao.insertIntoProject(project)>0)
            {
                SelectProject selectProject=new SelectProject(project.getpModelManagerId(),project.getpId());
                selectProjectDao.insertIntoSelectProject(selectProject);
                selectProject.setsId(project.getpAfterManagerId());
                selectProjectDao.insertIntoSelectProject(selectProject);
                selectProject.setsId(project.getpRenderManagerId());
                selectProjectDao.insertIntoSelectProject(selectProject);
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
        try{
            List<Project> projects=projectDao.queryProjectBycId(cId);
            List<Project> results=new ArrayList<Project>();
            for (int i = (page - 1) * pageSize; i < page * pageSize && i < projects.size(); i++) {
                results.add(projects.get(i));
            }
            return Result.ok().message("查询成功").data("projectList", results);
        }catch (Exception e){
            return Result.error().message("查询失败："+e.toString());
        }
    }

    @Override
    public Result stuffGetProject(int sId, int page, int pageSize) {
        try{
            List<Project> projects=projectDao.staffGetProject(sId);
            List<Project> results=new ArrayList<Project>();
            for (int i = (page - 1) * pageSize; i < page * pageSize && i < projects.size(); i++) {
                results.add(projects.get(i));
            }
            return Result.ok().message("查询成功").data("commitLogList", results);
        }catch (Exception e){
            return Result.error().message("查询失败："+e.toString());
        }
    }

    @Override
    public Result getAllProject(int page, int pageSize) {
        try{
            List<Project> projects=projectDao.queryAllProjects();
            List<Project> results=new ArrayList<Project>();
            for (int i = (page - 1) * pageSize; i < page * pageSize && i < projects.size(); i++) {
                results.add(projects.get(i));
            }
            return Result.ok().message("查询成功").data("commitLogList", results);
        }catch (Exception e){
            return Result.error().message("查询失败："+e.toString());
        }
    }

    @Override
    public Result getProjectBypId(int pId) {
        try {
            Project project=projectDao.queryProjectBypId(pId);
            if(project!=null){
                return Result.ok().data("project",project);
            }else return Result.error().message("项目不存在");
        }catch (Exception e){
            return Result.error().message("查询失败："+e.toString());
        }
    }

    @Override
    public String getProjectFile(int pId) {
        try{
            return projectDao.getProjectFile(pId);
        }
        catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }
}
