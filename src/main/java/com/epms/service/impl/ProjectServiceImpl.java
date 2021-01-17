package com.epms.service.impl;

import com.epms.dao.projectDao.ProjectDao;
import com.epms.dao.salaryDao.SalaryDao;
import com.epms.dao.selectProjectDao.SelectProjectDao;
import com.epms.entity.Project;
import com.epms.entity.Salary;
import com.epms.entity.SelectProject;
import com.epms.service.ProjectService;
import com.epms.utils.result.Result;
import com.epms.utils.upLoadFile.UploadFileUtil;
import com.epms.utils.upLoadFile.ZipUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectDao projectDao;
    private final SelectProjectDao selectProjectDao;

    public ProjectServiceImpl(ProjectDao projectDao, SelectProjectDao selectProjectDao) {
        this.projectDao = projectDao;
        this.selectProjectDao = selectProjectDao;
    }

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
            System.err.println(e);
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
            System.err.println(e);
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
            System.err.println(e);
            return Result.error().message("查询失败："+e.toString());
        }
    }

    @Override
    public Result stuffGetProject(int sId, int page, int pageSize) {
        try{
            List<Project> projects=projectDao.staffGetProject(sId);
            return paging(page, pageSize, projects);
        }catch (Exception e){
            System.err.println(e);
            return Result.error().message("查询失败："+e.toString());
        }
    }

    @Override
    public Result getAllProject(int page, int pageSize) {
        try{
            List<Project> projects=projectDao.queryAllProjects();
            return paging(page, pageSize, projects);
        }catch (Exception e){
            System.err.println(e);
            return Result.error().message("查询失败："+e.toString());
        }
    }

    private Result paging(int page, int pageSize, List<Project> projects) {
        List<Project> results=new ArrayList<Project>();
        for (int i = (page - 1) * pageSize; i < page * pageSize && i < projects.size(); i++) {
            results.add(projects.get(i));
        }
        return Result.ok().message("查询成功").data("commitLogList", results);
    }

    @Override
    public Result getProjectBypId(int pId) {
        try {
            Project project=projectDao.queryProjectBypId(pId);
            if(project!=null){
                return Result.ok().data("project",project);
            }else return Result.error().message("项目不存在");
        }catch (Exception e){
            System.err.println(e);
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

    @Override
    public Result managerUploadFile(int type, int pId, MultipartFile file) {
        try {
            String path = "";
            Project project=projectDao.queryProjectBypId(pId);
            if(project==null){
                return Result.error().message("上传文件失败：项目Id对应的项目不存在！！！");
            }
            if (type == 1&&project.getpPeriodStatus()==1) {
                path ="/Epms/"+project.getpName()+"/max/OriginalModel";
                String url= UploadFileUtil.upload(file,path);
                project.setpPeriodStatus(2);
            }
            else if(type==2&&project.getpPeriodStatus()==2){
                path="/Epms/"+project.getpName()+"/max/RenderModel";
                String url= UploadFileUtil.upload(file,path);
                project.setpPeriodStatus(3);

            }
            else if(type==3&&project.getpPeriodStatus()==2){
                path="/Epms/"+project.getpName()+ "/jpg";
                String url= UploadFileUtil.upload(file,path);
                project.setpPeriodStatus(4);
            }
            else return Result.error().message("上传文件失败：项目阶段错误");
            String fileName="/Epms/zipFile"+project.getpName()+".zip";
            FileOutputStream fos1 = new FileOutputStream(new File(fileName));
            ZipUtils.toZip(new File("/Epms/"+project.getpName()), fos1,true);
            project.setpFileUrl(fileName);
            projectDao.updateProject(project);
            return Result.ok().message("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error().message("文件读写错误");
        }catch (Exception e){
            e.printStackTrace();
            return Result.error().message("上传失败:"+e.toString());
        }
    }

    @Override
    public Result clientUploadFile(int cId, int pId, MultipartFile file) {
        try{
            Project project=projectDao.queryProjectBypId(pId);
            if(cId!=project.getcId()){
                return Result.error().message("项目客户错误!!!");
            }
            if(project==null){
                return Result.error().message("项目不存在!!!");
            }
            String path ="/Epms/"+project.getpName()+"/Material";
            UploadFileUtil.upload(file,path);
            String fileName="/Epms/zipFile"+project.getpName()+".zip";
            FileOutputStream fos1 = new FileOutputStream(new File(fileName));
            ZipUtils.toZip(new File("/Epms/"+project.getpName()+"/资料"), fos1,true);
            project.setpFileUrl(fileName);
            projectDao.updateProject(project);
            return Result.ok().message("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error().message("上传错误！！！："+e.toString());
        }
        catch (Exception e){
            System.err.println(e);
            return Result.error().message("上传错误！！！："+e.toString());
        }
    }

    @Override
    public Result clientSetPeriodStatus(int cId, int pId, int status) {
        try {
            Project project = projectDao.queryProjectBypId(pId);
            if (cId != project.getcId()) {
                return Result.error().message("设置错误:项目客户错误!!!");
            }
            if (project == null) {
                return Result.error().message("设置错误:项目不存在!!!");
            }
            if (status == 5 && project.getpPeriodStatus() != 4) {
                return Result.error().message("设置错误:项目未到完成阶段，无法验收项目!!!");
            } else {
                project.setpPeriodStatus(status);
                projectDao.updateProject(project);
                String message = "";
                switch (status) {
                    case 1:
                        message = "建模阶段";
                        break;
                    case 2:
                        message = "渲染阶段";
                        break;
                    case 3:
                        message = "后期阶段";
                        break;
                    case 4:
                        message = "完成阶段";
                        break;
                    case 5:
                        message = "验收成功";
                        break;
                }
                return Result.ok().message("设置成功:项目已设置成" + message);
            }
        } catch (Exception e) {
            return Result.error().message("设置错误：" + e.toString());
        }
    }

    @Override
    public String exportCsv(String url) {
        try{
            projectDao.generateFile(url);
            return url;
        }catch (Exception e){
            System.err.println(e.toString());
            return null;
        }
    }

}
