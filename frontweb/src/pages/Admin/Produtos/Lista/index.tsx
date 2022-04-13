import ProductCrudCard from "pages/Admin/Produtos/ProdutoCrudCard";
import "./styles.css";
import { Link } from 'react-router-dom';
import { useEffect, useState } from "react";
import { SpringPage } from "types/vendor/spring";
import { Product } from "types/product";
import { AxiosParams } from "types/vendor/axios";
import { BASE_URL } from "util/requests";
import axios from "axios";

const Lista = () => {

    const [page, setPage] = useState<SpringPage<Product>>();

    useEffect(() => {
        const params: AxiosParams = {
            method: 'GET',
            url: `${BASE_URL}/produtos`,
            params: {
                page: 0,
                size: 12,
            },
        };

        axios(params)
            .then((response) => {
                setPage(response.data);
            })
    }, []);


    return (
        <div className="product-crud-container">
            <div className="product-crud-bar-container">
                <Link to="/admin/produtos/criar">
                    <button className="btn btn-primary text-white btn-crud-add">ADICIONAR</button>
                </Link>

                <div className="base-card product-filter-container">
                    Barra de busca
                </div>
            </div>
            <div className="row">
                {
                    page?.content.map(produto => (
                        <div key={produto.id} className="col-sm-6 col-md-12">
                            <ProductCrudCard product={produto} />
                        </div>
                    ))}
            </div>

        </div>

    )
}

export default Lista;