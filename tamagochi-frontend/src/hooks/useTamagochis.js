import { useCallback, useEffect, useState } from 'react'
import {
  fetchTamagochis,
  createTamagochi,
  updateTamagochi,
  toggleTamagochiStatus as toggleTamagochiStatusApi,
  deleteTamagochi
} from '../services/tamagochiApi'

export function useTamagochis() {
  const [tamagochis, setTamagochis] = useState([])
  const [isLoading, setIsLoading] = useState(true)
  const [error, setError] = useState('')
  const [filter, setFilter] = useState(null)
  const [search, setSearch] = useState({ name: '', species: '', color: '', birthDate: '' })

  const loadTamagochis = useCallback(async () => {
    setIsLoading(true)
    setError('')
    try {
      const data = await fetchTamagochis(filter, search)
      setTamagochis(data)
    } catch (err) {
      setError(err.message)
    } finally {
      setIsLoading(false)
    }
  }, [filter, search])

  useEffect(() => {
    let isMounted = true

    async function load() {
      setIsLoading(true)
      setError('')
      try {
        const data = await fetchTamagochis(filter, search)
        if (isMounted) {
          setTamagochis(data)
        }
      } catch (err) {
        if (isMounted) {
          setError(err.message)
        }
      } finally {
        if (isMounted) {
          setIsLoading(false)
        }
      }
    }

    load()

    return () => {
      isMounted = false
    }
  }, [filter, search])

  const handleCreate = useCallback(async (tamagochi) => {
    try {
      await createTamagochi(tamagochi)
      await loadTamagochis()
      return true
    } catch (err) {
      setError(err.message)
      return false
    }
  }, [loadTamagochis])

  const handleUpdate = useCallback(async (id, tamagochi) => {
    try {
      await updateTamagochi(id, tamagochi)
      await loadTamagochis()
      return true
    } catch (err) {
      setError(err.message)
      return false
    }
  }, [loadTamagochis])

  const handleToggleStatus = useCallback(async (id, isActive) => {
    try {
      await toggleTamagochiStatusApi(id, isActive)
      await loadTamagochis()
    } catch (err) {
      setError(err.message)
    }
  }, [loadTamagochis])

  const handleDelete = useCallback(async (id) => {
    if (!window.confirm('Удалить питомца?')) return
    try {
      await deleteTamagochi(id)
      await loadTamagochis()
    } catch (err) {
      setError(err.message)
    }
  }, [loadTamagochis])

  const clearError = useCallback(() => {
    setError('')
  }, [])

  // Публичный метод для принудительной перезагрузки
  const reload = useCallback(() => {
    loadTamagochis()
  }, [loadTamagochis])

  return {
    tamagochis,
    isLoading,
    error,
    filter,
    search,
    setFilter,
    setSearch,
    handleCreate,
    handleUpdate,
    handleToggleStatus,
    handleDelete,
    clearError,
    reload
  }
}
