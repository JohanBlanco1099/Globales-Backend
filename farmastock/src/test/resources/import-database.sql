/** Privilege **/
INSERT INTO public.privilege (id, name) VALUES (1, 'WRITE_PRIVILEGE');
INSERT INTO public.privilege (id, name) VALUES (2, 'READ_PRIVILEGE');

/** Role **/
INSERT INTO public.role (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.role (id, name) VALUES (2, 'ROLE_USER');

/** Role-Privilege **/
INSERT INTO public.role_privilege (role_id, privilege_id) VALUES (1, 1);
INSERT INTO public.role_privilege (role_id, privilege_id) VALUES (1, 2);
INSERT INTO public.role_privilege (role_id, privilege_id) VALUES (2, 2);

/** Users **/
INSERT INTO public.users (id, create_date, email, enabled, first_name, last_name, password, token_expired) VALUES (1, '2020-08-30 18:23:52.000000', 'admin@guzmanalan.com', true, 'Maikol', 'Guzman', '$2a$10$6hg/QTw8Th1EmYtg9/5HhOmRdg320A6J8DumNUqx.4AltXZAjp0VK', false);
INSERT INTO public.users (id, create_date, email, enabled, first_name, last_name, password, token_expired) VALUES (2, '2022-04-16 08:24:48.000000', 'user@guzmanalan.com', true, 'User', 'Guzman', '$2a$10$6hg/QTw8Th1EmYtg9/5HhOmRdg320A6J8DumNUqx.4AltXZAjp0VK', false);

/** User-Role **/
INSERT INTO public.user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO public.user_role (user_id, role_id) VALUES (2, 2);

/** Medicine **/
INSERT INTO public.medicine (id, name,dose,quantity) VALUES (1, 'CATAFLAN',2,6);
INSERT INTO public.medicine (id, name,dose,quantity) VALUES (2, 'ACETAMINOFEN',5,10);
INSERT INTO public.medicine (id, name,dose,quantity) VALUES (3, 'RUPAX',1,4);

/** Reminder **/
INSERT INTO public.reminder (id,description, create_date,state,medicine_id,user_id) VALUES (1, 'DOLOR DE CABEZA','2020-08-30 18:23:52.000000',true,1,2);
INSERT INTO public.reminder (id,description, create_date,state,medicine_id,user_id) VALUES (2, 'DOLOR DE PECHO','2020-08-30 18:23:52.000000',true,2,2);
INSERT INTO public.reminder (id,description, create_date,state,medicine_id,user_id) VALUES (3, 'DOLOR DE NARIZ','2020-08-30 18:23:52.000000',true,3,2);





