# 创建数据库并进入数据库
create database test1;
use test1;
# 创建一张t_user表
create table t_user
(
    id       bigint primary key auto_increment,
    username varchar(32),
    password varchar(64)
);

insert into t_user (username, password)
values ('zhangsan', '1234'),
       ('lisi', '4321');