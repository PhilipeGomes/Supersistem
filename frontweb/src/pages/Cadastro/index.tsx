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
      <div className='cadastro'>
        <img id="logoCadastro" src="icon_sem_fundo.png" width="5%" height="5%"/>
      <section className="form-container">
      <div className='column'>
        <div className="columnEsquerda">
        <form className='formulario'>
          <h1>Cadastre-se</h1>
          <label id="nome">Nome:</label>
          
          <input type="text" id="nome" name="nome" placeholder="Seu Nome"/>
        
          <label id="login">Login:</label>
          
          <input type="text" id="login" name="login" placeholder="Login"/>
          
          <label id="cpf">CPF:</label>
          
          <input type="text" id="cpf" name="cpf" maxLength={11} />
          
          <label id="telefone">Telefone:</label>
          
          <input type="tel" id="phone" name="phone" pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}" maxLength={14} />
          
          <label id="email">Email:</label>
          
          <input type="text" id="email" name="email"/>
          
          <label id="senha">Senha</label>
          
          <input type="password" id="senha" name="senha"/>

          <button type="button">Cadastrar</button> 
          
        </form>
        </div>
      </div>
      <div className='column'>
      <div className='columnDireita'>
        <img src="https://pefmbddiag.blob.core.windows.net/cdn-blog-pi/output/img/materia/37815778-087b-4879-80eb-2f6408dfc2f7.jpg"/>
      </div>
      <p>Conheça nosso cátalogo de produtos</p>
      
      </div>
      </section>
      
      </div>
    
  );
};

export default Home;
