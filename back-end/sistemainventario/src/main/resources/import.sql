INSERT INTO producto (idproducto,nombre,codigo,activo) values (1,'Arduino Nano','001',true)
INSERT INTO producto (idproducto,nombre,codigo,activo) values (2,'Arduino Uno','002',true)

INSERT INTO inventario (idinventario,idproducto,cantidad) values (1,1,100)
INSERT INTO inventario (idinventario,idproducto,cantidad) values (2,2,100)


INSERT INTO usuario (id_usuario,nombre_usuario, password, enabled ) values (1,'juan','$2a$10$LXvl9cEhPNTO9pX9ApvPG.sPlrm0LuvxHDLmmw8gMFE6BZiwGCwhO', true)
INSERT INTO usuario (id_usuario,nombre_usuario, password, enabled ) values (2,'juanes','$2a$10$67.bRA3bwhfWYIixkwZl3O/KzLjUB8jzQH7azaAVZ.nKf488wAM5q', true)
INSERT INTO usuario (id_usuario,nombre_usuario, password, enabled ) values (3,'admin','$2a$10$7IiIY2rzd3Tm9CrOLrNsY.LJ6t6WvYmINFIbYJNguz4v94Dsb1vIS', true)
INSERT INTO usuario (id_usuario,nombre_usuario, password, enabled ) values (4,'guest','$2a$10$Cb7zIyAbG5koPgzCU0GRmOMce8ZteSDelruH5vAhSrZE53rBxVLfq', true)

INSERT INTO roles (id_rol,nombre_rol) values (1,'ROLE_ADMIN')
INSERT INTO roles (id_rol,nombre_rol) values (2,'ROLE_CONSULTA')
INSERT INTO users_authorities (id_usuario, id_rol ) values (1,1)
INSERT INTO users_authorities (id_usuario, id_rol ) values (2,2)
INSERT INTO users_authorities (id_usuario, id_rol ) values (3,1)
INSERT INTO users_authorities (id_usuario, id_rol ) values (4,2)	
