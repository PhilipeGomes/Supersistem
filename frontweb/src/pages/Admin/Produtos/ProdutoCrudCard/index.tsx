import ProductPrice from 'components/ProductPrice';
import { Product } from 'types/product';
import SeloCategoria from 'pages/Admin/Produtos/SeloCategoria';

import './styles.css';
import { Link } from 'react-router-dom';
import { AxiosRequestConfig } from 'axios';
import { requestBackend } from 'util/requests';

type Props = {
    product: Product;
    onDelete: Function;
}

const ProductCrudCard = ({ product, onDelete }: Props) => {

    const handleDelete = (produtoId: number) => {

        if(!window.confirm("Tem certeza que deseja deletar?")){
            return;
        }

        const config: AxiosRequestConfig = {
            method: 'DELETE',
            url: `/produtos/${produtoId}/deletar`
        };

        requestBackend(config).then(() => {
            onDelete();
        });
    }

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
                    {product.categorias.map(categoria => (
                        <SeloCategoria nome={categoria.nome} key={categoria.id} />
                    ))}
                </div>
            </div>
            <div className="product-crud-card-buttons-container">
                <button
                    onClick={() => handleDelete(product.id)}
                    className="btn btn-outline-danger product-crud-card-button product-crud-card-button-first ">
                    EXCLUIR
                </button>
                <Link to={`/admin/produtos/${product.id}`}>
                    <button className="btn btn-outline-secondary product-crud-card-button">
                        EDITAR
                    </button>
                </Link>
            </div>
        </div>
    );
}

export default ProductCrudCard;