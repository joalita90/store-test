import React, { useState } from 'react';

const NuevoProducto = ({ onAgregarProducto }) => {
  const [nombre, setNombre] = useState('');
  const [caracteristicas, setCaracteristicas] = useState('');
  const [precio, setPrecio] = useState('');

  const handleAgregarProducto = () => {
    // Validar y realizar acciones adicionales si es necesario

    const nuevoProducto = {
      id: Math.random(), // Puedes generar un ID más robusto en un entorno real
      nombre,
      caracteristicas,
      precio,
    };

    onAgregarProducto(nuevoProducto);

    // Limpiar campos después de agregar
    setNombre('');
    setCaracteristicas('');
    setPrecio('');
  };

  return (
    <div>
      <h2>Agregar Nuevo Producto</h2>
      <label>
        Nombre:
        <input type="text" value={nombre} onChange={(e) => setNombre(e.target.value)} />
      </label>
      <br />
      <label>
        Características:
        <input type="text" value={caracteristicas} onChange={(e) => setCaracteristicas(e.target.value)} />
      </label>
      <br />
      <label>
        Precio:
        <input type="text" value={precio} onChange={(e) => setPrecio(e.target.value)} />
      </label>
      <br />
      <button onClick={handleAgregarProducto}>Agregar Producto</button>
    </div>
  );
};

export default NuevoProducto;
