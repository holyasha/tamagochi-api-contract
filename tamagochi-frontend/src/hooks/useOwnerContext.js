import { useContext } from 'react'
import { OwnerContext } from '../context/OwnerContext'

export function useOwnerContext() {
  const context = useContext(OwnerContext)
  if (!context) {
    throw new Error('useOwnerContext must be used within OwnerContextProvider')
  }
  return context
}
