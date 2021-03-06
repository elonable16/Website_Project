create table customer(
u_num int not null,
id varchar(20) not null primary key,
email varchar(30) not null,
passwd varchar(30) not null,
phone varchar(15) not null,
signin varchar(20) not null,
signout varchar(20),
u_name varchar(20) not null,
ip varchar(30) not null);

CREATE TABLE master_seq(
     id int not null, 
     seq_name varchar(50) not null
 );
 
DELIMITER $$
CREATE FUNCTION get_seq (p_seq_name VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE master_seq SET id = LAST_INSERT_ID(id+1)
WHERE seq_name = p_seq_name;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN RESULT_ID;
END $$
DELIMITER ;

set global log_bin_trust_function_creators = on;

insert into master_seq values(0,'seq_custom');
select * from master_seq;
delete from master_seq WHERE seq_name='seq_costom';
update master_seq set seq_name = 'seq_custom' where seq_name ='seq_costom';

insert into customer values(get_seq('seq_custom'),'test2','test2@gmail.com','1234','010-0000-0000','customer2020-09-31','','test2','192.168.0.225');

select * from customer;

create table webadmin(
ad_num int not null,
ad_id varchar(20) not null primary key,
ad_passwd varchar(30) not null,
ad_name varchar(20) not null,
ad_ip varchar(30) not null
);
insert into master_seq values(0,'seq_webadmin');

create table notice (
n_num int not null primary key,
n_category varchar(20) not null,
ad_id varchar(20) not null,
n_contents varchar(3000) not null,
n_datefirst varchar(20) not null,
n_datelast varchar(20),
n_cnt int not null,
n_ip int not null,
foreign key (ad_id) references webadmin(ad_id) 
);
ALTER TABLE `website`.`notice` CHANGE COLUMN `n_ip` `n_ip` VARCHAR(30) NOT NULL ;
ALTER TABLE `website`.`notice` ADD COLUMN `n_subject` VARCHAR(200) NOT NULL AFTER `n_ip`;
insert into master_seq values(0,'seq_notice');
create table guestbook_main(
	gm_num int not null primary key,
    gm_name varchar(20) not null,
    gm_subject varchar(100) not null,
    gm_content varchar(3000) not null,
    gm_passwd varchar(30) not null,
    gm_datew varchar(20) not null,
    gm_dateu varchar(20),
    gm_ip varchar(30) not null
);
insert into master_seq values(0,'seq_gm');
create table guestbook_sub(
	gs_num int not null primary key,
    gm_num int not null,
    gs_name varchar(20) not null,
    gs_contents varchar(400) not null,
    gs_datew varchar(20) not null,
    gs_dateu varchar(20),
    gs_ip varchar(30) not null,
    foreign key(gm_num) references guestbook_main(gm_num)
    );
insert into master_seq values(0,'seq_gs');

create table qna(
q_num int not null primary key,
q_category varchar(20) not null,
id varchar(20) not null,
q_subject varchar(100) not null,
q_contents varchar(3000) not null,
q_datew varchar(20) not null,
q_dateu varchar(20),
q_ip varchar(30) not null,
foreign key(id) references customer(id)
);

insert into master_seq values(0,'seq_qna');
create table answer(
qa_num int not null primary key,
q_num int not null,
ad_id varchar(20) not null,
qa_date varchar(20) not null,
qa_contents varchar(2000) not null,
foreign key(q_num) references qna(q_num),
foreign key(ad_id) references webadmin(ad_id)
);
insert into master_seq values(0,'seq_answer');


create table product (
p_code int not null primary key,
p_class int not null,
p_name varchar(40) not null,
p_stock int not null,
p_grade float not null,
p_price int not null,
p_image1 varchar(20),
p_image2 varchar(20),
p_image3 varchar(20),
p_image4 varchar(20),
p_datail varchar(3000) not null
);
alter table product add column p_sale char(1) default('N');
ALTER TABLE `website`.`product` CHANGE COLUMN `p_sale` `p_sale` CHAR(1) NOT NULL DEFAULT _utf8mb4'N' ;

insert into master_seq values(0,'seq_product');

create table cart_main(
cm_num int not null primary key,
id varchar(20) not null,
cm_date varchar(20) not null,
foreign key(id) references customer(id)
);

insert into master_seq values(0,'seq_cm');

create table cart_sub(
cs_num int not null primary key,
cm_num int not null,
p_code int not null,
cs_cnt int not null,
cs_stat char(1) default('Y'),
foreign key(cm_num) references cart_main(cm_num),
foreign key(p_code) references product(p_code)
);
insert into master_seq values(0,'seq_cs');

create table account_main(
am_num int not null primary key,
id varchar(20) not null,
am_date varchar(20) not null,
am_stat char(1) not null default('A'),
am_paymethod varchar(20) not null,
am_paydate varchar(20),
foreign key (id) references customer(id)
);
insert into master_seq values(0,'seq_am');

create table account_sub(
as_num int not null primary key,
am_num int not null,
p_code int not null,
as_cnt int not null,
as_delicode varchar(20),
foreign key(am_num) references account_main(am_num),
foreign key(p_code) references product(p_code)
);
insert into master_seq values(0,'seq_as');
create table deli_info(
d_num int not null primary key,
id varchar(20) not null,
d_post int,
d_addr varchar(50) not null,
a_addr2 varchar(50),
d_date varchar(20) not null,
d_demend varchar(200) default('안전한 배송 부탁드립니다'),
d_recip varchar(20),
foreign key (id) references customer(id)
);
insert into master_seq values(0,'seq_deliInfo');
commit;

delete from product where p_code =8;
update master_seq set id = 0 where seq_name = 'seq_product'; 
insert into product values(get_seq('seq_product'),100,'레귤러 슬랙스 블랙',10,4.5,50000,concat(p_class,p_code,'_1'),concat(p_class,p_code,'_2'),null,null,concat(p_class,p_code,'_detail'),'N');
insert into product values(get_seq('seq_product'),100,'씨쏘 남성용 히든밴딩 감격 슬랙스 팬츠',10,4.6,23000,concat(p_class,p_code,'_1'),concat(p_class,p_code,'_2'),null,null,concat(p_class,p_code,'_detail'),'Y');
insert into product values(get_seq('seq_product'),100,'캐럿 남성용 스크레치 일자핏 워싱 청바지',10,3.3,88000,concat(p_class,p_code,'_1'),concat(p_class,p_code,'_2'),null,null,concat(p_class,p_code,'_detail'),'Y');
insert into product values(get_seq('seq_product'),100,'잘빠진 여성용 두줄라인 팬츠',10,4.7,15000,concat(p_class,p_code,'_1'),concat(p_class,p_code,'_2'),null,null,concat(p_class,p_code,'_detail'),'Y');


insert into product values(get_seq('seq_product'),200,'NIKE AIR PREMIUM BLACK',20,4,50000,concat(p_class,p_code,'_1'),null,null,null,concat(p_class,p_code,'_detail'),'N');
insert into product values(get_seq('seq_product'),200,'SL-181 SELIC',30,4.3,32000,concat(p_class,p_code,'_1'),null,null,null,concat(p_class,p_code,'_detail'),'Y');
insert into product values(get_seq('seq_product'),200,'남성용 스니커즈 A10041',25,4,55000,concat(p_class,p_code,'_1'),null,null,null,concat(p_class,p_code,'_detail'),'Y');
insert into product values(get_seq('seq_product'),200,'MENS NIKE AIR MONARCH IV-101',20,5,50000,concat(p_class,p_code,'_1'),null,null,null,concat(p_class,p_code,'_detail'),'Y');

insert into product values(get_seq('seq_product'),300,'남녀공용 라운드 반팔티 화이트',150,4,23000,concat(p_class,p_code,'_1'),null,null,null,concat(p_class,p_code,'_detail'),'N');
insert into product values(get_seq('seq_product'),400,'단군 남성용코트 가을코트 베닌더블오버코트 빅사이즈 오버핏 남자코트',100,3.5,69000,concat(p_class,p_code,'_1'),null,null,null,concat(p_class,p_code,'_detail'),'Y');
rollback;
commit;
select * from product order by p_grade desc;

ALTER TABLE product CHANGE COLUMN `p_datail` `p_detail` VARCHAR(3000) NOT NULL ;

select * from product where p_grade>=4.5 order by p_grade desc;

select * from product where p_class=300 order by p_grade desc;

select * from
(select * from
(select @rownum:=@rownum+1 as SEQ, p_code, p_class, p_name, p_stock, p_grade, p_price, p_image1 from
(select * from product order by p_grade desc) as p where (@rownum:=0)=0
)as p2 where p2.SEQ >= 1
) as p3 limit 3;

select * from 
(select * from
(select @rownum:=@rownum+1 as SEQ, p_code, p_class, p_name, p_stock, p_grade, p_price, p_image1 from
(select * from product order by p_grade desc) as p where (@rownum:=0)=0
)as p2 where p2.SEQ >= 1
)as p3 limit 15;


select count(p_code) from product;

select * from 
	(select * from 
	(select @rownum:=@rownum+1 as SEQ, p_code, p_class, p_name, p_stock, p_grade, p_price, p_image1 from
	(select * from product order by p_grade desc) as p where (@rownum:=0)=0
	)as p2 where SEQ >= 1
	)as p3 limit 2;
    
select @rownum:=@rownum+1 as SEQ, p_code, p_class, p_name, p_stock, p_grade, p_price, p_image1 from 
(select * from product order by p_grade desc) as p where (@rownum:=0)='0';

insert into webadmin values(get_seq('seq_webadmin'),'admin','admin','관리자','192.168.0.225');
insert into notice values (get_seq('seq_notice'),'delivery','admin','공지사항 테스트 페이지 입니다.','2020-10-03','',0,'192.168.0.225','공지사항 test');

select @rownum:=@rownum+1 as SEQ, n_num, n_category, ad_id, n_contents, n_datefirst, n_datelast, n_cnt, n_ip, ad_name from 
(select no.*, ad_name from notice no,webadmin w where no.ad_id = w.ad_id order by n_num desc) as n where (@rownum:=0)=0 ;

insert into guestbook_main values (get_seq('seq_gm'),'test','자유게시판 테스트입니다','자유게시판 입니다.','1234','2020-10-03','2020-10-04','192.168.0.225');
insert into guestbook_sub values(get_seq('seq_gs'),1,'elon','댓글 테스트 1','2020-10-04','2020-10-04','192.168.0.225');
insert into guestbook_sub values(get_seq('seq_gs'),1,'test','댓글 테스트 1','2020-10-04','2020-10-04','192.168.0.225');


commit;

ALTER TABLE `website`.`guestbook_main` ADD COLUMN `gm_cnt` INT NOT NULL DEFAULT 0 AFTER `gm_ip`;

select @rownum:=@rownum+1 as SEQ, gm_num, gm_subject, gm_name,gm_passwd, gm_datew, gm_dateu, gm_content, gm_cnt from
(select * from guestbook_main order by gm_num desc) as gm where (@rownum:=0)=0;

select * from guestbook_main gm,guestbook_sub gs where gm.gm_num=gs.gs_num and gm.gm_num=? order by gs.gs_num desc;
select * from guestbook_main gm,guestbook_sub gs where gm.gm_num=1 and gm.gm_num = gs.gm_num order by gs.gs_num desc;