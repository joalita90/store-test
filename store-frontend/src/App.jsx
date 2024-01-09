import React from "react";
import { StoreProvider } from "./context/storeContext";
import RouterApp from "./router/RouterApp";
import NavBar from "./components/NavBar";
import "./index.css";

const App = () => { 
  return (
    <div>
      <StoreProvider>
        <RouterApp/> 
      </StoreProvider> 
    </div>    
  );
};

export default App;