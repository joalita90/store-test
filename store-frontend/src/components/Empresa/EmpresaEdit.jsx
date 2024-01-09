import React, { useState } from 'react';
import Swal from 'sweetalert2';

const EmpresaEdit = ({ empresas, selectedEmpresa, setEmpresas, setIsEditing }) => {
  const id = selectedEmpresa.id;

  const [nit, setNit] = useState(selectedEmpresa.nit);
  const [name, setName] = useState(selectedEmpresa.name);
  const [address, setAddress] = useState(selectedEmpresa.address);
  const [phone, setPhone] = useState(selectedEmpresa.phone);

  const handleUpdate = e => {
    e.preventDefault();

    if (!nit || !name || !address || !phone) {
      return Swal.fire({
        icon: 'error',
        title: 'Error!',
        text: 'Todos los campos son requerido',
        showConfirmButton: true,
      });
    }

    const empresa = {
      id,
      nit,
      name,
      address,
      phone,
    };

    for (let i = 0; i < empresas.length; i++) {
      if (empresas[i].id === id) {
        empresas.splice(i, 1, empresa);
        break;
      }
    }

    localStorage.setItem('empresa_data', JSON.stringify(empresas));
    setEmpresas(empresas);
    setIsEditing(false);

    Swal.fire({
      icon: 'success',
      title: 'Actualizado!',
      text: `La ${name} ha sido actualizada.`,
      showConfirmButton: false,
      timer: 1500,
    });
  };

  return (
    <div className="small-container">
      <form onSubmit={handleUpdate}>
        <h1>Editar Empresa</h1>
        <label htmlFor="nit">Nit</label>
        <input
          id="nit"
          type="text"
          name="nit"
          value={nit}
          onChange={e => setNit(e.target.value)}
        />
        <label htmlFor="name">Last Name</label>
        <input
          id="name"
          type="text"
          name="name"
          value={name}
          onChange={e => setName(e.target.value)}
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
          type="number"
          name="phone"
          value={phone}
          onChange={e => setPhone(e.target.value)}
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

export default EmpresaEdit;
