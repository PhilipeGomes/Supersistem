import { BrowserRouter, Switch, Route, Redirect } from 'react-router-dom';
import Home from 'pages/Home';
import Navbar from 'components/Navbar';
import Catalog from 'pages/Catalog';
import Admin from 'pages/Admin';
import Cadastro from 'pages/Cadastro';
import Login from 'pages/Login';
import ProductDetails from 'pages/ProductDetails';
import Carrinho from 'pages/Carrinho';
import Erro from 'pages/Erro';
import 'bootstrap';
import 'bootstrap/dist/js/bootstrap.js';
import 'bootstrap/dist/css/bootstrap.css';

const Routes = () => (
  <BrowserRouter>
    <Navbar />
    <Switch>
      <Route path="/" exact>
        <Home />
      </Route>
      <Route path="/carrinho" exact>
        <Carrinho />
      </Route>
      <Route path="/form" exact>
        <Cadastro />
      </Route>
      <Route path="/login" exact>
        <Login />
      </Route>
      <Route path="/products" exact>
        <Catalog />
      </Route>
      <Route path="/produtos/:productId" >
        <ProductDetails />
      </Route>
      <Redirect from="/admin" to="/admin/produtos" exact />
      <Route path="/admin">
        <Admin />
      </Route>
      <Route path="*" >
      <Erro />
      </Route>
    </Switch>
  </BrowserRouter>
);

export default Routes;
