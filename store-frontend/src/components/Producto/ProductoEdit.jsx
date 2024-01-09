import React, { useState } from 'react';
import Swal from 'sweetalert2';

const ProductoEdit = ({urlApi, productos, selectedProducto, setProductos, setIsEditing }) => {
    const id = selectedProducto.id;
    const [code, setCode] = useState(selectedProducto.code);
    const [name, setName] = useState(selectedProducto.name);
    const [properties, setProperties] = useState(selectedProducto.properties);
    const [price, setPrice] = useState(selectedProducto.price);

  const handleUpdate = e => {
    e.preventDefault();

    if (!code || !name || !properties || !price) {
        return Swal.fire({
            icon: 'error',
            title: 'Error!',
            text: 'Todos los campos son requeridos.',
            showConfirmButton: true,
        });
    }

    const producto = {
      id,
      code,
      name,
      properties,
      price
    };

    for (let i = 0; i < productos.length; i++) {
      if (productos[i].id === id) {
        productos.splice(i, 1, producto);
        break;
      }
    }

    //localStorage.setItem('empresa_data', JSON.stringify(empresas));
    setProductos(productos);
    setIsEditing(false);
    updateData(producto);

    Swal.fire({
      icon: 'success',
      title: 'Actualizado!',
      text: `Actualización Exitosa.`,
      showConfirmButton: false,
      timer: 1500,
    });
  };

  const updateData = async (producto) => {
    console.log(JSON.stringify(producto));

    try {   
        const requestOptions = {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(producto)
        };

        const response = await fetch(urlApi + '/' + id, requestOptions);
        if (response.ok) {
            const dataNew = await response.json();
            setProductos(dataNew);
        } else {
            console.error('Error al guardar:', response.status);
        }
    } catch (error) {
        console.error('Error en la solicitud:', error);
    }
};

  return (
    <div className="small-container">
      <form onSubmit={handleUpdate}>
        <h1>Editar</h1>
        
        <label htmlFor="code">Código</label>
                <input
                    id="code"
                    type="text"
                    name="code"
                    value={code}
                    onChange={e => setCode(e.target.value)}
                />

                <label htmlFor="name">Nombre</label>
                <input
                    id="name"
                    type="text"
                    name="name"
                    value={name}
                    onChange={e => setName(e.target.value)}
                />
                
                <label htmlFor="address">Caracteristicas</label>
                <input
                    id="properties"
                    type="text"
                    name="properties"
                    value={properties}
                    onChange={e => setProperties(e.target.value)}
                />

                
                <label htmlFor="price">Precio</label>
                <input
                    id="price"
                    type="number"
                    name="price"
                    value={price}
                    onChange={e => setPrice(e.target.value)}
                />

        <div style={{ marginTop: '30px' }}>
          <input type="submit" value="Actualizar" />
          <input
            style={{ marginLeft: '12px' }}
            className="muted-button"
            type="button"
            value="Cancelar"
            onClick={() => setIsEditing(false)}
          />
        </div>
      </form>
    </div>
  );
};

export default ProductoEdit;
