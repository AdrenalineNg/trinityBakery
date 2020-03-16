create database trinityBakery default character set utf8mb4;

use trinityBakery;

/*商品列表*/
create table good(
   g_id char(4),
   g_name VARCHAR(20) NOT NULL,
   g_price FLOAT NOT NULL,
   g_img varchar(100),
   g_weight	int,
   PRIMARY KEY ( g_id )
);
INSERT INTO good
( g_id, g_name, g_price, g_img, g_weight) 
VALUES
(0001,'千层蛋糕盒子（抹茶豆乳草莓奶油）',38.6,'../../static/img/1.jpg',80),
(0002,'抹茶红豆乳酪软欧包',34.8,'../../static/img/2.jpg',50),
(0003,'安德莉亚巧克力曲奇',26.7,'../../static/img/3.jpg',100),
(0004,'奶酥草莓乳酪软欧包',50.8,'../../static/img/4.jpg',100),
(0005,'奶茶咸奶盖珍珠蛋糕',36.8,'../../static/img/5.jpg',80);

/*购物车*/
create table shoppingcart(
   c_id char(4),
   c_name VARCHAR(20) NOT NULL,
   c_price FLOAT NOT NULL,
   c_img varchar(100),
   c_weight	int,
   c_num int,
   c_money float,
   PRIMARY KEY ( c_id )
);
INSERT INTO shoppingcart
( c_id, c_name, c_price, c_img,  c_weight, c_num, c_money) 
VALUES
(0001,'千层蛋糕盒子（抹茶豆乳草莓奶油）',38.6,'../../static/img/1.jpg',80,100,3860),
(0002,'抹茶红豆乳酪软欧包',34.8,'../../static/img/2.jpg',50,100,3480),
(0003,'安德莉亚巧克力曲奇',26.7,'../../static/img/3.jpg',100,50,1335),
(0004,'奶酥草莓乳酪软欧包',50.8,'../../static/img/4.jpg',100,50,2540),
(0005,'奶茶咸奶盖珍珠蛋糕',36.8,'../../static/img/5.jpg',80,100,3680);

/*订单商品详情*/
create table detail(
   c_id char(4),
   c_name VARCHAR(20) NOT NULL,
   c_price FLOAT NOT NULL,
   c_img varchar(100),
   c_weight	int,
   c_num int,
   c_money float,
   PRIMARY KEY ( c_id )
);

/*退款商品详情*/
create table refunddetail(
   c_id char(4),
   c_name VARCHAR(20) NOT NULL,
   c_price FLOAT NOT NULL,
   c_img varchar(100),
   c_weight	int,
   c_num int,
   c_money float,
   PRIMARY KEY ( c_id )
);

/*员工信息表*/
create table _admin(
	a_name varchar(18),
	a_id char(11),
	a_department varchar(18),
	a_tel varchar(11),
	a_email varchar(100),
    PRIMARY KEY ( a_id )
);
INSERT INTO _admin
(a_name ,a_id,a_department,a_tel,a_email) 
VALUES
('王大芬',17863215218,'销售部',17863215218,'wangdafen@163.com'),
('刘大壮',17863215283,'销售部',17863215283,'liudazhuang@163.com'),
('张小丽',17863123456,'会计',17863123456,'zhangxiaoli@163.com'),
('徐小龙',17863212345,'出纳',17863212345,'xvxiaolong@163.com'),
('王小阳',17852123523,'生产计划科',17852123523,'wangxiaoyang@163.com'),
('孙大力',17852123568,'生产车间',17852123568,'sundali@163.com'),
('李小光',17852123852,'仓库',17852123852,'lixiaoguang@163.com'),
('周大军',17852123524,'企业管理者',17852123524,'zhousajun@163.com');

/*客户信息表*/
create table _user(
	u_id	char(11),
	u_name	varchar(20),
	contact_name	varchar(12),
	u_type char(4),
	u_level char(4),
	phone char(11),
	email varchar(50),
	qq	varchar(12),
	address	varchar(50),
    PRIMARY KEY ( u_name )
);
INSERT INTO _user
(u_id,u_name,contact_name,u_type,u_level,phone,email,qq,address)
VALUES
(17863112321,'张三家蛋糕店','张三','个人','普通',17863112321,'zhangsan@163.com',123456789,'山东省威海市文化西路1号'),
(17852132158,'李四家蛋糕店','李四','企业','普通',17852132158,'lisi@163.com',234567890,'山东省威海市文化西路2号');

/*销售策略表*/
create table salemanagement(
	s_level char(4),
	discount	int,
    PRIMARY KEY ( s_level )
);
INSERT INTO salemanagement
(s_level,discount)
VALUES
('普通',0),
('VIP',2),
('SVIP',3);

/*商品表*/
create table production(
	p_id	CHAR(4) ,
	p_name	varchar(20),
	p_weight	int,
	p_price	float,
	exp	int,
    PRIMARY KEY ( p_id )
);
INSERT INTO production
(p_id,p_name,p_weight,p_price,exp)
VALUES
(0001,'千层蛋糕盒子（抹茶豆乳草莓奶油）',80,38.6,30),
(0002,'抹茶红豆乳酪软欧包',50,34.8,30),
(0003,'安德莉亚巧克力曲奇',100,26.7,30),
(0004,'奶酥草莓软欧包',100,50.8,30),
(0005,'奶茶咸奶盖珍珠蛋糕',80,36.8,30);

/*订单表*/
create table orderform(
	order_id	char(8) ,
	create_date	date,
	salesperson	varchar(12),
	is_paid	char(10),
	cashier	varchar(12),
	is_confirm	char(10),
	totalprice	float,
	accountant	varchar(12),
	address	varchar(50),
    chuku_fahuo varchar(6),
    tihuo varchar(6),
    PRIMARY KEY ( order_id )
);
INSERT INTO orderform
(order_id,create_date,salesperson,is_paid,cashier,is_confirm,totalprice,accountant,address,chuku_fahuo,tihuo)
VALUES
(20180001,'2018-07-01','王大芬','未付款','徐小龙','未通过',3860,'张小丽','山东省威海市文化西路1号','未出库','未生成提货单'),
(20180002,'2018-07-10','刘大壮','未付款','徐小龙','未通过',3480,'张小丽','山东省威海市文化西路2号','未出库','已生成提货单');

/*退款单表*/
drop table refundform(
	refund_id char(8),
	order_id	char(8),
	u_id int,
	create_date	date,
	salesperson	varchar(12),
	is_paid	char(6),
	cashier	varchar(12),
	is_confirm	char(6),
	totalprice	float,
	accountant	varchar(12),
	PRIMARY KEY ( refund_id )
);
INSERT INTO refundform
(refund_id,order_id,u_id,create_date,salesperson,is_paid,cashier,is_confirm,totalprice,accountant)
VALUES
(20181001,20180002,100002,'2018-07-12','刘大壮','已退款','徐小龙','已审核',3480,'张小丽');

/*生产计划表*/
create table produceplan(
	p_id	INT auto_increment ,
    p_name varchar(20),
	quantity	int,
	p_date	date,
	PRIMARY KEY ( p_id )
);
INSERT INTO produceplan
(p_name,quantity,p_date)
VALUES
('抹茶红豆乳酪软欧包',100,'2018-07-22'),
('奶酥草莓软欧包',200,'2018-07-31'),
('奶茶咸奶盖珍珠蛋糕',300,'2018-08-02');

create table storage(
	sfid char(8) ,
	p_name	VARCHAR(20),
    p_img varchar(100),
	sto_date	date,
	quantity	int,
	exp	date,
    PRIMARY KEY ( sfid )
);
/*库存表*/
INSERT INTO storage
(sfid,p_name,sto_date, quantity,exp,p_img)
VALUES
(20181101,'抹茶红豆乳酪软欧包','2018-07-23',100,'2018-08-22','../../static/img/2.jpg');

/*提货单表*/
create table deliveryform2(
	tihuo_id    char(8),
    accountant  varchar(20),
    totalprice float,
    address varchar(50),
    tihuo varchar(50),
    PRIMARY KEY ( tihuo_id )
);
INSERT INTO deliveryform2
(tihuo_id,accountant,totalprice,address,tihuo)
VALUES
(20181101,'张小丽',3480,'山东省威海市文化西路2号','未提货');

/*入库表*/
create table intostorage(
	sfid char(8) ,
	p_id	char(8),
	stoDate	date,
	quantity	int,
    exp date,
    PRIMARY KEY ( sfid )
);
INSERT INTO intostorage
(sfid,p_id,stoDate,quantity,exp)
VALUES
(20180001,1,'2018-07-22',100,'2018-08-21');

/*出库表*/
create table outstorage(
	sfid char(8) ,
	order_id	char(8),
	quantity	int,
    dl_date date,
    PRIMARY KEY ( sfid )
);
INSERT INTO outstorage
(sfid,order_id,dl_date,quantity)
VALUES
(20180001,20180001,'2018-07-23',100);







