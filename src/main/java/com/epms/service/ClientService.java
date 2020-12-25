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


    Result updateClient(Client client);
}
