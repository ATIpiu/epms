package com.epms.service.impl;

import com.epms.dao.clientDao.ClientDao;
import com.epms.dao.staffDao.StaffDao;
import com.epms.entity.Staff;
import com.epms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl implements LoginService {
    @Autowired
    private ClientDao clientDao;
    private StaffDao staffDao;

}
