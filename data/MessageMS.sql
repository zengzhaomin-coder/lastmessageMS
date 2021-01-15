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
values('新型冠状病毒肺炎全球大爆发引发严重金融危机', '2020-12-1'),
	  ('东非蝗灾蔓延至印尼 尼日利亚神秘病毒', '2020-12-1'),
	  ('"黑人的命也是命"反暴力示威以暴力告终"', '2020-12-1')