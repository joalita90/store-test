import React, { useState } from 'react';
import Swal from 'sweetalert2';

const ClienteEdit = ({ clientes, selectedCliente, setClientes, setIsEditing }) => {
  const id = selectedCliente.id;

    const [name, setName] = useState(selectedCliente.name);

  const handleUpdate = e => {
    e.preventDefault();

    if (!name) {
        return Swal.fire({
            icon: 'error',
            title: 'Error!',
            text: 'Todos los campos son requeridos.',
            showConfirmButton: true,
        });
    }

    const cliente = {
      id,
      name
    };

    for (let i = 0; i < clientes.length; i++) {
      if (clientes[i].id === id) {
        clientes.splice(i, 1, cliente);
        break;
      }
    }

    setClientes(clientes);
    setIsEditing(false);

    Swal.fire({
      icon: 'success',
      title: 'Actualizado!',
      text: `Actualización Exitosa.`,
      showConfirmButton: false,
      timer: 1500,
    });
  };

  return (
    <div className="small-container">
      <form onSubmit={handleUpdate}>
        <h1>Editar</h1>
        
        <label htmlFor="name">Nombre</label>
        <input
            id="name"
            type="text"
            name="name"
            value={name}
            onChange={e => setName(e.target.value)}
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

export default ClienteEdit;
