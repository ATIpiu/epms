package com.epms.service.impl;

import com.epms.dao.staffDao.StaffDao;
import com.epms.entity.Staff;
import com.epms.service.StaffService;
import com.epms.utils.result.Result;
import com.epms.utils.result.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class StaffServiceImpl implements StaffService {
//    @Autowired
    private StaffDao staffDao;

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    public Result Login(String userName, String password) {
        try {
            Staff staff=staffDao.queryStaffByUserName(userName);
            //查不到用户名对应的对象；
            if(staff==null){
                return Result.error(ResultCodeEnum.ERROR_NOT_EXISTS_USER);
            }
            //密码错误
            if(!staff.getsPwd().equals(password)){
                return Result.error(ResultCodeEnum.ERROR_PASSWORD);
            }
            return Result.ok(ResultCodeEnum.SUCCESS_LOGIN).data("staffInfo",staff);
        }
        catch (Exception e){
            return Result.error().message(e.toString());
        }
    }
}
