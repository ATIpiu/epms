package com.epms.service.impl;

import com.epms.dao.CheckOnDao.CheckOnDao;
import com.epms.dao.staffDao.StaffDao;
import com.epms.entity.CheckOn;
import com.epms.entity.Staff;
import com.epms.service.StaffService;
import com.epms.utils.result.Result;
import com.epms.utils.result.ResultCodeEnum;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
    private final StaffDao staffDao;
    private final CheckOnDao checkOnDao;

    public StaffServiceImpl(StaffDao staffDao, CheckOnDao checkOnDao) {
        this.staffDao = staffDao;
        this.checkOnDao = checkOnDao;
    }

    @Override
    public Result Login(String userName, String password) {
        try {
            Staff staff = staffDao.queryStaffByUserName(userName);
            //查不到用户名对应的对象；
            if (staff == null) {
                return Result.error(ResultCodeEnum.ERROR_NOT_EXISTS_USER);
            }
            //密码错误
            if (!staff.getsPwd().equals(password)) {
                return Result.error(ResultCodeEnum.ERROR_PASSWORD);
            }
            staff.setsPwd(null);
            return Result.ok(ResultCodeEnum.SUCCESS_LOGIN).data("staff", staff);
        } catch (DuplicateKeyException e) {
            return null;
        } catch (Exception e) {
            return Result.error().message("登录失败：" + e.toString());
        }
    }

    @Override
    public String monitorLogin(String userName, String password, String ip) {
        try {
            Staff staff = staffDao.queryStaffByUserName(userName);
            //查不到用户名对应的对象；
            if (staff == null) {
                return "登录失败@用户不存在";
            }
            //密码错误
            if (!staff.getsPwd().equals(password)) {
                return "登录失败@密码错误";
            }
            CheckOn checkOn = new CheckOn(ip, staff.getsId(), 0.0, new java.sql.Date(System.currentTimeMillis()));
            CheckOn checkOn1 = checkOnDao.getToday(checkOn);
            if (checkOn1 == null)
                checkOnDao.insertIntoCheckOn(checkOn);
            return "登录成功@" + staff.getsName();
        } catch (Exception e) {
            return "登录失败@" + e.toString();
        }
    }

    @Override
    public String updateWorkTime(String userName,double workTime) {
        try {
            Staff staff = staffDao.queryStaffByUserName(userName);
            CheckOn checkOn = new CheckOn("", staff.getsId(), workTime,new java.sql.Date(System.currentTimeMillis()) );
            checkOnDao.updateWorkTime(checkOn);
            return "提交成功！@";
        }catch (Exception e){
            return "提交失败@：请联系管理员记录";
        }

    }

    @Override
    public Result queryStaffById(int id) {
        try {
            Staff staff = staffDao.queryStaffBysId(id);
            if (staff == null) {
                return Result.error(ResultCodeEnum.ERROR_NOT_EXISTS_USER);
            } else {
                staff.setsPwd(null);
                return Result.ok().data("staff", staff);
            }
        } catch (Exception e) {
            System.err.println(e);
            return Result.error().message("查询失败:" + e.toString());
        }
    }

    @Override
    public Result addStaff(Staff staff) {
        try {
            staffDao.insertIntoStaff(staff);
            return Result.ok(ResultCodeEnum.SUCCESS).message("添加成功");
        } catch (DuplicateKeyException e) {
            return Result.ok(ResultCodeEnum.ERROR_USERNAME_EXIST).message("添加失败：用户名或用户编号已经存在");
        } catch (Exception e) {
            return Result.error().message("添加失败：" + e.toString());
        }
    }

    @Override
    public Result updateStaff(Staff staff) {
        try {
            staffDao.updateStaff(staff);
            return Result.ok(ResultCodeEnum.SUCCESS).message("成功更新");
        } catch (DuplicateKeyException e) {
            return Result.ok(ResultCodeEnum.ERROR_USERNAME_EXIST);
        } catch (Exception e) {
            return Result.error().message("更新失败：" + e.toString());
        }
    }

    @Override
    public Result getAllStaffs(int page, int pageSize) {
        try {
            List<Staff> staffs = staffDao.queryAllStaffs();
            return paging(page, pageSize, staffs);
        } catch (Exception e) {
            System.err.println(e);
            return Result.error().message("查询失败：" + e.toString());
        }
    }

    @Override
    public Result managerGetOwnStaff(int type, int page, int pageSize) {
        try {
            List<Staff> staffs = staffDao.managerGetOwnStaff(type);
            return paging(page, pageSize, staffs);
        } catch (Exception e) {
            System.err.println(e);
            return Result.error().message("查询失败：" + e.toString());
        }
    }

    @Override
    public Result managerGetOwnProjectStaff(int pId, int type, int page, int pageSize) {
        try {
            List<Staff> staffs = staffDao.managerGetOwnProjectStaff(pId, type);
            return paging(page, pageSize, staffs);
        } catch (Exception e) {
            System.err.println(e);
            return Result.error().message("查询失败：" + e.toString());
        }
    }

    @Override
    public Result queryStaffByKeyword(String keyWord, int page, int pageSize) {
        try {
            List<Staff> staffs = staffDao.queryStaffByKeyword(keyWord);
            return paging(page, pageSize, staffs);
        } catch (Exception e) {
            System.err.println(e);
            return Result.error().message("查询失败：" + e.toString());
        }
    }

    private Result paging(int page, int pageSize, List<Staff> staffs) {
        List<Staff> results = new ArrayList<Staff>();
        for (int i = (page - 1) * pageSize; i < page * pageSize && i < staffs.size(); i++) {
            staffs.get(i).setsPwd(null);
            results.add(staffs.get(i));
        }
        return Result.ok().message("查询成功").data("staffList", results);
    }

    @Override
    public String exportCsv(String url) {
        try {
            staffDao.generateFile(url);
            return url;
        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
    }
}
