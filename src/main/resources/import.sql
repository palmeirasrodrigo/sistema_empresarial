INSERT INTO regioes(id, nome) VALUES(1, 'Sulamerica');
INSERT INTO regioes(id, nome) VALUES(2, 'Europa');
INSERT INTO regioes(id, nome) VALUES(3, 'Asia');
INSERT INTO regioes(id, nome) VALUES(4, 'Africa');
INSERT INTO regioes(id, nome) VALUES(5, 'Oceania');

INSERT INTO clientes(regiao_id, nome,sobrenome,email,create_at) VALUES (1,'Rodrigo','Negrão', 'palmeiras@hotmail.com','1985-12-16');
INSERT INTO clientes(regiao_id,nome,sobrenome,email,create_at) VALUES (3,'Elicia','Duarte', 'elicia@hotmail.com','1996-02-02');
INSERT INTO clientes(regiao_id,nome,sobrenome,email,create_at) VALUES (2,'Ricardo','Negrão', 'ricardo@hotmail.com','1990-02-04');
INSERT INTO clientes(regiao_id,nome,sobrenome,email,create_at) VALUES (4,'Maria','Madalena', 'lia@hotmail.com','1963-09-29');
INSERT INTO clientes(regiao_id,nome,sobrenome,email,create_at) VALUES (5,'Renato','Negrão', 'palmeiras1@hotmail.com','1985-12-16');
INSERT INTO clientes(regiao_id,nome,sobrenome,email,create_at) VALUES (3,'Vanessa','Duarte', 'elicia1@hotmail.com','1996-02-02');
INSERT INTO clientes(regiao_id,nome,sobrenome,email,create_at) VALUES (4,'Luana','Negrão', 'ricardo1@hotmail.com','1990-02-04');
INSERT INTO clientes(regiao_id,nome,sobrenome,email,create_at) VALUES (1,'Sergio','Madalena', 'lia1@hotmail.com','1963-09-29');
INSERT INTO clientes(regiao_id,nome,sobrenome,email,create_at) VALUES (2,'Cabinho','Negrão', 'palmeiras2@hotmail.com','1985-12-16');
INSERT INTO clientes(regiao_id,nome,sobrenome,email,create_at) VALUES (3,'Terezinha','Duarte', 'elicia2@hotmail.com','1996-02-02');
INSERT INTO clientes(regiao_id,nome,sobrenome,email,create_at) VALUES (4,'Nete','Negrão', 'ricardo2@hotmail.com','1990-02-04');
INSERT INTO clientes(regiao_id,nome,sobrenome,email,create_at) VALUES (5,'Toni','Madalena', 'lia2@hotmail.com','1963-09-29');


INSERT INTO `roles` (nome) VALUES ('ROLE_USER');
INSERT INTO `roles` (nome) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios` (username, password, enabled, nome, sobrenome, email) VALUES ('rodrigo','$2a$10$4.yED9goCP.XpHi4VHTBAOIMHSVpBgnq0ij6ol/BYuoPAsAMfisCC',1, 'Borja', 'matador', 'borja@bol.com');
INSERT INTO `usuarios` (username, password, enabled, nome, sobrenome, email) VALUES ('admin','$2a$10$ZKiooES9XTsGrJCVQMW7WeEzK2t98Vxt8CtoPAvTM0EjMhI20pKwS',1, 'Deyyverson', 'maluco', 'dey@bol.com');


INSERT INTO `usuarios_roles` (usuario_id, roles_id) VALUES (1,1);
INSERT INTO `usuarios_roles` (usuario_id, roles_id) VALUES (2,2);
INSERT INTO `usuarios_roles` (usuario_id, roles_id) VALUES (2,1);

INSERT INTO produtos (nome, preco, create_at) VALUES ('Panasonic Lcd', 259990, NOW()); 
INSERT INTO produtos (nome, preco, create_at) VALUES ('Sony camera', 359990, NOW()); 
INSERT INTO produtos (nome, preco, create_at) VALUES ('Apple noteboo',59990, NOW()); 
INSERT INTO produtos (nome, preco, create_at) VALUES ('Video game', 25990, NOW()); 

INSERT INTO faturas (descricao, observacao, cliente_id, create_at) VALUES ('Faturas de equipamento de oficina', null, 1, NOW());

INSERT INTO faturas_itens (quantidade, fatura_id, produto_id) VALUES (1, 1, 1);
INSERT INTO faturas_itens (quantidade, fatura_id, produto_id) VALUES (2, 1, 3);
INSERT INTO faturas_itens (quantidade, fatura_id, produto_id) VALUES (3, 1, 2);
INSERT INTO faturas_itens (quantidade, fatura_id, produto_id) VALUES (4, 1, 4);

INSERT INTO faturas (descricao, observacao, cliente_id, create_at) VALUES ('Faturas de equipamento de computador', null, 2, NOW());

INSERT INTO faturas_itens (quantidade, fatura_id, produto_id) VALUES (2, 2, 1);
INSERT INTO faturas_itens (quantidade, fatura_id, produto_id) VALUES (4, 2, 3);
INSERT INTO faturas_itens (quantidade, fatura_id, produto_id) VALUES (5, 2, 2);
INSERT INTO faturas_itens (quantidade, fatura_id, produto_id) VALUES (4, 2, 4);

