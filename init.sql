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

insert into account values ('hello', 'man', 1, null, 1);

commit;