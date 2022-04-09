import { BrowserRouter, Switch, Route, Redirect } from 'react-router-dom';
import Home from 'pages/Home';
import Navbar from 'components/Navbar';
import Catalog from 'pages/Catalog';
import Admin from 'pages/Admin';
import Form from 'pages/Cadastro';
import Login from 'pages/Login';
import ProductDetails from 'pages/ProductDetails';
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
      <Route path="/form" exact>
        <Form />
      </Route>
      <Route path="/login" exact>
        <Login />
      </Route>
      <Route path="/products" exact>
        <Catalog />
      </Route>
      <Route path="/produtos/:productId">
        <ProductDetails />
      </Route>
      <Redirect from="/admin" to="/admin/products" exact />
      <Route path="/admin">
        <Admin />
      </Route>
    </Switch>
  </BrowserRouter>
);

export default Routes;
