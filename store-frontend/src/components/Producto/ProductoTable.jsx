import React from 'react';

const ProductoTable = ({ productos, handleEdit, handleDelete }) => {

  return (
    <div className="contain-table">
      <table className="striped-table">
        <thead>
          <tr>
            <th>No.</th>
            <th>Código</th>
            <th>Nombre</th>
            <th>Caracteristicas</th>
            <th>Precio</th>
            
            <th colSpan={2} className="text-center">
              Actions
            </th>
          </tr>
        </thead>
        <tbody>
          {productos.length > 0 ? (
            productos.map((producto, i) => (
              <tr key={producto.id}>
                <td>{i + 1}</td>
                <td>{producto.code}</td>
                <td>{producto.name}</td>
                <td>{producto.properties}</td>
                <td>$ {producto.price}</td>

                <td className="text-right">
                  <button
                    onClick={() => handleEdit(producto.id)}
                    className="button muted-button"
                  >
                    Editar
                  </button>
                </td>
                <td className="text-left">
                  <button
                    onClick={() => handleDelete(producto.id)}
                    className="button muted-button"
                  >
                    Eliminar
                  </button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan={7}>No data</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default ProductoTable;
