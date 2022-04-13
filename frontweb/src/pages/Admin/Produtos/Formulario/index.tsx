import './styles.css';
import { useForm } from 'react-hook-form';
import { Product } from 'types/product';
import { requestBackend } from 'util/requests';
import { AxiosRequestConfig } from 'axios';
import { useHistory, useParams } from 'react-router-dom';
import { useEffect } from 'react';
import img_sem_foto from 'assets/images/sem_foto.png';


type UrlParams = {
    produtoId: string;
  };

const Formulario = () => {

    const { produtoId } = useParams<UrlParams>();

    const isEditing = produtoId !== 'criar';

    const history = useHistory();

    const {
        register,
        handleSubmit,
        formState: { errors },
        setValue,
    } = useForm<Product>();

    useEffect(() => {
        if(isEditing) {
            requestBackend({ url: `produtos/${produtoId}`})
            .then((response) => {
                const produto = response.data as Product;
                setValue('nome', produto.nome);
                setValue('valor', produto.valor);
                setValue('descricao', produto.descricao);
                setValue('qtdEstoque', produto.qtdEstoque);
                setValue('marca', produto.marca);
                setValue('undVenda', produto.undVenda);
                setValue('imgUrl', produto.imgUrl);
                setValue('categorias', produto.categorias);
            });
        }
    }, [isEditing, produtoId,setValue]);

    const onSubmit = (formData: Product) => {

        const data = {
            ...formData,
            imgUrl : isEditing
            ? formData.imgUrl
            : 'https://www.goiania.go.leg.br/imagens/sem-foto/image_view_fullscreen',
            categoria : isEditing ? formData.categorias : [{id: 1, nome: ''}],
        }

        const config: AxiosRequestConfig = {
            method: isEditing ? 'PUT' : 'POST',
            url: isEditing ? `/produtos/${produtoId}/editar` : '/produtos',
            data
        };

        requestBackend(config).then(() => {
            history.push("/admin/produtos");
            });
    };


    const handleCancel = () => {
        history.push("/admin/produtos");
    }

    return (
        <div className="product-crud-container">
            <div className="base-card product-crud-form-card">
                <h1 className="product-crud-form-title">DADOS DO PRODUTO</h1>

                <form onSubmit={handleSubmit(onSubmit)}>
                    <div className="row product-crud-inputs-container">
                        <div className="col-lg-6 product-crud-inputs-left-container">
                            <div className="margin-bottom-30">
                                <input {...register('nome', {
                                    required: 'Campo Obrigaório'
                                })}
                                    type="text"
                                    className={`form-control base-input ${errors.nome ? 'is-invalid' : ''
                                        }`}
                                    placeholder="Nome do produto"
                                    name="nome"
                                />
                                <div className="invalid-feedback d-block">
                                    {errors.nome?.message}
                                </div>
                            </div>

                            <div className="margin-bottom-30">
                                <input {...register('valor', {
                                    required: 'Campo Obrigaório'
                                })}
                                    type="text"
                                    className={`form-control base-input ${errors.valor ? 'is-invalid' : ''
                                        }`}
                                    placeholder="Preço"
                                    name="valor"
                                />
                                <div className="invalid-feedback d-block">
                                    {errors.valor?.message}
                                </div>
                            </div>
                            
                            <div className="margin-bottom-30">
                                <input {...register('qtdEstoque', {
                                    required: 'Campo Obrigaório'
                                })}
                                    type="text"
                                    className={`form-control base-input ${errors.qtdEstoque ? 'is-invalid' : ''
                                        }`}
                                    placeholder="Quantidade no estoque"
                                    name="qtdEstoque"
                                />
                                <div className="invalid-feedback d-block">
                                    {errors.qtdEstoque?.message}
                                </div>
                            </div>
                            <div className="margin-bottom-30">
                                <input {...register('marca', {
                                    required: 'Campo Obrigaório'
                                })}
                                    type="text"
                                    className={`form-control base-input ${errors.marca ? 'is-invalid' : ''
                                        }`}
                                    placeholder="Marca"
                                    name="marca"
                                />
                                <div className="invalid-feedback d-block">
                                    {errors.marca?.message}
                                </div>
                            </div>
                            <div className="margin-bottom-30">
                                <input {...register('undVenda', {
                                    required: 'Campo Obrigaório'
                                })}
                                    type="text"
                                    className={`form-control base-input ${errors.undVenda ? 'is-invalid' : ''
                                        }`}
                                    placeholder="Unidade de venda"
                                    name="undVenda"
                                />
                                <div className="invalid-feedback d-block">
                                    {errors.undVenda?.message}
                                </div>
                            </div>
                        </div>
                        <div className="col-lg-6">
                            <div>
                                <textarea
                                    rows={10}
                                    {...register('descricao', {
                                        required: 'Campo Obrigaório'
                                    })}
                                    className={`form-control base-input h-auto ${errors.valor ? 'is-invalid' : ''
                                        }`}
                                    placeholder="Descrição"
                                    name="descricao"
                                />
                                <div className="invalid-feedback d-block">
                                    {errors.valor?.message}
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="product-crud-buttons-container">
                        <button 
                        className="btn btn-outline-danger product-crud-button"
                        onClick={handleCancel}
                        >CANCELAR</button>
                        <button className="btn btn-outline-primary product-crud-button">SALVAR</button>
                    </div>
                </form>

            </div>
        </div>
    )
}

export default Formulario;