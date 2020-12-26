package com.epms.service;

import com.epms.entity.Project;
import com.epms.utils.result.Result;

public interface ProjectService {
    Result managerAddProject(Project project);

    Result managerUpdateProject(Project project);

    Result clientGetProject(int cId,int page,int pageSize);

    Result stuffGetProject(int sId,int page,int pageSize);

    Result getAllProject(int page,int pageSize);


}
