INSERT INTO tb_cliente(nome, cpf, telefone, email) VALUES ('Alan Turing','111.222.333-44','3030-2020','alan_turing@ufrpe.com');
INSERT INTO tb_cliente(nome, cpf, telefone, email) VALUES ('Albert Einstein','112.222.333-44','3030-2021','albert_einstein@ufrpe.com');
INSERT INTO tb_cliente(nome, cpf, telefone, email) VALUES ('Isaac Newton','113.222.333-44','3030-2022','isacc_newton@ufrpe.com');
INSERT INTO tb_cliente(nome, cpf, telefone, email) VALUES ('Marie Curie','114.222.333-44','3030-2022','marie_curie@ufrpe.com');

INSERT INTO tb_vendedor(nome) VALUES ('Gregor Mendel');
INSERT INTO tb_vendedor(nome) VALUES ('Michael Faraday');

INSERT INTO tb_produto(nome, valor, qtd_estoque, marca, img_url, descricao, und_venda) VALUES ('Macarrão',10, 10,'Pilar','https://arcomixstr.blob.core.windows.net/product/5150-macarrao-fino-pilar-500g-g.jpg','Macarrão Pilar', '500g');
INSERT INTO tb_produto(nome, valor, qtd_estoque, marca, img_url, descricao, und_venda) VALUES ('Tv',10, 10,'LG','https://a-static.mlcdn.com.br/618x463/smart-tv-43-full-hd-led-lg-43lm6370-60hz-wi-fi-bluetooth-hdr-3-hdmi-2-usb/magazineluiza/228884600/70630c2c1c122ef9c67e51a0a5b92acd.jpg','Tv LG', '1Und');
INSERT INTO tb_produto(nome, valor, qtd_estoque, marca, img_url, descricao, und_venda) VALUES ('Desktop',10, 10,'Dell','https://a-static.mlcdn.com.br/618x463/desktop-dell-vostro-vst-3268-a40m-7a-geracao-intel-core-i5-8gb-1tb-windows-10-pro-com-monitor-21-5/dell/cav3268w10p1801504br-p2/e02babafd6b9861e6bdd084bf2c8225f.jpg','Desktop Dell', '1Und');
INSERT INTO tb_produto(nome, valor, qtd_estoque, marca, img_url, descricao, und_venda) VALUES ('The Lord of the Rings', 90.5, 10, 'Marca', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg',  'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.','1Und');

INSERT INTO tb_pedido(total, data_pedido, cliente_id, vendedor_id, status) VALUES ('teste','2021-01-01T12:00:00Z', 1, 1, 0);
INSERT INTO tb_pedido(total, data_pedido, cliente_id, vendedor_id, status) VALUES ('teste1','2021-01-01T12:00:00Z', 2, 2, 0);
INSERT INTO tb_pedido(total, data_pedido, cliente_id, vendedor_id, status) VALUES ('teste2','2021-01-01T12:00:00Z', 3, 1, 0);

INSERT INTO tb_categoria(nome) VALUES ('Alimento');
INSERT INTO tb_categoria(nome) VALUES ('Livros');
INSERT INTO tb_categoria(nome) VALUES ('Eletrônico');
INSERT INTO tb_categoria(nome) VALUES ('Computadores');

INSERT INTO tb_produto_categoria(produto_id, categoria_id) VALUES ( 1, 1);
INSERT INTO tb_produto_categoria(produto_id, categoria_id) VALUES ( 2, 3);
INSERT INTO tb_produto_categoria(produto_id, categoria_id) VALUES ( 3, 4);
INSERT INTO tb_produto_categoria(produto_id, categoria_id) VALUES ( 4, 2);