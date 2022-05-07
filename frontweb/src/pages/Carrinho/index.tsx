import React from 'react';
import {
  MDBCarousel,
  MDBCarouselInner,
  MDBCarouselItem,
  MDBCarouselElement,
  MDBCarouselCaption
} from 'mdb-react-ui-kit';

import { ReactComponent as MainImage } from 'assets/images/main-image.svg';
import ButtonIcon from 'components/ButtonIcon';
import { Link } from 'react-router-dom';

import './styles.css';


const Home = () => {
  return (
<div className="container">
     <div className="container-xl">
     <h1>Carrinho</h1>
     {/* os itens abaixo são apenas uma amostra, o conteúdo do carrinho será dinamico, precisamos apenas nos ater ao nome das classes e o tamanho da imagem*/}
     <div className='item'>
      <img className='img-produto' src="https://bompreco.vtexassets.com/arquivos/ids/164209-163-163?v=637517007811670000&width=163&height=163&aspect=true"></img>
      <p className='nome-item'>Nome do produto</p>
      <p className='qtd-item'>1</p>
      <button className='item'> Adicionar </button>
      <button className='item'> Retirar </button>
      <p className='preco-item'>R$ 9,99</p>    
     </div>
     <div className='item'>
      <img className='img-produto' src="https://bompreco.vtexassets.com/arquivos/ids/164209-163-163?v=637517007811670000&width=163&height=163&aspect=true"></img>
      <p className='nome-item'>Nome do produto</p>
      <p className='qtd-item'>1</p>
      <button className='item'> Adicionar </button>
      <button className='item'> Retirar </button>
      <p className='preco-item'>R$ 9,99</p>    
     </div>
     <div className='item'>
      <img className='img-produto' src="https://bompreco.vtexassets.com/arquivos/ids/164209-163-163?v=637517007811670000&width=163&height=163&aspect=true"></img>
      <p className='nome-item'>Nome do produto</p>
      <p className='qtd-item'>1</p>
      <button className='item'> Adicionar </button>
      <button className='item'> Retirar </button>
      <p className='preco-item'>R$ 9,99</p>    
     </div>
     <div className='item'>
      <img className='img-produto' src="https://bompreco.vtexassets.com/arquivos/ids/164209-163-163?v=637517007811670000&width=163&height=163&aspect=true"></img>
      <p className='nome-item'>Nome do produto</p>
      <p className='qtd-item'>1</p>
      <button className='item'> Adicionar </button>
      <button className='item'> Retirar </button>
      <p className='preco-item'>R$ 9,99</p>    
     </div>
     <div className='item'>
      <img className='img-produto' src="https://bompreco.vtexassets.com/arquivos/ids/164209-163-163?v=637517007811670000&width=163&height=163&aspect=true"></img>
      <p className='nome-item'>Nome do produto</p>
      <p className='qtd-item'>1</p>
      <button className='item'> Adicionar </button>
      <button className='item'> Retirar </button>
      <p className='preco-item'>R$ 9,99</p>    
     </div>
     <div className='item'>
      <img className='img-produto' src="https://bompreco.vtexassets.com/arquivos/ids/164209-163-163?v=637517007811670000&width=163&height=163&aspect=true"></img>
      <p className='nome-item'>Nome do produto</p>
      <p className='qtd-item'>1</p>
      <button className='item'> Adicionar </button>
      <button className='item'> Retirar </button>
      <p className='preco-item'>R$ 9,99</p>    
     </div>
     {/* A partir daqui é a interface de compra*/}
     <h5>Número de itens: {/*aquiRetornaNumeroDeItens*/}</h5>
     <h5>Valor: R$ 99,99 {/*aquiRetornaOpreco*/}</h5>
     <br></br>
     <div className='confirmacao'>
      <button>Ir para pagamento</button> {/*Evento seguinte a ser decidido, se mais uma página ou se pagamento em página externa*/}
      <br></br>
      <button>Cancelar</button> {/*Evento de limpar o carrinho*/}
     </div>
     
    </div>
</div>




  );
};

export default Home;
