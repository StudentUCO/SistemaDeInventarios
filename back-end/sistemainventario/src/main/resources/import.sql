INSERT INTO producto (idproducto,nombre,codigo,activo) values (1,'Arduino Nano','001',true)
INSERT INTO producto (idproducto,nombre,codigo,activo) values (2,'Arduino Uno','002',true)

INSERT INTO inventario (idinventario,idproducto,cantidad) values (1,1,100)
INSERT INTO inventario (idinventario,idproducto,cantidad) values (2,2,100)



INSERT INTO usuario (id_usuario,nombre_usuario, password, enabled ) values (1,'diego','$2a$10$LXvl9cEhPNTO9pX9ApvPG.sPlrm0LuvxHDLmmw8gMFE6BZiwGCwhO', true)
INSERT INTO usuario (id_usuario,nombre_usuario, password, enabled ) values (2,'anonimo','$2a$10$JHfTc8j5g1ZiSgzy4H1h8uFOO1uR3opBhxjRT/P/c1BHCnUgNqIwi', true)

INSERT INTO roles (id_rol,nombre_rol) values (1,'ROLE_ADMIN')
INSERT INTO roles (id_rol,nombre_rol) values (2,'ROLE_CONSULTA')
INSERT INTO users_authorities (id_usuario, id_rol ) values (1,1)
INSERT INTO users_authorities (id_usuario, id_rol ) values (2,2)
