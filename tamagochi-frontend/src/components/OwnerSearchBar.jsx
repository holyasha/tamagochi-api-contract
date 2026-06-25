import { useState } from 'react'
import PropTypes from 'prop-types'

function OwnerSearchBar({ search, onSearchChange }) {
  const [localSearch, setLocalSearch] = useState(search)

  const handleChange = (field, value) => {
    const newSearch = { ...localSearch, [field]: value }
    setLocalSearch(newSearch)
    onSearchChange(newSearch)
  }

  const handleClear = () => {
    const emptySearch = { name: '', email: '', nickname: '', birthDate: '', tamagochisCount: '' }
    setLocalSearch(emptySearch)
    onSearchChange(emptySearch)
  }

  return (
    <div className="search-bar">
      <span className="filter-label">Поиск:</span>
      <input
        type="text"
        placeholder="Имя"
        value={localSearch.name}
        onChange={(e) => handleChange('name', e.target.value)}
        className="search-input"
      />
      <input
        type="text"
        placeholder="Игровой ник"
        value={localSearch.nickname}
        onChange={(e) => handleChange('nickname', e.target.value)}
        className="search-input"
      />
      <input
        type="text"
        placeholder="Email"
        value={localSearch.email}
        onChange={(e) => handleChange('email', e.target.value)}
        className="search-input"
      />
      <input
        type="date"
        placeholder="Дата рождения"
        value={localSearch.birthDate}
        onChange={(e) => handleChange('birthDate', e.target.value)}
        className="search-input"
      />
      <input
        type="number"
        placeholder="Кол-во питомцев"
        value={localSearch.tamagochisCount}
        onChange={(e) => handleChange('tamagochisCount', e.target.value)}
        className="search-input"
        min="0"
      />
      <button className="clear-button" onClick={handleClear}>
        Очистить
      </button>
    </div>
  )
}

OwnerSearchBar.propTypes = {
  search: PropTypes.shape({
    name: PropTypes.string,
    email: PropTypes.string,
    nickname: PropTypes.string,
    birthDate: PropTypes.string,
    tamagochisCount: PropTypes.string,
  }).isRequired,
  onSearchChange: PropTypes.func.isRequired,
}

export default OwnerSearchBar
