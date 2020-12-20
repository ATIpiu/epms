package com.epms.dao.uploadFileLogDao;

import com.epms.entity.UploadFileLog;

import java.util.List;

public interface UploadFileLogDao {
    /**
     * @param uploadFileLog 参数为一个UploadFileLog类型的对象
     * @return int 若插入成功返回1，失败返回0；
     */
    int insertIntoUploadFileLog(UploadFileLog uploadFileLog);

    /**
     * @param uploadFileLog 参数为一次提交的记录
     * @return int 若删除成功返回1，失败返回0；
     */
    int deleteUploadFileLog(UploadFileLog uploadFileLog);

    /**
     * @param uploadFileLog 参数为一次提交的记录
     * @return int 若更新成功返回1，失败返回0；
     */
    int updateUploadFileLog(UploadFileLog uploadFileLog);

    /**
     * 获取上传日志（UploadFileLog）信息；
     *
     * @return list<UploadFileLog> 根据员工sId查询上传日志(UploadFileLog)信息
     */
    List<UploadFileLog> queryUploadFileLogsBysId(int sId);

    /**
     * 获取上传日志（UploadFileLog）信息；
     *
     * @return list<UploadFileLog> 根据项目pId查询所有的上传日志(UploadFileLog)信息
     */
    List<UploadFileLog> queryUploadFileLogsBypId(int pId);

    /**
     * 获取所有的上传日志（UploadFileLog）信息；
     *
     * @return list<UploadFileLog> 所有的上传日志(UploadFileLog)信息
     */
    List<UploadFileLog> queryAllUploadFileLogs();

}
