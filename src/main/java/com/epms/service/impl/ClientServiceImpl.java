package com.epms.service.impl;

import com.epms.dao.clientDao.ClientDao;
import com.epms.entity.Client;
import com.epms.service.ClientService;
import com.epms.utils.result.Result;
import com.epms.utils.result.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        } catch (DuplicateKeyException e){
            return null;
        } catch (Exception e) {
            return Result.error().message("登录失败："+e.toString());
        }
    }

    @Override
    public Result queryClientById(int id) {
        try{
            Client client =clientDao.queryClientById(id);
            if(client==null){
                return Result.error(ResultCodeEnum.ERROR_NOT_EXISTS_USER);
            }
            else {
                client.setcPwd(null);
                return Result.ok().data("client",client);
            }
        }catch (Exception e){
            return Result.error().message("查询失败:"+e.toString());
        }
    }

    @Override
    public Result addClient(Client client) {
        try {
            clientDao.insertIntoClient(client);
            return Result.ok(ResultCodeEnum.SUCCESS).message("添加成功");
        } catch (DuplicateKeyException e){
            return Result.ok(ResultCodeEnum.ERROR_USERNAME_EXIST).message("添加失败：用户名或用户编号已经存在");
        } catch (Exception e) {
            return Result.error().message("添加失败："+e.toString());
        }
    }

    @Override
    public Result updateClient(Client client) {
        try {
            clientDao.updateClient(client);
            return Result.ok(ResultCodeEnum.SUCCESS).message("成功更新");
        } catch (DuplicateKeyException e){
            return Result.ok(ResultCodeEnum.ERROR_USERNAME_EXIST);
        } catch (Exception e) {
            return Result.error().message("更新失败："+e.toString());
        }
    }

    @Override
    public Result getAllClients(int page, int pageSize) {
        try{
            List<Client> clients=clientDao.queryAllClients();
            List<Client> results = new ArrayList<Client>();
            for(int i=(page-1)*pageSize;i<page*pageSize&&i<clients.size();i++){
                clients.get(i).setcPwd(null);
                results.add(clients.get(i));
            }
            return Result.ok().message("查询成功").data("clientList",results);
        }catch (Exception e){
            return Result.error().message("查询失败："+e.toString());
        }
    }
}
