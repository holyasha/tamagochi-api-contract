const API_BASE = '/api'

export async function fetchTamagochis(isActive = null, search = {}) {
  const params = new URLSearchParams({ page: 0, size: 100 })
  if (isActive !== null) params.append('isActive', isActive)

  const hasSearch = search.name || search.species || search.color || search.birthDate
  if (hasSearch) {
    if (search.name) params.append('name', search.name)
    if (search.species) params.append('species', search.species)
    if (search.color) params.append('color', search.color)
    if (search.birthDate) params.append('birthDate', search.birthDate)
  }

  const endpoint = hasSearch ? 'search' : ''
  const response = await fetch(`${API_BASE}/tamagochis${endpoint ? '/' + endpoint : ''}?${params}`)

  if (!response.ok) {
    throw new Error('Не удалось загрузить питомцев')
  }

  const data = await response.json()
  return data._embedded?.tamagochis || []
}

export async function createTamagochi(tamagochi) {
  const response = await fetch(`${API_BASE}/tamagochis`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(tamagochi)
  })

  if (!response.ok) {
    throw new Error('Не удалось создать питомца')
  }

  return response.json()
}

export async function updateTamagochi(id, tamagochi) {
  const response = await fetch(`${API_BASE}/tamagochis/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(tamagochi)
  })

  if (!response.ok) {
    throw new Error('Не удалось обновить питомца')
  }

  return response.json()
}

export async function toggleTamagochiStatus(id, isActive) {
  const response = await fetch(`${API_BASE}/tamagochis/${id}`, {
    method: 'PATCH',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ isActive: !isActive })
  })

  if (!response.ok) {
    throw new Error('Не удалось изменить статус питомца')
  }

  return response.json()
}

export async function deleteTamagochi(id) {
  const response = await fetch(`${API_BASE}/tamagochis/${id}`, {
    method: 'DELETE'
  })

  if (!response.ok) {
    throw new Error('Не удалось удалить питомца')
  }
}
