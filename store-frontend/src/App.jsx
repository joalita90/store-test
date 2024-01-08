import React from "react";
import { StoreProvider } from "./context/storeContext";
import RouterApp from "./router/RouterApp";
import NavBar from "./components/NavBar";
import "./index.css";

const App = () => { 
  return (
    <div>    
     
      <span>texto</span>

      <StoreProvider>
        <RouterApp/> 
      </StoreProvider> 
    </div>
    
  );
};

export default App;