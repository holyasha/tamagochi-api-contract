import { useCallback, useEffect, useState } from 'react'
import {
  fetchOwners,
  createOwner,
  updateOwner,
  toggleOwnerStatus as toggleOwnerStatusApi,
  deleteOwner
} from '../services/ownerApi'

export function useOwners(onOwnerDeleted) {
  const [owners, setOwners] = useState([])
  const [isLoading, setIsLoading] = useState(true)
  const [error, setError] = useState('')
  const [filter, setFilter] = useState(null)
  const [search, setSearch] = useState({ name: '', email: '', nickname: '', birthDate: '', tamagochisCount: '' })

  const loadOwners = useCallback(async () => {
    setIsLoading(true)
    setError('')
    try {
      const data = await fetchOwners(filter, search)
      setOwners(data)
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
        const data = await fetchOwners(filter, search)
        if (isMounted) {
          setOwners(data)
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

  const handleCreate = useCallback(async (owner) => {
    try {
      await createOwner(owner)
      await loadOwners()
      return true
    } catch (err) {
      setError(err.message)
      return false
    }
  }, [loadOwners])

  const handleUpdate = useCallback(async (id, owner) => {
    try {
      await updateOwner(id, owner)
      await loadOwners()
      return true
    } catch (err) {
      setError(err.message)
      return false
    }
  }, [loadOwners])

  const handleToggleStatus = useCallback(async (id, isActive) => {
    try {
      await toggleOwnerStatusApi(id, isActive)
      await loadOwners()
    } catch (err) {
      setError(err.message)
    }
  }, [loadOwners])

  const handleDelete = useCallback(async (id) => {
    if (!window.confirm('Удалить владельца и всех его питомцев?')) return
    try {
      await deleteOwner(id)
      await loadOwners()
      // Уведомляем другие контексты об удалении
      if (onOwnerDeleted) {
        onOwnerDeleted(id)
      }
    } catch (err) {
      setError(err.message)
    }
  }, [loadOwners, onOwnerDeleted])

  const clearError = useCallback(() => {
    setError('')
  }, [])

  return {
    owners,
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
    clearError
  }
}
