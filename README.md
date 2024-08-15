Luego de haber ejecutado el proyecto, agregar usuarios, roles, y relacion roles usuarios con el siguiente script:

insert into t_role(name) values ('ROLE_ADMIN')
insert into t_role(name) values ('ROLE_USER')
insert into t_role(name) values ('ROLE_VISIT')

insert into t_USER(first_name, last_name, password, username) values ('luis', 'garrido', '$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6', 'ubaldoadr');
insert into t_USER(first_name, last_name, password, username) values ('jose', 'carreño', '$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6', 'manunache');
insert into t_USER(first_name, last_name, password, username) values ('ana', 'paz', '$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6', 'anita')

insert into t_user_role(user_id, role_id) values (1,1);
insert into t_user_role(user_id, role_id) values (2,2);
insert into t_user_role(user_id, role_id) values (3,3)

Una vez agregado, ir a postman, logear con el siguiente usuario:
{"username":"ubaldoadr","password":"1234"}
Luego crear los siguientes request:

FindAll:
GET localhost:8090/dvd/api/proyectos

Create:
POST localhost:8090/dvd/api/proyectos

FindOne:
GET localhost:8090/dvd/api/proyectos/1

Update:
PUT localhost:8090/dvd/api/proyectos/1

Delete:
DELETE localhost:8090/dvd/api/proyectos/1

Nota: para realizar las pruebas se debe crear al menos un proyecto, ejemplo: 
{"name":"automercado","contact":"121212", "status":"en pausa"}
