package com.epms.service;

import com.epms.entity.Client;
import com.epms.utils.result.Result;

public interface ClientService {
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
    Result queryClientById(int id);

    /**
     *
     * @param client
     * @return 返回成功与否
     */
    Result addClient(Client client);

    /**
     *
     * @param client
     * @return 成功返回对应对象，失败返回错误原因
     * 更新客户信息
     */
    Result updateClient(Client client);

    /**
     *
     * @param page 页号
     * @param pageSize 页面尺寸
     * @return 返回对应页数所有的客户列表；
     */
    Result getAllClients(int page,int pageSize);

    /**
     * 按照关键字查询记录
     * @param keyWord
     * @return 返回对应页数所有的客户列表；
     */
    Result queryClientByKeyword(String keyWord,int page,int pageSize);
}
