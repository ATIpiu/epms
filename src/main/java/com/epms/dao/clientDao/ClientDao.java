package com.epms.dao.clientDao;

import com.epms.entity.Client;

import java.util.List;

public interface ClientDao {
    /**
     * 获取所有的客户（client）信息；
     *
     * @return:list<client>:所有的client信息
     */
    List<Client> queryAllClients();

    /**
     * @param client 参数为一个client类型的对象
     * @return：若插入成功返回1，失败返回0；
     */
    int insertIntoClient(Client client);
    /**
     * @param cId 参数为一个整形Id
     * @return：client:为所查询的客户对象
     */
    Client queryClientById(int cId);
    /**
     * @param cUserName 参数为客户对应的UserName
     * @return：client:为所查询的客户对象
     */
    Client queryClientByUserName(String cUserName);


}
