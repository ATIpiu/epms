package com.epms.dao.staffDao;

import com.epms.entity.Staff;

import java.util.List;

public interface StaffDao {
    /**
     * 获取所有的员工（staff）信息；
     *
     * @return:list<Staff>:所有的staff信息
     */
    List<Staff> queryAllStaffs();

    /**
     * @param staff 参数为一个Staff类型的对象
     * @return：若插入成功返回1，失败返回0；
     */
    int insertIntoStaff(Staff staff);
    /**
     * @param sId 参数为一个整形Id
     * @return：Staff:为所查询的员工对象
     */
    Staff queryStaffById(int sId);
    /**
     * @param sUserName 参数为员工对应的UserName
     * @return：Staff:为所查询的员工对象
     */
    Staff queryStaffByUserName(String sUserName);


}
