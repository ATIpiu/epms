package com.epms.service;

import com.epms.entity.Staff;
import com.epms.utils.result.Result;

public interface StaffService {
    /**
     *
     * @param userName
     * @param password
     * @return 成功返回对应对象，失败返回错误原因
     */
    Result Login(String userName, String password);

    /**
     *
     * @param id
     * @return 成功返回对应对象，失败返回错误原因
     */
    Result queryStaffById(int id);

    /**
     *
     * @param staff
     * @return 返回成功与否
     */
    Result addStaff(Staff staff);

    /**
     *
     * @param staff
     * @return 成功返回对应对象，失败返回错误原因
     * 更新客户信息
     */
    Result updateStaff(Staff staff);

    /**
     *
     * @param page 页号
     * @param pageSize 页面尺寸
     * @return 返回对应页数所有的客户列表；
     */
    Result getAllStaffs(int page,int pageSize);

    /**
     *
     * @param pId 项目Id
     * @param type 主管类型 1：模型，2：渲染：3：后期 ;11:管理员获取主管
     * @param page
     * @param pageSize
     * @return
     */
    Result managerGetOwnStaff(int pId,int type,int page,int pageSize);

    /**
     * 按照关键字查询记录
     * @param keyWord
     * @return 返回对应页数所有的员工列表；
     */
    Result queryStaffByKeyword(String keyWord,int page,int pageSize);
}
