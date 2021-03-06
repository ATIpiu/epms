package com.epms.service.impl;

import com.epms.dao.clientDao.ClientDao;
import com.epms.dao.salaryDao.SalaryDao;
import com.epms.dao.staffDao.StaffDao;
import com.epms.entity.Client;
import com.epms.entity.Staff;
import com.epms.service.AdminService;
import com.epms.service.UploadFileLogService;
import com.epms.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    private final StaffDao staffDao;
    private final ClientDao clientDao;

    public AdminServiceImpl(StaffDao staffDao, ClientDao clientDao) {
        this.staffDao = staffDao;
        this.clientDao = clientDao;
    }


    @Override
    public Result getChoose() {
        try {
            List<Staff> staffList = staffDao.queryAllStaffs();
            List<Client> clientList =clientDao.queryAllClients();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("staffList", staffList);
            map.put("clientList", clientList);
            return Result.ok().data(map);
        }catch (Exception e){
            return Result.error().message("查询失败："+e.toString());
    }
}
}
