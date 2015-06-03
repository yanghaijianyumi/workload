#学院
insert into t_college(id, name) values('552caa539db8258bc497fd45', '经济管理学院');
insert into t_college(id, name) values('552caa539db8258bc497fd46', '计算机科学与工程学院');
insert into t_college(id, name) values('552caa539db8258bc497fd47', '土木建筑工程学院');
insert into t_college(id, name) values('552caa539db8258bc497fd48', '国际商学院');
insert into t_college(id, name) values('552caa539db8258bc497fd49', '文法学院');
insert into t_college(id, name) values('552caa539db8258bc497fd4a', '理学院');
insert into t_college(id, name) values('552caa539db8258bc497fd4b', '物理与材料学院');
insert into t_college(id, name) values('552caa539db8258bc497fd4c', '机电信息工程学院');
insert into t_college(id, name) values('552caa539db8258bc497fd4d', '生命科学学院');
insert into t_college(id, name) values('552caa539db8258bc497fd4e', '外国语言文化学院');
insert into t_college(id, name) values('552caa539db8258bc497fd4f', '设计学院');
insert into t_college(id, name) values('552caa539db8258bc497fd50', '信息与通信工程学院');
insert into t_college(id, name) values('552caa539db8258bc497fd51', '环境与资源学院');
commit;

#专业
#1.经管
insert into t_major(id, name, college) values('552cad179db825963c88b794', '旅游管理', '552caa539db8258bc497fd45');
insert into t_major(id, name, college) values('552cad189db825963c88b795', '工商管理', '552caa539db8258bc497fd45');
insert into t_major(id, name, college) values('552cad189db825963c88b796', '市场营销', '552caa539db8258bc497fd45');
insert into t_major(id, name, college) values('552cad189db825963c88b797', '经济学', '552caa539db8258bc497fd45');
insert into t_major(id, name, college) values('552cad189db825963c88b798', '行政管理', '552caa539db8258bc497fd45');
insert into t_major(id, name, college) values('552cad189db825963c88b799', '人力资源管理', '552caa539db8258bc497fd45');
#2.计算机
insert into t_major(id, name, college) values('552cadc99db825906cd033f9', '计算机科学与技术', '552caa539db8258bc497fd46');
insert into t_major(id, name, college) values('552cadc99db825906cd033fa', '网络工程', '552caa539db8258bc497fd46');
insert into t_major(id, name, college) values('552cadc99db825906cd033fb', '软件工程', '552caa539db8258bc497fd46');
#3.土木建筑工程学院
insert into t_major(id, name, college) values('552caeeb9db8259d78d3f519', '土木工程', '552caa539db8258bc497fd47');
insert into t_major(id, name, college) values('552caeeb9db8259d78d3f51a', '建筑学', '552caa539db8258bc497fd47');
insert into t_major(id, name, college) values('552caeeb9db8259d78d3f51b', '工程管理', '552caa539db8258bc497fd47');
insert into t_major(id, name, college) values('552caeeb9db8259d78d3f51c', '建筑环境与能源应用工程', '552caa539db8258bc497fd47');
#4.国际商学院
insert into t_major(id, name, college) values('552caf4b9db8259f187d4a66', '会计学', '552caa539db8258bc497fd48');
insert into t_major(id, name, college) values('552caf4b9db8259f187d4a67', '财务管理', '552caa539db8258bc497fd48');
insert into t_major(id, name, college) values('552caf4b9db8259f187d4a68', '国际经济与贸易', '552caa539db8258bc497fd48');
insert into t_major(id, name, college) values('552caf4b9db8259f187d4a69', '国际商务', '552caa539db8258bc497fd48');
#5.文法学院
insert into t_major(id, name, college) values('552cafbe9db825a2ccf8c6e5', '法学', '552caa539db8258bc497fd49');
insert into t_major(id, name, college) values('552cafbe9db825a2ccf8c6e6', '汉语言文学', '552caa539db8258bc497fd49');
insert into t_major(id, name, college) values('552cafbe9db825a2ccf8c6e7', '新闻学', '552caa539db8258bc497fd49');
insert into t_major(id, name, college) values('552cafbe9db825a2ccf8c6e8', '汉语国际教育', '552caa539db8258bc497fd49');
#6.理学院
insert into t_major(id, name, college) values('552cb0029db825a374797ad1', '信息与计算科学', '552caa539db8258bc497fd4a');
insert into t_major(id, name, college) values('552cb0029db825a374797ad2', '统计学', '552caa539db8258bc497fd4a');
#7.物理与材料学院
insert into t_major(id, name, college) values('552cb0629db825a5902aa0a5', '光电信息科学与工程', '552caa539db8258bc497fd4b');
insert into t_major(id, name, college) values('552cb0639db825a5902aa0a6', '功能材料', '552caa539db8258bc497fd4b');

#8.机电信息工程学院
insert into t_major(id, name, college) values('552cb0b89db8259080590e2a', '机械设计制造及其自动化', '552caa539db8258bc497fd4c');
insert into t_major(id, name, college) values('552cb0b89db8259080590e2b', '自动化', '552caa539db8258bc497fd4c');
insert into t_major(id, name, college) values('552cb0b89db8259080590e2c', '工业工程', '552caa539db8258bc497fd4c');
insert into t_major(id, name, college) values('552cb0b89db8259080590e2d', '测控技术与仪器', '552caa539db8258bc497fd4c');
insert into t_major(id, name, college) values('552cb0b89db8259080590e2e', '车辆工程', '552caa539db8258bc497fd4c');
#9.生命科学学院
insert into t_major(id, name, college) values('552cb1259db825a490afdcd0', '生物工程', '552caa539db8258bc497fd4d');
insert into t_major(id, name, college) values('552cb1259db825a490afdcd1', '食品科学与工程', '552caa539db8258bc497fd4d');
insert into t_major(id, name, college) values('552cb1259db825a490afdcd2', '食品质量与安全', '552caa539db8258bc497fd4d');
insert into t_major(id, name, college) values('552cb1259db825a490afdcd3', '化学工程与工艺', '552caa539db8258bc497fd4d');
insert into t_major(id, name, college) values('552cb1259db825a490afdcd4', '应用化学', '552caa539db8258bc497fd4d');
insert into t_major(id, name, college) values('552cb1259db825a490afdcd5', '制药工程', '552caa539db8258bc497fd4d');
#10.外国语言文化学院
insert into t_major(id, name, college) values('552cb1889db825a9201b6b72', '英语', '552caa539db8258bc497fd4e');
insert into t_major(id, name, college) values('552cb1889db825a9201b6b73', '日语', '552caa539db8258bc497fd4e');
insert into t_major(id, name, college) values('552cb1889db825a9201b6b74', '朝鲜语', '552caa539db8258bc497fd4e');
#11.设计学院
insert into t_major(id, name, college) values('552cb1ee9db825ab3429f1dd', '工业设计', '552caa539db8258bc497fd4f');
insert into t_major(id, name, college) values('552cb1ee9db825ab3429f1de', '动画', '552caa539db8258bc497fd4f');
insert into t_major(id, name, college) values('552cb1ee9db825ab3429f1df', '视觉传达设计', '552caa539db8258bc497fd4f');
insert into t_major(id, name, college) values('552cb1ee9db825ab3429f1e0', '环境设计', '552caa539db8258bc497fd4f');
insert into t_major(id, name, college) values('552cb1ee9db825ab3429f1e1', '产品设计', '552caa539db8258bc497fd4f');
#12.信息与通信工程学院
insert into t_major(id, name, college) values('552cb24f9db825ac44f6f397', '电子信息工程', '552caa539db8258bc497fd50');
insert into t_major(id, name, college) values('552cb24f9db825ac44f6f398', '通信工程', '552caa539db8258bc497fd50');
insert into t_major(id, name, college) values('552cb24f9db825ac44f6f399', '物联网工程', '552caa539db8258bc497fd50');
#13.环境与资源学院
insert into t_major(id, name, college) values('552cb2c39db825ad08ee6df7', '生物技术', '552caa539db8258bc497fd51');
insert into t_major(id, name, college) values('552cb2c39db825ad08ee6df8', '环境工程', '552caa539db8258bc497fd51');
insert into t_major(id, name, college) values('552cb2c39db825ad08ee6df9', '环境科学', '552caa539db8258bc497fd51');
commit;


#t_semester
insert into t_semester(id, name) values('2015-08-01', '2014-2015秋季期');

insert into t_semester(id, name) values('2016-02-01', '2015-2016春季期');
insert into t_semester(id, name) values('2016-08-01', '2015-2016秋季期');

insert into t_semester(id, name) values('2017-02-01', '2016-2017春季期');
insert into t_semester(id, name) values('2017-08-01', '2016-2017秋季期');

insert into t_semester(id, name) values('2018-02-01', '2017-2018春季期');
insert into t_semester(id, name) values('2018-08-01', '2017-2018秋季期');

insert into t_semester(id, name) values('2019-02-01', '2018-2019春季期');
insert into t_semester(id, name) values('2019-08-01', '2018-2019秋季期');

insert into t_semester(id, name) values('2020-02-01', '2019-2020春季期');
insert into t_semester(id, name) values('2020-08-01', '2019-2020秋季期');

insert into t_semester(id, name) values('2021-02-01', '2020-2021春季期');
insert into t_semester(id, name) values('2021-08-01', '2020-2021秋季期');

insert into t_semester(id, name) values('2022-02-01', '2021-2022春季期');
insert into t_semester(id, name) values('2022-08-01', '2021-2022秋季期');

insert into t_semester(id, name) values('2023-02-01', '2022-2023春季期');
insert into t_semester(id, name) values('2023-08-01', '2022-2023秋季期');

insert into t_semester(id, name) values('2023-02-01', '2022-2023春季期');
insert into t_semester(id, name) values('2023-08-01', '2022-2023秋季期');

insert into t_semester(id, name) values('2024-02-01', '2023-2024春季期');
insert into t_semester(id, name) values('2024-08-01', '2023-2024秋季期');

insert into t_semester(id, name) values('2025-02-01', '2024-2025春季期');
insert into t_semester(id, name) values('2025-08-01', '2024-2025秋季期');

insert into t_semester(id, name) values('2026-02-01', '2025-2026春季期');
insert into t_semester(id, name) values('2026-08-01', '2025-2026秋季期');
commit;

#t_teacher_title
insert into t_teacher_title(id, name, workload, price) values('552f9fb291163b77ec3c3900', '助教', 150, 50);
insert into t_teacher_title(id, name, workload, price) values('552f9fb291163b77ec3c3901', '讲师', 150, 50);
insert into t_teacher_title(id, name, workload, price) values('552f9fb291163b77ec3c3902', '副教授', 150, 50);
insert into t_teacher_title(id, name, workload, price) values('552f9fb291163b77ec3c3903', '教授', 150, 50);
commit;

#t_course
#计算机学院
insert into t_course(id, name, college) values('552fa98c91163b98c82c98f4', '操作系统', '552caa539db8258bc497fd46');
insert into t_course(id, name, college) values('552fa98c91163b98c82c98f5', '计算机组成原理', '552caa539db8258bc497fd46');
insert into t_course(id, name, college) values('552fa98c91163b98c82c98f6', 'C++', '552caa539db8258bc497fd46');


#t_user
insert into t_user(id, name, college, 
                  major, teacher_title, workload,
                  price, remark, password,
                  salt) 
           values('2011082223', 'teacher', '552caa539db8258bc497fd46', 
           '552cadc99db825906cd033fb', '552f9fb291163b77ec3c3900', 150, 
           45, 'none', '86e03068b49bb58f3a8dc1ad85431082',
           'teacher');
insert into t_user(id, name, college, 
                  major, teacher_title, workload,
                  price, remark, password,
                  salt) 
           values('2011082222', 'teacher', '552caa539db8258bc497fd46', 
           '552cadc99db825906cd033fb', '552f9fb291163b77ec3c3900', 150, 
           45, 'none', '9e948c87079407022199a27ff6720a56',
           '20110822229249d7904dbeace568442e85bf5521f0');
#t_role
#1
insert into t_role(roles, description) values('teacher', 'teacher role');#7
insert into t_role(roles, description) values('mjadmin', 'major admin role');#8
insert into t_role(roles, description) values('clgadmin', 'college admin role');#9
insert into t_role(roles, description) values('admin', 'admin role');#10
#2
insert into t_role(roles, description) values('course', 'course role');#11

#t_role_permission
#1

#2
#course
insert into t_permission(permissions, description) values('course:create', 'query create');#9
insert into t_permission(permissions, description) values('course:delete', 'query delete');#10
insert into t_permission(permissions, description) values('course:update', 'query update');#11
insert into t_permission(permissions, description) values('course:query', 'query course');#12

#t_user_role
#用户角色
insert into t_user_role(user, role) values('2011082223', 7);
insert into t_user_role(user, role) values('2011082223', 8);
insert into t_user_role(user, role) values('2011082223', 9);
insert into t_user_role(user, role) values('2011082223', 10);
insert into t_user_role(user, role) values('2011082223', 11);

insert into t_user_role(user, role) values('2011082222', 7);
insert into t_user_role(user, role) values('2011082222', 8);
insert into t_user_role(user, role) values('2011082222', 9);
insert into t_user_role(user, role) values('2011082222', 10);
insert into t_user_role(user, role) values('2011082222', 11);

insert into t_user_role(user, role) values('2011082221', 7);
insert into t_user_role(user, role) values('2011082221', 8);
insert into t_user_role(user, role) values('2011082221', 9);
insert into t_user_role(user, role) values('2011082221', 10);
insert into t_user_role(user, role) values('2011082221', 11);

#t_role_permission
#1
#course11
insert into t_role_permission(role, permission) values(11, 9);
insert into t_role_permission(role, permission) values(11, 10);
insert into t_role_permission(role, permission) values(11, 11);
insert into t_role_permission(role, permission) values(11, 12);
#teacher
insert into t_role_permission(role, permission) values(7, 12);

#clgadmin
#2.
#course
insert into t_role_permission() values(1, 1);

select
	      r.roles
	    from t_user_role ur
	    left join t_user u on u.id = ur.user
	    left join t_role r on r.id = ur.role
	    where ur.user = '2011082223'

select
	      p.permissions
	    from t_user u, t_role r, t_permission p, t_user_role ur, t_role_permission rp
	    where u.id = '2011082223'
	    and u.id = ur.user
	    and r.id = ur.role
	    and r.id = rp.role 
	    and p.id = rp.permission

