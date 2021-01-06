package com.epms.service.impl;

import com.epms.dao.clientDao.ClientDao;
import com.epms.dao.staffDao.StaffDao;
import com.epms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServiceImpl implements AdminService {
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private ClientDao clientDao;


}
