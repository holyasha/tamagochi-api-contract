import { useContext } from 'react'
import { TamagochiContext } from '../context/TamagochiContext'

export function useTamagochiContext() {
  const context = useContext(TamagochiContext)
  if (!context) {
    throw new Error('useTamagochiContext must be used within TamagochiContextProvider')
  }
  return context
}
