import React, { useState, useEffect } from 'react';
import Swal from 'sweetalert2';

import EmpresaTable from './EmpresaTable';
import EmpresaAdd from './EmpresaAdd';
import EmpresaEdit from './EmpresaEdit';

const Empresa = ({apiUrl, setIsAuthenticated }) => {
  const [empresas, setEmpresas] = useState([]);
  const [selectedEmpresa, setSelectedEmpresa] = useState(null);
  const [isAdding, setIsAdding] = useState(false);
  const [isEditing, setIsEditing] = useState(false);

  const urlApi = apiUrl + 'api/companies';

  const obtenerData = async () => {
    try {        
        const response = await fetch(urlApi);        
        if (response.ok) {
            const data = await response.json();
            setEmpresas(data);
        } else {
            console.error('Error al obtener datos:', response.status);
        }
    } catch (error) {
        console.error('Error en la solicitud:', error);
    }
  };

  const handleEdit = id => {
    const [empresa] = empresas.filter(empresa => empresa.id === id);

    setSelectedEmpresa(empresa);
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
        const [empresa] = empresas.filter(empresa => empresa.id === id);
        deleteData(id);

        Swal.fire({
          icon: 'success',
          title: 'Eliminada!',
          text: `La ${empresa.name}' ha sido eliminada.`,
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
          <button onClick={() => setIsAdding(true)}>Agregar Empresa</button>        
      </header>

      {!isAdding && !isEditing && (
        <>
          <EmpresaTable
            empresas={empresas}
            handleEdit={handleEdit}
            handleDelete={handleDelete}
          />
        </>
      )}
      {isAdding && (
        <EmpresaAdd
          urlApi={urlApi}
          loading={obtenerData}
          empresas={empresas}
          setEmpresas={setEmpresas}
          setIsAdding={setIsAdding}
        />
      )}
      {isEditing && (
        <EmpresaEdit
          empresas={empresas}
          selectedEmpresa={selectedEmpresa}
          setEmpresas={setEmpresas}
          setIsEditing={setIsEditing}
        />
      )}
    </div>
  );
};

export default Empresa;
