import React, { useState, useEffect } from 'react';
import Swal from 'sweetalert2';

import ClienteTable from './ClienteTable';
import ClienteAdd from './ClienteAdd';
import ClienteEdit from './ClienteEdit';

const Inventario = ({apiUrl, setIsAuthenticated }) => {
    const [clientes, setClientes] = useState([]);
    const [selectedCliente, setSelectedCliente] = useState(null);
    const [isAdding, setIsAdding] = useState(false);
    const [isEditing, setIsEditing] = useState(false);
    
    const urlApi = apiUrl + 'api/client';
  
    const obtenerData = async () => {
      try {        
          const response = await fetch(urlApi);        
          if (response.ok) {
              const data = await response.json();
              setClientes(data);
          } else {
              console.error('Error al obtener datos:', response.status);
          }
      } catch (error) {
          console.error('Error en la solicitud:', error);
      }
    };
  
    const handleEdit = id => {
      const [cliente] = clientes.filter(clientes => clientes.id === id);
  
      setSelectedCliente(cliente);
      setIsEditing(true);
    };
  
    const handleDelete = id => {
      Swal.fire({
        icon: 'warning',
        title: 'Estas seguro de Eliminar?',
        text: "Esta operación no se puede revertir.!",
        showCancelButton: true,
        confirmButtonText: 'Si, Eliminar!',
        cancelButtonText: 'No, cancelar!',
      }).then(result => {
  
        if (result.value) {
          const [cliente] = clientes.filter(cliente => cliente.id === id);
          deleteData(id);
  
          Swal.fire({
            icon: 'success',
            title: 'Eliminada!',
            text: `Eliminacion Correcta`,
            showConfirmButton: false,
            timer: 1500,
          });
        }
  
      });
    };
  
    const deleteData = async (id) => {
      try {   
          const requestOptions = {
            method: 'DELETE'
          };
  
          const response = await fetch(urlApi + '/' + id, requestOptions);
          if (response.ok) {
              obtenerData();
          } else {
              console.error('Error al eliminar:', response.status);
          }
      } catch (error) {
          console.error('Error en la solicitud:', error);
      }
    };
  
    useEffect(() => {
      obtenerData();
    }, []);
  
    
    return (    
      <div className="container">
        <header>        
            <button onClick={() => setIsAdding(true)}>Agregar</button>        
        </header>
  
        {!isAdding && !isEditing && (
          <>
            <ClienteTable
              clientes={clientes}
              handleEdit={handleEdit}
              handleDelete={handleDelete}
            />
          </>
        )}
        {isAdding && (
          <ClienteAdd
            urlApi={urlApi}            
            clientes={clientes}
            setClientes={setClientes}
            setIsAdding={setIsAdding}
          />
        )}
        {isEditing && (
          <ClienteEdit
            clientes={clientes}
            selectedCliente={selectedCliente}
            setClientes={setClientes}
            setIsEditing={setIsEditing}
          />
        )}
      </div>
    );
  };
  

export default Inventario;
