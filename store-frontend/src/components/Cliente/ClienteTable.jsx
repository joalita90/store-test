import React from 'react';

const ClienteTable = ({ clientes, handleEdit, handleDelete }) => {

  return (
    <div className="contain-table">
      <table className="striped-table">
        <thead>
          <tr>
            <th>No.</th>
            <th>Nombre</th>

            <th colSpan={2} className="text-center">
              Actions
            </th>
          </tr>
        </thead>
        <tbody>
          {clientes.length > 0 ? (
            clientes.map((data, i) => (
              <tr key={data.id}>
                <td>{i + 1}</td>
                
                <td>{data.name}</td>
                              
                <td className="text-right">
                  <button
                    onClick={() => handleEdit(data.id)}
                    className="button muted-button"
                  >
                    Editar
                  </button>
                </td>
                <td className="text-left">
                  <button
                    onClick={() => handleDelete(data.id)}
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

export default ClienteTable;
