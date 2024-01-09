import React, { useState } from 'react';
import Swal from 'sweetalert2';

const InventarioAdd = ({urlApi, productos, setProductos, setIsAdding }) => {
    const [id, setId] = useState('');
    const [code, setCode] = useState('');
    const [name, setName] = useState('');
    const [price, setPrice] = useState('');
    const [properties, setProperties] = useState('');
     
    const handleAdd = e => {
        e.preventDefault();

        if (!code || !name || !properties) {
            return Swal.fire({
                icon: 'error',
                title: 'Error!',
                text: 'Todos los campos son requeridos.',
                showConfirmButton: true,
            });
        }

        const id = productos.length + 1;
        setId(id);

        const newProducto = {
            id,
            code,
            name,
            properties,
            price
        };
        
        productos.push(newProducto);    

        for (let i = 0; i < productos.length; i++) {
            if (productos[i].id === id) {
              productos.splice(i, 1, newProducto);
              break;
            }
          }

        setProductos(productos);
        addData(newProducto);
        setIsAdding(false);

        Swal.fire({
            icon: 'success',
            title: 'Agregado!',
            text: `La ${name}ha sido agregada.`,
            showConfirmButton: false,
            timer: 1500,
        });
    };

    const addData = async (producto) => {
        console.log(JSON.stringify(producto));

        try {   
            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(producto)
            };

            const response = await fetch(urlApi, requestOptions);
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
            <form onSubmit={handleAdd}>
                <h1>Agregar Producto</h1>
                
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
                    <input type="submit" value="Guardar" />
                    <input
                        style={{ marginLeft: '12px' }}
                        className="muted-button"
                        type="button"
                        value="Cancelar"
                        onClick={() => setIsAdding(false)}
                    />
                </div>
            </form>
        </div>
  );
};

export default InventarioAdd;
