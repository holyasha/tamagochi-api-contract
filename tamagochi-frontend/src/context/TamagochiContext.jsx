import PropTypes from 'prop-types'
import { createContext } from 'react'
import { useTamagochis } from '../hooks/useTamagochis'

const TamagochiContext = createContext(null)

export function TamagochiContextProvider({ children }) {
  const tamagochiState = useTamagochis()

  return (
    <TamagochiContext.Provider value={tamagochiState}>
      {children}
    </TamagochiContext.Provider>
  )
}

TamagochiContextProvider.propTypes = {
  children: PropTypes.node.isRequired,
}

export { TamagochiContext }
