### Code的所有类型

### ![在这里插入图片描述](https://img-blog.csdnimg.cn/20201230111300483.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0MTY2OTQ2,size_16,color_FFFFFF,t_70)

**URL**:http://localhost:8080/Login

**传入参数列表**：

| 参数名   | 描述                     |
| -------- | ------------------------ |
| userName     | 用户账号                 |
| password     | 用户密码  |
| type | 用户类型 |

**返回参数列表**:

| 参数名      | 描述                 |
| ----------- | -------------------- |
| success  | 此次请求是否成功(true Or false) |
| code     | 此次请求的结果      |
| message     | 此次请求的信息 |
| Client Or Staff | 根据登录的用户类型返回对应的实体类 |


### Client:客户所有接口

#### 1：用户获取自己的所有项目信息

**URL**:http://localhost:8080/client/GetProject

**传入参数列表**：

| 参数名   | 描述                     |
| -------- | ------------------------ |
| cId      | 用户的Id                 |
| page     | 查询的页数(不传默认为1)  |
| pageSize | 查询的页数大小(默认为20) |

**返回参数列表**:

| 参数名      | 描述                 |
| ----------- | -------------------- |
| success  | 此次请求是否成功(true Or false) |
| code     | 此次请求的结果      |
| message     | 此次请求的信息 |
| projectList | 成功则返回用户所拥有的项目列表 |

#### 2:用户修改自己的个人信息

**URL**:http://localhost:8080/client/updateInfo

**传入参数列表**：

| 参数名 | 描述                               |
| ------ | ---------------------------------- |
| client | 对应的客户实体(客户Id一定不能为空) |

**返回参数列表**:

| 参数名  | 描述                            |
| ------- | ------------------------------- |
| success | 此次请求是否成功(true Or false) |
| code    | 此次请求的结果                  |
| message | 此次请求的信息                  |

#### 3:客户查看提交给自己项目提交记录

**URL**:http://localhost:8080/client/GetCommitLog
**传入参数列表**：

| 参数名   | 描述                     |
| -------- | ------------------------ |
| cId      | 用户的Id                 |
| page     | 查询的页数(不传默认为1)  |
| pageSize | 查询的页数大小(默认为20) |

**返回参数列表**:

| 参数名      | 描述                 |
| ----------- | -------------------- |
| success  | 此次请求是否成功(true Or false) |
| code     | 此次请求的结果      |
| message     | 此次请求的信息 |
| commitLogList | 成功则返回提交给用户的提交记录 |

#### 4:客户审核提交给自己项目提交记录

**URL**:http://localhost:8080/client/checkCommitLog **ps：不能用ajax请求，请求时需要加上token和timestamp**
**传入参数列表**：

| 参数名    | 描述               |
| --------- | ------------------ |
| commitLog | 修改过后的提交记录 |

**返回参数列表**:

| 参数名      | 描述                 |
| ----------- | -------------------- |
| success  | 此次请求是否成功(true Or false) |
| code     | 此次请求的结果      |
| message     | 此次请求的信息 |
#### 5:客户上传资料文件

**URL**:http://localhost:8080/client/UploadFile
**传入参数列表**：

| 参数名 | 描述                     |
| ------ | ------------------------ |
| cId    | 用户的Id                 |
| pId    | 客户要上传资料的项目的ID |
| file   | 客户上传的资料文件       |

**返回参数列表**:

| 参数名      | 描述                 |
| ----------- | -------------------- |
| success  | 此次请求是否成功(true Or false) |
| code     | 此次请求的结果      |
| message     | 此次请求的信息 |

#### 6:客户修改项目状态

**URL**:http://localhost:8080/client/setProjectPeriodStatus
**传入参数列表**：

| 参数名 | 描述                                                         |
| ------ | ------------------------------------------------------------ |
| cId    | 用户的Id                                                     |
| pId    | 客户要上传资料的项目的ID                                     |
| status | d对应项目的状态信息（1：建模阶段，2：渲染阶段；3：后期阶段；4：完成阶段；5：验收成功； |

**返回参数列表**:

| 参数名      | 描述                 |
| ----------- | -------------------- |
| success  | 此次请求是否成功(true Or false) |
| code     | 此次请求的结果      |
| message     | 此次请求的信息 |