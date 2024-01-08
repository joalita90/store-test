import React, { useState, useEffect } from 'react';

const Inventario = () => {
    const [productos, setProductos] = useState([]);

    useEffect(() => {
        const obtenerProductosDesdeAPI = async () => {
            try {
                // Realiza la solicitud a tu API de productos
                const response = await fetch('http://localhost:8080/api/product');
                
                // Verifica si la solicitud fue exitosa (código de estado 200)
                if (response.ok) {
                    const data = await response.json();
                    setProductos(data);
                } else {
                    console.error('Error al obtener productos:', response.status);
                }
            } catch (error) {
                console.error('Error en la solicitud:', error);
            }
        };

        obtenerProductosDesdeAPI();
    }, []);

    return (
        <div>
            <h2>Inventario de Productos</h2>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Características</th>
                        {/* Agrega más encabezados según sea necesario */}
                    </tr>
                </thead>
                <tbody>
                    {productos.map((producto) => (
                        <tr key={producto.id}>
                            <td>{producto.id}</td>
                            <td>{producto.code}</td>
                            <td>{producto.name}</td>
                            <td>{producto.properties}</td>
                            {/* Agrega más celdas según sea necesario */}
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default Inventario;
