import React from 'react';
import lupa from "./assets/lupa.png"



import './styles.css';

const Erro = () => {
  return (
    <div className="container">
     <div className="container-xl">
      <h1>Erro 404</h1>
      <h3>Procuramos por tudo, mas não conseguimos achar o que você procurava aqui</h3>
      <br></br>
      <img src={lupa}/>
      <p>Continue procurando ofertas acesse o catálogo</p>
     </div>
    </div>
  );
};

export default Erro;
