-- system 用户之下执行如下脚本，会创建 vip 用户，并建立 account/emp

grant dba to vip identified by vip;

drop table vip.account;
drop table vip.types;

create table vip.types(
   tid number primary key,
   tname varchar2(30)
);

insert into vip.types(tid,tname) values(1,'学生');
insert into vip.types(tid,tname) values(2,'老师');
insert into vip.types(tid,tname) values(3,'校长');
commit;

create table vip.account(
	username varchar2(20) primary key,
	password varchar2(20) not null,
	acctype int not null,
	lastlogin timestamp,
	status int default 1, 
  constraint fk_acctype foreign key (acctype) references vip.types(tid)
);



insert into vip.account values ('aaa', 'aaa', 1, null, 1);
insert into vip.account values ('bbb', 'bbb', 2, null, 1);
insert into vip.account values ('ccc', 'ccc', 2, null, 1);
insert into vip.account values ('ddd', 'ddd', 3, null, 1);
commit;


create table vip.emp as select * from scott.emp;


select * from vip.account;
select * from vip.types;


alter table vip.account add birthday Date;


