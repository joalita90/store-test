import { createContext } from 'react'
import useLocalStorage from '../hooks/useLocalStorage';

export const StoreContext = createContext({})

export const StoreProvider = ({ children }) => {
    const [items, setItems] = useLocalStorage([], "items");

  return (
    <StoreContext.Provider>
      {children}
    </StoreContext.Provider>
  )
}
