create database MessageInfo
go

use MessageInfo;

create table MessageInfo
(
	mid int identity primary key,
	mcontent varchar(200) not null,
	publish datetime default getdate() not null
);

insert into MessageInfo
values('���͹�״��������ȫ��󱬷��������ؽ���Σ��', '2020-12-1'),
	  ('���ǻ���������ӡ�� �����������ز���', '2020-12-1'),
	  ('"���˵���Ҳ����"������ʾ���Ա�������"', '2020-12-1')