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
        <form className='formulario'>
          <h1>Minha conta</h1>
          
          <label id="email">Email:</label>
          
          <input type="text" id="email" name="email" placeholder="email@gmail.com"/>
          
          <label id="senha">Senha</label>
          
          <input type="password" id="senha" name="senha"/>

          <button type="button">Logar</button> 
          <button type="button">Perdi a senha</button> 
          
        </form>
        </div>

  );
};

export default Home;
