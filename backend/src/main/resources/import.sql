INSERT INTO tb_cliente(nome, cpf, telefone, email) VALUES ('Alan Turing','111.222.333-44','3030-2020','alan_turing@ufrpe.com');
INSERT INTO tb_cliente(nome, cpf, telefone, email) VALUES ('Albert Einstein','112.222.333-44','3030-2021','albert_einstein@ufrpe.com');
INSERT INTO tb_cliente(nome, cpf, telefone, email) VALUES ('Isaac Newton','113.222.333-44','3030-2022','isacc_newton@ufrpe.com');
INSERT INTO tb_cliente(nome, cpf, telefone, email) VALUES ('Marie Curie','114.222.333-44','3030-2022','marie_curie@ufrpe.com');

INSERT INTO tb_vendedor(nome) VALUES ('Gregor Mendel');
INSERT INTO tb_vendedor(nome) VALUES ('Michael Faraday');

INSERT INTO tb_produto(nome, valor, qtd_estoque, marca) VALUES ('Macarrão',10,10,'Pilar');
INSERT INTO tb_produto(nome, valor, qtd_estoque, marca) VALUES ('Tv',10,10,'LG');
INSERT INTO tb_produto(nome, valor, qtd_estoque, marca) VALUES ('Desktop',10,10,'Dell');

INSERT INTO tb_pedido(total, data_pedido, cliente_id, vendedor_id, status) VALUES ('teste','2021-01-01T12:00:00Z', 1, 1, 0);
INSERT INTO tb_pedido(total, data_pedido, cliente_id, vendedor_id, status) VALUES ('teste1','2021-01-01T12:00:00Z', 2, 2, 0);
INSERT INTO tb_pedido(total, data_pedido, cliente_id, vendedor_id, status) VALUES ('teste2','2021-01-01T12:00:00Z', 3, 1, 0);