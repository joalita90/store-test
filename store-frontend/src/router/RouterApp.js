import React from 'react'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import NavBar from '../components/NavBar'
import Producto from '../components/Producto/Producto'
import Empresa from '../components/Empresa/Empresa';
import Cliente from '../components/Cliente/Cliente'
import OrdenCompra from '../components/OrdenCompra/OrdenCompra';


const RouterApp = () => {

  const apiUrl = 'http://localhost:8080/';
  return (
    <Router>
      <div>
        <NavBar />
        <div className="container">
            <Routes>
                <Route path="/producto" element={<Producto apiUrl={apiUrl} />} />
                <Route path="/empresa" element={<Empresa apiUrl={apiUrl} setIsAuthenticated={true}/>} />
                <Route path="/cliente" element={<Cliente apiUrl={apiUrl} />} />
                <Route path="/orden" element={<OrdenCompra apiUrl={apiUrl} />} />
            </Routes>
        </div>
      </div>
    </Router>
  )
}

export default RouterApp
