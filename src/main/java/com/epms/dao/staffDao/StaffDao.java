package com.epms.dao.staffDao;

import com.epms.entity.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StaffDao {
    /**
     * 获取所有的员工（staff）信息；
     *
     * @return 所有的staff信息
     */
    List<Staff> queryAllStaffs();

    /**
     * @param staff 参数为一个Staff类型的对象
     * @return 若插入成功返回1，失败返回0
     */
    int insertIntoStaff(Staff staff);

    /**
     * @param sId 参数为一个整形Id
     * @return 为所查询的员工对象
     */
    Staff queryStaffBysId(int sId);

    /**
     * @param sUserName 参数为员工对应的UserName
     * @return 为所查询的员工对象
     */
    Staff queryStaffByUserName(String sUserName);

    /**
     * @param staff 传入要更新的Staff对象；
     * @return 更新成功返回1；失败则返回0；
     */
    int updateStaff(Staff staff);

}
