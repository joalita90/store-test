import React, { useState, useEffect } from 'react';

const OrdenCompra = (apiUrl) => {

  const urlApi = apiUrl + 'api/order';

  const[clientes, setClientes]=useState([])
  const[products, setProducts]=useState([])
  const [order, setOrder] = useState({
    products: [],
    total: 0,
    client: '',
    date: ''
  });

  const [selectedClient, setSelectedClient] = useState('');
  const [selectedProduct, setSelectedProduct] = useState('');
  const [selectedProductId, setSelectedProductId] = useState('');
  const [selectedClientId, setSelectedClientId] = useState('')

  const [productOrder, setProductOrder] = useState([])
  const [clientOrder, setClientOrder] = useState('')
  
  const obtenerClientes = async () => {
    try {      
      console.log('http://localhost:8080/api/client');
        const response = await fetch('http://localhost:8080/api/client');        
        if (response.ok) {
            const data = await response.json();
            setClientes(data);
            console.log(data);
        } else {
            console.error('Error al obtener datos Clientes:', response.status);
        }
    } catch (error) {
        console.error('Error en la solicitud:', error);
    }
  };

  const obtenerProductos = async () => {
    try {      
        const response = await fetch('http://localhost:8080/api/product');        
        if (response.ok) {
            const data = await response.json();
            setProducts(data);
            console.log(data);
        } else {
            console.error('Error al obtener datos Clientes:', response.status);
        }
    } catch (error) {
        console.error('Error en la solicitud:', error);
    }
  };

  const handleSelectChange = (e) => {
    const clientId = e.target.value
    const productData = clientes.find((cl) => cl.id == clientId);
    setSelectedClient(e.target.value);
    setOrder({
        ...order,
        client: productData,
      });
      setClientOrder(productData);
      setSelectedClientId(clientId);
  };

  const handleProductSelectChange = (e) => {
    const productId = e.target.value;
    const productData = products.find((product) => product.id == productId);
    setSelectedProductId(e.target.value)
    setSelectedProduct(productData);
    setProductOrder((prevList) => [...prevList, productData]);
  }

  const addProductToOrder = (product) => {
    // Agregar un producto a la orden
    const price = product.selectedProduct.price;
    const updatedOrder = {
      ...order,
      products: [...order.products, product.selectedProduct],
      total: order.total + price,
    };
    setOrder(updatedOrder);
  };

  const handleSubmitOrder = () => {
    // Enviar la orden a tu API o realizar cualquier lógica necesaria
    
    setOrder({
      ...order,
      client: clientOrder,
    });

    addData(order);
    console.log('Orden enviada:', order);
    
    // Reiniciar el estado de la orden después de enviarla
    setOrder({
      products: [],
      total: 0,
      client: '',
      date: ''
    });
  };

  const addData = async (orderData) => {
    console.log(JSON.stringify(orderData));

    try {   
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(orderData)
        };

        const response = await fetch('http://localhost:8080/api/order', requestOptions);
        if (response.ok) {
            const dataNew = await response.json();
            
        } else {
            console.error('Error al guardar:', response.status);
        }
    } catch (error) {
        console.error('Error en la solicitud:', error);
    }
};

  useEffect(() => {
    obtenerClientes();
    obtenerProductos();
  }, []);

  return (
    <div>
      <h2>Orden de Compra</h2>
      <div>
        
        <label>
          Cliente:
          
          <label htmlFor="clientOption"></label>
            <select className='select' id="clientOption" value={selectedClientId} onChange={handleSelectChange}>
              <option value="" disabled>
                  Selecciona una opción
              </option>
              {clientes.map((option) => (
                  <option key={option.name} value={option.id}>
                    {option.name}
                  </option>
              ))}
            </select>
        </label>      
        
        <div>
          <label>
            Productos:            
            <label htmlFor="productOption"> </label>
              <select id="productOption" value={selectedProductId} onChange={handleProductSelectChange}>
                <option value="" disabled>
                    Selecciona una opción
                </option>
                {products.map((option) => (
                    <option key={option.name} value={option.id}>
                       {option.name}
                    </option>
                ))}
              </select>
          </label>    
        </div>

        <button onClick={() => addProductToOrder({ selectedProduct })}>
          Agregar Producto
        </button>
      </div>
      <div>
        <h3>Resumen de la Orden</h3>
        <ul>
          {order.products.map((product, index) => (
            <li key={index}>{product.name} - ${product.price}</li>
          ))}
        </ul>
        <p>Total: ${order.total}</p>
      </div>
      <button onClick={handleSubmitOrder}>Enviar Orden</button>
    </div>
  );
};

export default OrdenCompra;
