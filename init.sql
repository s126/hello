-- 在 system 用户之下执行如下脚本，会创建 vip 用户，并建立 account/emp 表

grant dba to vip identified by vip;

drop table vip.account;
create table vip.account
(
	username varchar2(20) primary key,
	password varchar2(20) not null,
	acctype int not null,
	lastlogin timestamp,
	status int default 1
);

create table vip.emp as select * from scott.emp;

insert into vip.account values ('aaa', 'aaa', 1, null, 1);
insert into vip.account values ('hello', 'man', 2, null, 1);

commit;

