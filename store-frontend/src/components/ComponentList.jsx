import React, { useState } from 'react';

const ComponentList = (objectDataList, selectedObject) => {
  // Estado para mantener el cliente seleccionado
  const [selectedObject, setSelectedObject] = useState(null);

  // Función para manejar la selección de un cliente
  const handleClientSelection = (client) => {
    setSelectedObject(client);
  };

  return (
    <div>
      <ul>
        {objectDataList.map((data) => (
          <li key={objectDataList.id} onClick={() => handleClientSelection(data)}>
            {objectDataList.name}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ComponentList;
