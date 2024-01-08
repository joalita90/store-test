import React from 'react'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import NavBar from '../components/NavBar'
import Inventario from '../components/Inventario'
import Empresa from '../components/Empresa/Empresa';


const RouterApp = () => {
  return (
    <Router>
      <div>
        <NavBar />
        <div className="container">
            <Routes>
                <Route path="/inventario" element={<Inventario />} />
                <Route path="/empresa" element={<Empresa setIsAuthenticated={true}/>} />
            </Routes>
        </div>
      </div>
    </Router>
  )
}

export default RouterApp
