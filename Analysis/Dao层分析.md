数据库操作：

1，登录：按照类别查询Client或者Stuff表。完成登录校验；

2，前台：Client和Stuff的增删改查；

3，主管：对Project表的增删改查；对selectProject表增删改查；联合commitLog和Project表的查看和修改功能；有Salary的除开考勤的增删改查，不能管理主管类型员工的记录；

4，员工：联合SelectProject和Project表查询自己负责的项目信息；CommitLog的增删改查；按照自己Id查询Salary表；

5，客户：联合CommitLog和Project表查询提交记录；对Client修改自己的信息；对CommitLog的修改记录；可通过ClientID查询Project；

6，管理员：有Salary的增删改查功能;

- 多表操作：
1. List<Project> staffGetProject(int sId) 员工查询自己所负责项目的列表
   员工号(sId) => 表selectproject找到项目pId => 表project找到项目
   
2. List<CommitLog> clientGetCommitLog(int cId) 客户查询员工提交记录
   客户号(cId) => 表project找到项目pId => 表commitlog 根据pId和type找到commit记录
   
3. List<CommitLog> managerGetCommitLog(int sId, int type) 主管查询员工提交记录
   员工号(sId) => 表project找到项目pId => 表commitlog 根据pId和type找到commit记录

