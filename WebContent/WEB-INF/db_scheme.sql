
#create database
create database workload;
use workload
#
#######################1.基本信息#######################
#学院
create table t_college
(
  id char(24) NOT NULL,#
  name varchar(40) NOT NULL,#
  status int default 1 NOT NULL,
  
  constraint pk_t_college primary key(id)
)charset=utf8 ENGINE=InnoDB;

#专业
create table t_major
(
  id char(24) NOT NULL,#
  name varchar(40) NOT NULL,#
  college char(24) NOT NULL,#
  status int default 1 NOT NULL,
  
  constraint pk_t_major primary key(id),
  CONSTRAINT fk_t_major_college FOREIGN KEY (college) REFERENCES t_college(id)
)charset=utf8 ENGINE=InnoDB;

#学期semester
create table t_semester
(
  id varchar(10) NOT NULL,#02-01春季期 08-01秋季期 
  name varchar(40) NOT NULL,#
  status int default 1 NOT NULL,#0:未进行,1:进行中,2:完成,3:锁定
  
  constraint pk_t_semester primary key(id)
)charset=utf8 ENGINE=InnoDB;

#职称
create table t_teacher_title
(
  id char(24) NOT NULL,#
  name varchar(40) NOT NULL,#
  workload int default 0 NOT NULL,#额定工作量
  price int default 0 NOT NULL,#工作量工资
  status int default 1 NOT NULL,#
  
  constraint pk_t_teacher_title primary key(id)
)charset=utf8 ENGINE=InnoDB;

#######################2.理论教学信息#######################
#课程允许不同的学院同名.但是同一学院不能chongming
create table t_course
(
  id char(24) NOT NULL,#
  name varchar(40) NOT NULL,#唯一约束
  college char(24) NOT NULL,#课程所属学院(不需要专业，因为专业之间有共同课程)
  remark varchar(200) NOT NULL,
  create_date date NOT NULL,
  status int default 1 NOT NULL,#
  
  constraint pk_t_course primary key(id),
  CONSTRAINT fk_t_course_college FOREIGN KEY (college) REFERENCES t_college(id)
)charset=utf8 ENGINE=InnoDB;

#理论授课申请表
create table t_course_account
(
  id char(24) NOT NULL,#
  semester varchar(15)  NOT NULL,#学期
  course char(24) NOT NULL,#课程
  course_name varchar(40)  NOT NULL,#
  teacher varchar(15) NOT NULL,#授课老师
  student char(30) NOT NULL,#授课对象
  course_num Integer NOT NULL,#正常选课人数
  course_repnum Integer NOT NULL,#重修人数
  class_hour double NOT NULL,#计划学时
  type_factor double NOT NULL,#类型系数
  rep_factor double NOT NULL,#重复课系数
  workload double NOT NULL,#工作量
  campus ENUM("金石滩", "开发区") NOT NULL,#校区
  status Integer default 1 NOT NULL,#0取消1进行中2通过
  
  CONSTRAINT uq_t_course_account_sct UNIQUE (semester, course, teacher),
  constraint pk_t_course_account primary key(id),
  CONSTRAINT fk_t_course_account_course FOREIGN KEY (course) REFERENCES t_course(id),
  CONSTRAINT fk_t_course_account_teacher FOREIGN KEY (teacher) REFERENCES t_user(id)
)charset=utf8 ENGINE=InnoDB;

#######################2.实验上机信息#######################
#实验上机
create table t_experiment
(
  id char(24) NOT NULL,#
  name varchar(40) NOT NULL,#唯一约束
  college char(24) NOT NULL,#上机所属学院(不需要专业，因为专业之间有共同课程)
  remark varchar(200) NOT NULL,
  creator varchar(15) NOT NULL,#录入者
  create_date date NOT NULL,
  status int default 1 NOT NULL,#
  
  constraint pk_t_experiment primary key(id),
  CONSTRAINT fk_t_experiment_college FOREIGN KEY (college) REFERENCES t_college(id)
)charset=utf8 ENGINE=InnoDB;

#实验上机申报
create table t_experiment_account
(
  id char(24) NOT NULL,#实验
  semester varchar(15)  NOT NULL,#学期
  experiment char(24) NOT NULL,#实验
  experiment_name varchar(40) NOT NULL,#记录当时的实验名称
  period double NOT NULL,#总计划学时
  operiod double NOT NULL,#总其他校区计划学时
  course_num Integer NOT NULL,#总正常选课人数
  course_repnum Integer NOT NULL,#重修人数
  class_stunum Integer NOT NULL,#每班人数
  class_time double NOT NULL,#教学班次数
  factor double NOT NULL,#系数
  workload double NOT NULL,#工作量
  creator varchar(15) NOT NULL,#录入者
  create_date date NOT NULL,
  campus ENUM("金石滩", "开发区") NOT NULL,#校区
  
  status Integer default 1  NOT NULL,
  
  CONSTRAINT uq_t_experiment_account_set UNIQUE (semester, experiment, creator),
  constraint pk_t_experiment_account primary key(id),
  CONSTRAINT fk_t_experiment_account_experiment FOREIGN KEY (experiment) REFERENCES t_experiment(id),
  CONSTRAINT fk_t_experiment_account_creator FOREIGN KEY (creator) REFERENCES t_user(id)
)charset=utf8 ENGINE=InnoDB;

create table t_experiment_item
(
  id char(24) NOT NULL,
  exp_account char(24) NOT NULL,
  student char(30) NOT NULL,#授课年级
  period double NOT NULL,#计划学时
  operiod double NOT NULL,#其他校区计划学时
  course_num Integer NOT NULL,#正常选课人数
  course_repnum Integer NOT NULL,#重修人数
  class_stunum Integer NOT NULL,#每班人数
  class_time double NOT NULL,#教学班次数
  factor double NOT NULL,#系数
  workload double NOT NULL,#工作量
  
  constraint pk_t_experiment_item primary key(id),
  CONSTRAINT fk_t_experiment_item_exp_account FOREIGN KEY (exp_account) REFERENCES t_experiment_account(id)
)charset=utf8 ENGINE=InnoDB;

create table t_experiment_act_teacher
(   
   id char(24) NOT NULL,
   exp_account char(24) NOT NULL,
   teacher varchar(15) NOT NULL,#教师
   
   p_workload double NOT NULL,#承担教学工作量
   w_workload double NOT NULL,#工作时间内教学工作量
   c_workload double NOT NULL,#核发薪金教学工作量
   period double NOT NULL,#计划学时
   
  CONSTRAINT uq_t_experiment_act_teacher_et UNIQUE (exp_account, teacher),
  constraint pk_t_experiment_act_teacher primary key(id),
  CONSTRAINT fk_t_experiment_act_teacher_exp_account FOREIGN KEY (exp_account) REFERENCES t_experiment_account(id),
  CONSTRAINT fk_t_experiment_act_teacher_teacher FOREIGN KEY (teacher) REFERENCES t_user(id)
);

#实验组申请(每个科组只能有一个负责人)
create table t_experiment_group
(
   id char(24) NOT NULL,
   semester varchar(15) NOT NULL,#学期
   experiment char(24) NOT NULL,#实验
   creator varchar(15) NOT NULL,#创造者
   remark varchar(200) NOT NULL,
   create_date date NOT NULL,
   
   CONSTRAINT uq_t_experiment_group_se UNIQUE (semester, experiment),
   constraint pk_t_experiment_group primary key(id),
   CONSTRAINT fk_t_experiment_account_creator FOREIGN KEY (creator) REFERENCES t_user(id)
);
#实验组对应的教师
create table t_experiment_group_teacher
(   
   id char(24) NOT NULL,
   exp_group char(24) NOT NULL,#实验组
   teacher varchar(15) NOT NULL,#实验组教师
   
   CONSTRAINT uq_t_experiment_group_teacher_se UNIQUE (exp_group, teacher),
   constraint pk_t_experiment_group_teacher primary key(id),
   CONSTRAINT fk_t_experiment_group_teacher_exp_group FOREIGN KEY (exp_group) REFERENCES t_experiment_group(id),
   CONSTRAINT fk_t_experiment_group_teacher_teacher FOREIGN KEY (teacher) REFERENCES t_user(id)
);



#######################教学实践#######################

#课程设计
create table t_coursedesign
(
  id char(24) NOT NULL,#
  name varchar(40) NOT NULL,#唯一约束
  college char(24) NOT NULL,#课程设计属学院(不需要专业，因为专业之间有共同课程)
  remark varchar(200) NOT NULL,
  creator varchar(15) NOT NULL,#创造者
  create_date date NOT NULL,
  status int default 1 NOT NULL,#0锁定,可选
  
  constraint pk_t_coursedesign primary key(id),
  CONSTRAINT fk_t_coursedesign_college FOREIGN KEY (college) REFERENCES t_college(id),
  CONSTRAINT fk_t_coursedesign_creator FOREIGN KEY (creator) REFERENCES t_user(id)
)charset=utf8 ENGINE=InnoDB;

#一个人同一个学期可以录入1个课程设计
create table t_cdesign_account
(
  id char(24) NOT NULL,#
  semester varchar(15)  NOT NULL,#学期
  coursedesign char(24) NOT NULL,#课程设计
  coursedesign_name varchar(40) NOT NULL,#
  major char(24) NOT NULL,#专业
  grade varchar(10) NOT NULL,#年级
  
  class_num Integer default 0 NOT NULL,#班级数
  week_num Integer default 0 NOT NULL,#课程设计周数
  preday Integer default 0 NOT NULL,#准备天数
  workload double default 0 NOT NULL,#总工作量
  period double default 0 NOT NULL,#计划学时
  campus ENUM("金石滩", "开发区") NOT NULL,#校区
  creator varchar(15) NOT NULL,#创造者
  create_date date NOT NULL,
  remark varchar(200) NOT NULL,
  status integer default 1 NOT NULL,
  
  CONSTRAINT uq_t_coursedesign_account_scdc UNIQUE (semester, major, grade, coursedesign),#每个学期每个专业每个年级只有某个课程设计
  constraint pk_t_coursedesign_account primary key(id),
  CONSTRAINT fk_t_coursedesign_account_coursedesign FOREIGN KEY (coursedesign) REFERENCES t_coursedesign(id),
  CONSTRAINT fk_t_coursedesign_account_major FOREIGN KEY (major) REFERENCES t_major(id),
  CONSTRAINT fk_t_coursedesign_account_creator FOREIGN KEY (creator) REFERENCES t_user(id)
  
)charset=utf8 ENGINE=InnoDB;

#课程设计包括的老师
create table t_cdesign_act_teacher
(
  id char(24) NOT NULL,#
  cdesign_account char(24) NOT NULL,#
  teacher varchar(15) NOT NULL,
  workload double default 0 NOT NULL,#总工作量
  period double default 0 NOT NULL,#计划学时
  remark varchar(200) NOT NULL,
  status integer default 1 NOT NULL,
  
  CONSTRAINT uq_t_cdesign_act_teacher_ct UNIQUE (cdesign_account, teacher),
  constraint pk_t_cdesign_act_teacher primary key(id),
  CONSTRAINT fk_t_cdesign_act_teacher_cdesign_account FOREIGN KEY (cdesign_account) REFERENCES t_cdesign_account(id),
  CONSTRAINT fk_t_cdesign_act_teacher_teacher FOREIGN KEY (teacher) REFERENCES t_user(id)
)charset=utf8 ENGINE=InnoDB;

#毕业设计
create table t_grdtdesign_account
(
  id char(24) NOT NULL,#
  semester varchar(15)  NOT NULL,#学期
  major char(24) NOT NULL,#专业
  grade varchar(10) NOT NULL,#年级
  class_num Integer default 0 NOT NULL,#班级数
  stu_num Integer default 0 NOT NULL,#学生人数
  week_num Integer default 0 NOT NULL,#计划周数
  factor double NOT NULL,#系数
  workload double NOT NULL,#标准作量
  campus ENUM("金石滩", "开发区") NOT NULL,#校区
  period double default 0 NOT NULL,#计划学时
  creator varchar(15) NOT NULL,#创造者
  create_date date NOT NULL,
  remark varchar(200) NOT NULL,
  status integer default 1 NOT NULL,
  
  CONSTRAINT uq_t_grdtdesign_account_smg UNIQUE (semester, major, grade),#每个学期每个专业每个年级只能有一次毕设
  constraint pk_t_grdtdesign_account primary key(id),
  CONSTRAINT fk_t_grdtdesign_account_major FOREIGN KEY (major) REFERENCES t_major(id),
  CONSTRAINT fk_t_grdtdesign_account_creator FOREIGN KEY (creator) REFERENCES t_user(id)
  
)charset=utf8 ENGINE=InnoDB;

#毕业设计包括的老师
create table t_grdtdesign_act_teacher
(
  id char(24) NOT NULL,#
  grdtdesign_account char(24) NOT NULL,#
  teacher varchar(15) NOT NULL,
  workload double NOT NULL,#工作量
  period double default 0 NOT NULL,#计划学时
  remark varchar(200) NOT NULL,
  status integer default 1 NOT NULL,
  
  CONSTRAINT uq__grdtdesign_act_teacher_gt UNIQUE (grdtdesign_account, teacher),
  constraint pk_t_grdtdesign_act_teacher primary key(id),
  CONSTRAINT fk_t_grdtdesign_act_teacher_grdtdesign_account FOREIGN KEY (grdtdesign_account) REFERENCES t_grdtdesign_account(id),
  CONSTRAINT fk_t_grdtdesign_act_teacher_teacher FOREIGN KEY (teacher) REFERENCES t_user(id)
)charset=utf8 ENGINE=InnoDB;

#大创
create table t_project_account
(
  id char(24),
  semester varchar(15)  NOT NULL,#学期
  creator varchar(15) NOT NULL,
  year varchar(10) NOT NULL,#年
  spcode varchar(10) NOT NULL,#单项目编号''表示没有
  sworkload double NOT NULL,#
  mpcode varchar(10) NOT NULL,#
  mworkload double NOT NULL,#
  mrworkload double NOT NULL,#
  remark varchar(200) NOT NULL,
  create_date date NOT NULL,
  
  constraint pk_t_project_account primary key(id),
  CONSTRAINT fk_t_project_account_creator FOREIGN KEY (creator) REFERENCES t_user(id)
  
)charset=utf8 ENGINE=InnoDB;

#######################用户权限管理#######################
#用户
create table t_user
(
  id varchar(15) NOT NULL,#
  name varchar(40) NOT NULL,#
  college char(24) NOT NULL,#所属学院
  major char(24) NOT NULL,#所属专业
  teacher_title char(24) NOT NULL,#职称
  workload double default 0 NOT NULL,#额定工作量
  price double default 0 NOT NULL,#工作量工资
  remark varchar(200) NOT NULL,#备注
  
  status int default 1 NOT NULL,
  salt varchar(40) NOT NULL,#盐
  password varchar(50) NOT NULL,#密码
  
  constraint pk_t_user primary key(id),
  CONSTRAINT fk_t_user_college FOREIGN KEY (college) REFERENCES t_college(id),
  CONSTRAINT fk_t_user_major FOREIGN KEY (major) REFERENCES t_major(id),
  CONSTRAINT fk_t_user_teacher_title FOREIGN KEY (teacher_title) REFERENCES t_teacher_title(id)
)charset=utf8 ENGINE=InnoDB;

#角色
create table t_role (
  id int auto_increment NOT NULL,
  roles varchar(256) NOT NULL,#需要唯一约束
  description varchar(100) NOT NULL,
  available int default 1 NOT NULL,
  
  constraint pk_t_role primary key(id)
) charset=utf8 ENGINE=InnoDB;
#权限
create table t_permission (
  id int auto_increment NOT NULL,
  permissions varchar(256) NOT NULL,
  description varchar(100) NOT NULL,
  available int default 1 NOT NULL,
  
  constraint pk_permission primary key(id)
) charset=utf8 ENGINE=InnoDB;

#用户角色关联
create table t_user_role (
  user varchar(15) NOT NULL,
  role int NOT NULL,
  constraint pk_t_user_role primary key(user, role),
  CONSTRAINT fk_t_user_role_user FOREIGN KEY (user) REFERENCES t_user(id),
  CONSTRAINT fk_t_user_role_role FOREIGN KEY (role) REFERENCES t_role(id)
) charset=utf8 ENGINE=InnoDB;

#角色权限关联
create table t_role_permission (
  role int NOT NULL,
  permission int NOT NULL,
  constraint pk_t_role_permission primary key(role, permission),
  CONSTRAINT fk_t_role_permission_role FOREIGN KEY (role) REFERENCES t_role(id),
  CONSTRAINT fk_t_role_permission_permission FOREIGN KEY (permission) REFERENCES t_permission(id)
) charset=utf8 ENGINE=InnoDB;

select role 
from sys_users u, sys_roles r,sys_users_roles ur 
where u.username=? and u.id=ur.user_id and r.id=ur.role_id

select permission 
from sys_users u, sys_roles r, sys_permissions p, sys_users_roles ur, sys_roles_permissions rp 
where u.username=? and u.id=ur.user_id and r.id=ur.role_id and r.id=rp.role_id and p.id=rp.permission_id

