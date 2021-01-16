### admin:管理员接口（其它别的地方有的接口就不写了）

#### 1：打印报表：应该看得懂吧每个Url是啥

**URL**:http://localhost:8080/download/projectCsv

**URL**:http://localhost:8080/download/clientCsv

**URL**:http://localhost:8080/download/commitLogCsv

**URL**:http://localhost:8080/download/salarylogCsv

**URL**:http://localhost:8080/download/staffCsv

**URL**:http://localhost:8080/download/wageCsv

**传入参数列表**：token和timestamp；

**返回参数列表**:无返回参数，成功即下载文件
#### 2：管理员获取所有项目信息

**URL**:http://localhost:8080/admin/getAllProject

**传入参数列表**：

| 参数名   | 描述                     |
| -------- | ------------------------ |
| page     | 查询的页数(不传默认为1)  |
| pageSize | 查询的页数大小(默认为20) |

**返回参数列表**:

| 参数名      | 描述                 |
| ----------- | -------------------- |
| success  | 此次请求是否成功(true Or false) |
| code     | 此次请求的结果      |
| message     | 此次请求的信息 |
| projectList | 成功则返回所有的项目列表 |
#### 3：管理员修改项目信息

**URL**:http://localhost:8080/admin/updateProject

**传入参数列表**：

| 参数名   | 描述                     |
| -------- | ------------------------ |
| project     | 修改的项目实体 |

**返回参数列表**:

| 参数名      | 描述                 |
| ----------- | -------------------- |
| success  | 此次请求是否成功(true Or false) |
| code     | 此次请求的结果      |
| message     | 此次请求的信息 |
#### 4：管理员获取所有绩效信息

**URL**:http://localhost:8080/admin/getAllSalary

**传入参数列表**：

| 参数名   | 描述                     |
| -------- | ------------------------ |
| page     | 查询的页数(不传默认为1)  |
| pageSize | 查询的页数大小(默认为20) |

**返回参数列表**:

| 参数名      | 描述                 |
| ----------- | -------------------- |
| success  | 此次请求是否成功(true Or false) |
| code     | 此次请求的结果      |
| message     | 此次请求的信息 |
| salaryList | 成功则返回所有的工资列表 |
#### 5：管理员修改项目信息

**URL**:http://localhost:8080/admin/updateSalary

**传入参数列表**：

| 参数名   | 描述                     |
| -------- | ------------------------ |
| Salary     | 对应的工资实体|

**返回参数列表**:

| 参数名      | 描述                 |
| ----------- | -------------------- |
| success  | 此次请求是否成功(true Or false) |
| code     | 此次请求的结果      |
| message     | 此次请求的信息 |

#### 6：管理员获取所有工资记录

**URL**:http://localhost:8080/admin/getAllWage

**传入参数列表**：

| 参数名   | 描述                     |
| -------- | ------------------------ |
| page     | 查询的页数(不传默认为1)  |
| pageSize | 查询的页数大小(默认为20) |

**返回参数列表**:

| 参数名      | 描述                 |
| ----------- | -------------------- |
| success  | 此次请求是否成功(true Or false) |
| code     | 此次请求的结果      |
| message     | 此次请求的信息 |
| wageList | 成功则返回所有的工资 |
#### 7：管理员修改工资

**URL**:http://localhost:8080/admin/updateWage

**传入参数列表**：

| 参数名   | 描述                     |
| -------- | ------------------------ |
| wage     | 修改的工资实体 |

**返回参数列表**:

| 参数名      | 描述                 |
| ----------- | -------------------- |
| success  | 此次请求是否成功(true Or false) |
| code     | 此次请求的结果      |
| message     | 此次请求的信息 |
#### 8：管理员获取所有工资记录

**URL**:http://localhost:8080/admin/getAllUploadFileLog

**传入参数列表**：

| 参数名   | 描述                     |
| -------- | ------------------------ |
| page     | 查询的页数(不传默认为1)  |
| pageSize | 查询的页数大小(默认为20) |

**返回参数列表**:

| 参数名      | 描述                 |
| ----------- | -------------------- |
| success  | 此次请求是否成功(true Or false) |
| code     | 此次请求的结果      |
| message     | 此次请求的信息 |
| uploadFileLog | 返回所有 |