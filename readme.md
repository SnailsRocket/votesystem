## 投票系统

### 需求分析
创建投票页面  -- 设置投票内容 设置截止时间 (暂时不限制投票人)
投票页面  -- 投票到指定时间会过期，过期不可投
投票详情页 -- 点击某一个具体的投票选项，倒序展示投票人以及投票时间

登录(不需要登录) 通过手机号作为标识(头像、昵称)  -- 后期迭代



### DB设计
#### user 用户表 
```sql
id          int     8     主键
name        varchar 50    姓名
tel         varchar 20    手机号
image       varchar 255   头像   -- 这个后面需要部署一个文件服务器存放图片
address     varchar 255   地址 
label       varchar 255   标签
del_status  int     8     删除状态
createTime  timestamp     创建时间
```

#### vote_content 投票表
```sql
id                  int         8       主键
content             varchar     50      投票主题
expired_status      int         8       过期状态
expired_time        timestamp           过期时间  不设置 默认 24小时
del_status          int         8       删除状态
create_time
create_user
update_time
update_user
```

#### vote_content_options 投票选项表
```sql
id                  int         8       主键
vote_description    varchar     255     投票内容
vote_id             int         8       投票表Id
del_status          int         8       删除状态
create_time
create_user
update_time
update_user
```

#### option_user 用户投票选项表   
```sql
option_id
user_id
del_status
create_time
```






### 技术选型

### 接口设计

 