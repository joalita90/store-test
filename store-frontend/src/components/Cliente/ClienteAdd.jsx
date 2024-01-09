import React, { useState } from 'react';
import Swal from 'sweetalert2';

const InventarioAdd = ({urlApi, clientes, setClientes, setIsAdding }) => {
    const [id, setId] = useState('');
    const [name, setName] = useState('');
     
    const handleAdd = e => {
        e.preventDefault();

        if (!name ) {
            return Swal.fire({
                icon: 'error',
                title: 'Error!',
                text: 'Todos los campos son requeridos.',
                showConfirmButton: true,
            });
        }

        const id = clientes.length + 1;
        setId(id);

        const newCliente = {
            id,
            name
        };
        
        clientes.push(newCliente);    
        setClientes(clientes);
        addData(newCliente);
        setIsAdding(false);

        Swal.fire({
            icon: 'success',
            title: 'Agregado!',
            text: `Creación exitosa.`,
            showConfirmButton: false,
            timer: 1500,
        });
    };

    const addData = async (cliente) => {
        console.log(JSON.stringify(cliente));

        try {   
            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(cliente)
            };

            const response = await fetch(urlApi, requestOptions);
            if (response.ok) {
                const dataNew = await response.json();
                setClientes(dataNew);
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
                <h1>Agregar</h1>
                
                <label htmlFor="name">Nombre</label>
                <input
                    id="name"
                    type="text"
                    name="name"
                    value={name}
                    onChange={e => setName(e.target.value)}
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
