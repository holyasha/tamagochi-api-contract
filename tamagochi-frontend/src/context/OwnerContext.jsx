import PropTypes from 'prop-types'
import { createContext } from 'react'
import { useOwners } from '../hooks/useOwners'
import { useTamagochiContext } from '../hooks/useTamagochiContext'

const OwnerContext = createContext(null)

export function OwnerContextProvider({ children }) {
  // Получаем функцию reload из TamagochiContext
  let tamagochiReload = null
  try {
    const tamagochiContext = useTamagochiContext()
    tamagochiReload = tamagochiContext.reload
  } catch {
    // TamagochiContext еще не инициализирован, это нормально при первом рендере
  }

  const ownerState = useOwners(tamagochiReload)

  return (
    <OwnerContext.Provider value={ownerState}>
      {children}
    </OwnerContext.Provider>
  )
}

OwnerContextProvider.propTypes = {
  children: PropTypes.node.isRequired,
}

export { OwnerContext }
