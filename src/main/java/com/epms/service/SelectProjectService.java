package com.epms.service;

import com.epms.utils.result.Result;

public interface SelectProjectService {
    /**
     * 主管分配项目员工
     * @param pId 项目Id
     * @param sIds 员工Id数组
     * @return 返回结果成功与否
     */
    Result managerDistributeStaff(int pId,int[] sIds);


}
