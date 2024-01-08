import React from 'react';

const EmpresaTable = ({ empresas, handleEdit, handleDelete }) => {
  /*empresas.forEach((empresa, i) => {
    empresa.id = i + 1;
  });*/

  return (
    <div className="contain-table">
      <table className="striped-table">
        <thead>
          <tr>
            <th>No.</th>
            <th>Nit</th>
            <th>Nombre</th>
            <th>Dirección</th>
            <th>Teléfono</th>
            
            <th colSpan={2} className="text-center">
              Actions
            </th>
          </tr>
        </thead>
        <tbody>
          {empresas.length > 0 ? (
            empresas.map((empresa, i) => (
              <tr key={empresa.id}>
                <td>{i + 1}</td>
                <td>{empresa.nit}</td>
                <td>{empresa.name}</td>
                <td>{empresa.address}</td>                
                <td>{empresa.phone} </td>

                <td className="text-right">
                  <button
                    onClick={() => handleEdit(empresa.id)}
                    className="button muted-button"
                  >
                    Editar
                  </button>
                </td>
                <td className="text-left">
                  <button
                    onClick={() => handleDelete(empresa.id)}
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

export default EmpresaTable;
