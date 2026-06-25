import { useState } from 'react'
import PropTypes from 'prop-types'
import './TamagochiSearchBar.css'

function TamagochiSearchBar({ search, onSearchChange }) {
  const [localSearch, setLocalSearch] = useState(search)

  const handleChange = (field, value) => {
    const newSearch = { ...localSearch, [field]: value }
    setLocalSearch(newSearch)
    onSearchChange(newSearch)
  }

  const handleClear = () => {
    const emptySearch = { name: '', species: '', color: '', birthDate: '' }
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
      <select
        value={localSearch.species}
        onChange={(e) => handleChange('species', e.target.value)}
        className="search-input"
      >
        <option value="">Все виды</option>
        <option value="Кошка">Кошка</option>
        <option value="Собака">Собака</option>
        <option value="Робот">Робот</option>
        <option value="Пришелец">Пришелец</option>
        <option value="Дракон">Дракон</option>
      </select>
      <input
        type="text"
        placeholder="Цвет"
        value={localSearch.color}
        onChange={(e) => handleChange('color', e.target.value)}
        className="search-input"
      />
      <input
        type="date"
        placeholder="Дата рождения"
        value={localSearch.birthDate}
        onChange={(e) => handleChange('birthDate', e.target.value)}
        className="search-input"
      />
      <button className="clear-button" onClick={handleClear}>
        Очистить
      </button>
    </div>
  )
}

TamagochiSearchBar.propTypes = {
  search: PropTypes.shape({
    name: PropTypes.string,
    species: PropTypes.string,
    color: PropTypes.string,
    birthDate: PropTypes.string,
  }).isRequired,
  onSearchChange: PropTypes.func.isRequired,
}

export default TamagochiSearchBar
