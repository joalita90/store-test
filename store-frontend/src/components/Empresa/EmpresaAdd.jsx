import React, { useState } from 'react';
import Swal from 'sweetalert2';

const EmpresaAdd = ({urlApi, loading, empresas, setEmpresas, setIsAdding }) => {
    const [id, setId] = useState('');
    const [nit, setNit] = useState('');
    const [name, setName] = useState('');
    const [address, setAddress] = useState('');
    const [phone, setPhone] = useState('');
  
    const handleAdd = e => {
        e.preventDefault();

        if (!nit || !name || !address || !phone) {
            return Swal.fire({
                icon: 'error',
                title: 'Error!',
                text: 'Todos los campos son requeridos.',
                showConfirmButton: true,
            });
        }

        const id = empresas.length + 1;
        setId(id);

        const newEmpresa = {
            id,
            nit,
            name,
            address,
            phone
        };
        
        empresas.push(newEmpresa);    
        setEmpresas(empresas);
        addData(newEmpresa);
        setIsAdding(false);

        console.log(empresas);

        Swal.fire({
        icon: 'success',
        title: 'Agregado!',
        text: `La ${name}ha sido agregada.`,
        showConfirmButton: false,
        timer: 1500,
        });
    };

    const addData = async (empresa) => {
        console.log(JSON.stringify(empresa));

        try {   
            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(empresa)
            };

            const response = await fetch(urlApi, requestOptions);
            if (response.ok) {
                const dataNew = await response.json();
                setEmpresas(dataNew);
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
                <h1>Agregar Empresa</h1>
                <label htmlFor="name">Nombre</label>
                <input
                id="name"
                type="text"
                name="name"
                value={name}
                onChange={e => setName(e.target.value)}
                />
                <label htmlFor="nit">Nit</label>
                <input
                id="nit"
                type="text"
                name="nit"
                value={nit}
                onChange={e => setNit(e.target.value)}
                />
                <label htmlFor="address">Dirección</label>
                <input
                id="address"
                type="text"
                name="address"
                value={address}
                onChange={e => setAddress(e.target.value)}
                />
                <label htmlFor="phone">Teléfono</label>
                <input
                id="phone"
                type="text"
                name="phone"
                value={phone}
                onChange={e => setPhone(e.target.value)}
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

export default EmpresaAdd;
