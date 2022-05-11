import ProductPrice from 'components/ProductPrice';
import { Product } from 'types/product';
import SeloCategoria from 'pages/Admin/Produtos/SeloCategoria';

import './styles.css';
import { Link } from 'react-router-dom';
import { AxiosRequestConfig } from 'axios';
import { requestBackend } from 'util/requests';
import * as React from 'react';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';

type Props = {
  product: Product;
  onDelete: Function;
};

const ProductCrudCard = ({ product, onDelete }: Props) => {
  const handleDelete = (produtoId: number) => {
    const config: AxiosRequestConfig = {
      method: 'DELETE',
      url: `/produtos/${produtoId}/deletar`,
    };

    requestBackend(config).then(() => {
      onDelete();
    });

    handleClose();
  };

  const [open, setOpen] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  return (
    <div className="base-card product-crud-card">
      <div className="product-crud-card-top-container">
        <img src={product.imgUrl} alt={product.nome} />
      </div>
      <div className="product-crud-card-description">
        <div className="product-crud-card-bottom-container">
          <h6>{product.nome}</h6>
          <ProductPrice price={product.valor} />
        </div>
        <div className="product-crud-categories-container">
          {product.categorias.map((categoria) => (
            <SeloCategoria nome={categoria.nome} key={categoria.id} />
          ))}
        </div>
      </div>
      <div className="product-crud-card-buttons-container">
        <button
          onClick={handleOpen}
          className="btn btn-outline-danger product-crud-card-button product-crud-card-button-first "
        >
          EXCLUIR
        </button>
        <Modal
          open={open}
          onClose={handleClose}
          aria-labelledby="modal-modal-title"
          aria-describedby="modal-modal-description"
        >
          <div className="modal">
            <Box>
              <div className="dialog-geral">
                <Typography className={'dialog-title'}>Excluir</Typography>
                <Typography className={'dialog-subtitle'}>
                  Tem certeza que deseja excluir {product.nome}?
                </Typography>
              </div>
              <div className="position">
                <button onClick={handleClose} className="button-geral">
                  Não
                </button>
                <button
                  onClick={() => handleDelete(product.id)}
                  className="button-geral"
                >
                  Sim
                </button>
              </div>
            </Box>
          </div>
        </Modal>
        <Link to={`/admin/produtos/${product.id}`}>
          <button className="btn btn-outline-secondary product-crud-card-button">
            EDITAR
          </button>
        </Link>
      </div>
    </div>
  );
};

export default ProductCrudCard;
