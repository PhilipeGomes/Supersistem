import ProductCrudCard from "pages/Admin/Produtos/ProdutoCrudCard";
import "./styles.css";
import { Link } from 'react-router-dom';
import { useCallback, useEffect, useState } from "react";
import { SpringPage } from "types/vendor/spring";
import { Product } from "types/product";
import { requestBackend } from "util/requests";
import { AxiosRequestConfig } from "axios";
import Pagination from "components/Pagination";

type ControlComponentsData = {
    activePage: number;
}

const Lista = () => {

    const [page, setPage] = useState<SpringPage<Product>>();

    const [controlComponentsData, setControlComponentsData] = useState<ControlComponentsData>(
        {
            activePage: 0
        }
    );

    const handlePageChange = (pageNumber: number) => {
        setControlComponentsData({ activePage: pageNumber });
    }

    const getProducts = useCallback(() => {
        const config: AxiosRequestConfig = {
            method: 'GET',
            url: '/produtos',
            params: {
                page: controlComponentsData.activePage,
                size: 8,
            },
        };

        requestBackend(config).then((response) => {
            setPage(response.data);
        });
    }, [controlComponentsData]);

    useEffect(() => {
        getProducts();
    }, [getProducts]);

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
            <Pagination
                pageCount={(page) ? page.totalPages : 0}
                range={3}
                onChange={handlePageChange}
            />
        </div>

    );
};

export default Lista;