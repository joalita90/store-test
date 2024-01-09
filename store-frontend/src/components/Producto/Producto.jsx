import React, { useState, useEffect } from 'react';
import Swal from 'sweetalert2';

import ProductoTable from './ProductoTable';
import ProductoAdd from './ProductoAdd';
import ProductoEdit from './ProductoEdit';

const Producto = ({apiUrl, setIsAuthenticated }) => {
    const [productos, setProductos] = useState([]);
    const [selectedProducto, setSelectedProducto] = useState(null);
    const [isAdding, setIsAdding] = useState(false);
    const [isEditing, setIsEditing] = useState(false);
    const [empresaId, setEmpresaId] = useState([]);

    const urlApi = apiUrl + 'api/product';
  
    const obtenerData = async () => {
      try {        
          const response = await fetch(urlApi);        
          if (response.ok) {
              const data = await response.json();
              setProductos(data);
          } else {
              console.error('Error al obtener datos:', response.status);
          }
      } catch (error) {
          console.error('Error en la solicitud:', error);
      }
    };
  
    const handleEdit = id => {
      const [producto] = productos.filter(producto => producto.id === id);
  
      setSelectedProducto(producto);
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
          const [producto] = productos.filter(producto => producto.id === id);
          deleteData(id);
  
          Swal.fire({
            icon: 'success',
            title: 'Eliminada!',
            text: `El producto ${producto.code}' ha sido eliminado.`,
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
            <button onClick={() => setIsAdding(true)}>Agregar Producto</button>        
        </header>
  
        {!isAdding && !isEditing && (
          <>
            <ProductoTable
              productos={productos}
              handleEdit={handleEdit}
              handleDelete={handleDelete}
            />
          </>
        )}
        {isAdding && (
          <ProductoAdd
            urlApi={urlApi}            
            productos={productos}
            setProductos={setProductos}
            setIsAdding={setIsAdding}
          />
        )}
        {isEditing && (
          <ProductoEdit
            urlApi={urlApi}
            productos={productos}
            selectedProducto={selectedProducto}
            setProductos={setProductos}
            setIsEditing={setIsEditing}
          />
        )}
      </div>
    );
  };
  

export default Producto;
