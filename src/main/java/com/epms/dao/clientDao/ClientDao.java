package com.epms.dao.clientDao;

import com.epms.entity.Client;
import com.epms.entity.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
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

    /**
     *
     * @param client 要更新的Client对象，必须包含cId
     * @return 成功更新返回1，失败返回0
     */
    int updateClient(Client client);

    /**
     * 全字段模糊查询
     * @param keyWord 关键字
     * @return 返回符合要求的Staff对象
     */
    List<Client> queryClientByKeyword(String keyWord);



    /**
     * 将数据导出成报表
     * @param url ：本地路径；
     * @return
     */
    Integer generateFile(String url);
}
