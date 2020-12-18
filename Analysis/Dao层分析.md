数据库操作：

1 ，登录：按照类别查询Client或者Stuff表。完成登录校验；

2，前台：Client和Stuff的增删改查；

3，主管：对Project表的增删改查；对selectProject表增删改查；commitLog的查看和修改功能；有Salary的除开考勤的增删改查，不能管理主管类型员工的记录；

4，员工：联合SelectProject和Project表查询自己负责的项目信息；CommitLog的增删改查；按照自己Id查询Salary表；

5，客户：联合CommitLog和Project表查询提交记录；对Client修改自己的信息；对CommitLog的修改记录；可通过ClientID查询Project；

6，管理员：有Salary的增删改查功能；

