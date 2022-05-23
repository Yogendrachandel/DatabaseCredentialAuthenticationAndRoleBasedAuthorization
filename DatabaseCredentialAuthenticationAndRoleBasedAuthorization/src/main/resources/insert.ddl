


insert into roles (name) values ('USER');
insert into roles (name) values ('CREATOR');
insert into roles (name) values ('EDITOR');
insert into roles (name) values ('ADMIN');


insert into users (username,password,enabled) values ('nilesh','$2a$10$NXiYE0A/Vv.C.dJQ1SU6HOYL5lszNq2CzrfqeLJN8MXg99NMPGfMa','1');
insert into users (username,password,enabled) values ('mahesh','$2a$10$/gdTLTghotaIYZoJhVm2/epKc2Fl3lG.QQEU5h3cozrAPIh1UF.bm','1');
insert into users (username,password,enabled) values ('suresh','$2a$10$OaayPYRRbDCw5zIynMYGnupdOCBi0o2VjaFUS/UQ1AUSgDM0qVade','1');
insert into users (username,password,enabled) values ('ramesh','$2a$10$Xp5nVZ6GCdRIAf.dYje2I.ThbxrJ8A9AOqJHlbHeUUNiXKbKa/bFG','1');
insert into users (username,password,enabled) values ('admin','$2a$10$NHRNQrfI2vCbeNQDbJdEM.0ihAKPh7FxKlUn46tqM.kTlK4IqyOX6','1');


insert into users_roles (user_id,role_id) values (1,1);
insert into users_roles (user_id,role_id) values (2,2);
insert into users_roles (user_id,role_id) values (3,3);
insert into users_roles (user_id,role_id) values (4,2);
insert into users_roles (user_id,role_id) values (4,3);
insert into users_roles (user_id,role_id) values (5,4);


insert into student (name,scity) values ('nilesh','Nanital');
insert into student (name,scity) values ('suresh','surat');
insert into student (name,scity) values ('mahesh','MP');
insert into student (name,scity) values ('ravi','Ranipur');
