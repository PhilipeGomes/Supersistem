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

import img1 from '../../assets/images/img1.png';
import img2 from '../../assets/images/img2.jpg';
import img3 from '../../assets/images/img3.jpg';

import './styles.css';

const Home = () => {
  return (
    <>
      <div className = 'container'>
      <MDBCarousel showControls showIndicators dark fade>
        <MDBCarouselInner>
          <MDBCarouselItem className='active'>
            <MDBCarouselElement src={img2} alt='...' className='d-block w-100' width="193" height="400"/>
            <MDBCarouselCaption>
            </MDBCarouselCaption>
          </MDBCarouselItem>

          <MDBCarouselItem>
            <MDBCarouselElement src={img3} alt='...' className='d-block w-100' with='1' width="193" height="400"/>
            <MDBCarouselCaption>
            </MDBCarouselCaption>
          </MDBCarouselItem>

          <MDBCarouselItem>
            <MDBCarouselElement src={img1} alt='...' className='d-block w-100' with='1' width="193" height="400"/>
            <MDBCarouselCaption>
            </MDBCarouselCaption>
          </MDBCarouselItem>
        </MDBCarouselInner>
      </MDBCarousel>
      </div>
      <div className="home-container">
        <div className="base-card home-card">
          <div className="home-content-container">
            <div>
              <h1>Conheça o melhor catálogo de produtos</h1>
              <p>
                Ajudaremos você a encontrar os melhores produtos disponíveis no
                mercado.
              </p>
            </div>
            <div>
              <Link to="/products">
                <ButtonIcon text="Inicie agora a sua busca" />
              </Link>
            </div>
          </div>
          <div className="home-image-container">
            <MainImage />
          </div>
        </div>
      </div>
    </>
  );
};

export default Home;
