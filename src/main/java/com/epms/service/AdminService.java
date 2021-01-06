package com.epms.service;

import com.epms.utils.result.Result;

public interface AdminService {
    /**
     * 主管创建项目时获取自己可以选择的员工和客户
     * @return
     */
    Result getChoose();


}
