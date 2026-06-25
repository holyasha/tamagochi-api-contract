const API_BASE = '/api'

export async function fetchOwners(isActive = null, search = {}) {
  const params = new URLSearchParams({ page: 0, size: 100 })
  if (isActive !== null) params.append('isActive', isActive)

  const hasSearch = search.name || search.email || search.nickname || search.birthDate || search.tamagochisCount
  if (hasSearch) {
    if (search.name) params.append('name', search.name)
    if (search.email) params.append('email', search.email)
    if (search.nickname) params.append('nickname', search.nickname)
    if (search.birthDate) params.append('birthDate', search.birthDate)
    if (search.tamagochisCount) params.append('tamagochisCount', search.tamagochisCount)
  }

  const endpoint = hasSearch ? 'search' : ''
  const response = await fetch(`${API_BASE}/owners${endpoint ? '/' + endpoint : ''}?${params}`)

  if (!response.ok) {
    throw new Error('Не удалось загрузить владельцев')
  }

  const data = await response.json()
  return data._embedded?.owners || []
}

export async function createOwner(owner) {
  const response = await fetch(`${API_BASE}/owners`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(owner)
  })

  if (!response.ok) {
    throw new Error('Не удалось создать владельца')
  }

  return response.json()
}

export async function updateOwner(id, owner) {
  const response = await fetch(`${API_BASE}/owners/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(owner)
  })

  if (!response.ok) {
    throw new Error('Не удалось обновить владельца')
  }

  return response.json()
}

export async function toggleOwnerStatus(id, isActive) {
  const response = await fetch(`${API_BASE}/owners/${id}`, {
    method: 'PATCH',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ isActive: !isActive })
  })

  if (!response.ok) {
    throw new Error('Не удалось изменить статус владельца')
  }

  return response.json()
}

export async function deleteOwner(id) {
  const response = await fetch(`${API_BASE}/owners/${id}`, {
    method: 'DELETE'
  })

  if (!response.ok) {
    throw new Error('Не удалось удалить владельца')
  }
}
