import './styles.css';

import ProductPrice from 'components/ProductPrice';
import { Product } from 'types/product';

type Props = {
    product: Product;
}

const ProductCard = ( { product } : Props) => {

    return (
        <div className="base-card product-card">
            <div className="card-top-container">
                <img src={product.imgUrl} alt={product.nome} />
            </div>
            <div className="card-bottom-container">
                <h6>{product.nome}</h6>
                <ProductPrice price={product.valor} />
            </div>
        </div>
    );
}

export default ProductCard;