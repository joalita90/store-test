import React, { useState, useEffect } from "react";
import { getItemsCollection, getItemsCollectionById } from '../helpers/items'
import { Spinner } from 'react-bootstrap';
import ItemList from './ItemList';
import { useParams } from 'react-router-dom';


const ItemListContainer = () => {

    const [prod, setProd] = useState([]);
    const [load, setLoad] = useState(true);//para el <Spinner/>

    const { id } = useParams();

    console.log("items: ", prod);

    useEffect(() => {

        if (id) {
            getItemsCollectionById(id, setProd, setLoad);
        } else {
            getItemsCollection(setProd, setLoad);
        }

    }, [id])

    return (
        <div style={divStyle}>
            {load && <Spinner animation="border" role="status" />}
            <ItemList listProduct={prod} />
        </div>
    )
}

const divStyle = {
    margin: 0
};

export default ItemListContainer;