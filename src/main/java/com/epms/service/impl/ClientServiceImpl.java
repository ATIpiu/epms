package com.epms.service.impl;

import com.epms.dao.clientDao.ClientDao;
import com.epms.entity.Client;
import com.epms.entity.Staff;
import com.epms.service.ClientService;
import com.epms.utils.result.Result;
import com.epms.utils.result.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    @Override
    public Result Login(String userName, String password) {
        try {
            Client client = clientDao.queryClientByUserName(userName);
            //查不到用户名对应的对象；
            if (client == null) {
                return Result.error(ResultCodeEnum.ERROR_NOT_EXISTS_USER);
            }
            //密码错误
            if (!client.getcPwd().equals(password)) {
                return Result.error(ResultCodeEnum.ERROR_PASSWORD);
            }
            client.setcPwd(null);
            return Result.ok(ResultCodeEnum.SUCCESS_LOGIN).data("client", client);
        } catch (Exception e) {
            return Result.error().message(e.toString());
        }
    }
}
