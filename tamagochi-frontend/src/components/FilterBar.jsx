import PropTypes from 'prop-types'
import './FilterBar.css'

function FilterBar({ filter, onFilterChange }) {
  return (
    <div className="filter-group">
      <span className="filter-label">Фильтр:</span>
      <button
        className={`filter-button ${filter === null ? 'active' : ''}`}
        onClick={() => onFilterChange(null)}
      >
        Все
      </button>
      <button
        className={`filter-button ${filter === true ? 'active' : ''}`}
        onClick={() => onFilterChange(true)}
      >
        Активные
      </button>
      <button
        className={`filter-button ${filter === false ? 'active' : ''}`}
        onClick={() => onFilterChange(false)}
      >
        Неактивные
      </button>
    </div>
  )
}

FilterBar.propTypes = {
  filter: PropTypes.bool,
  onFilterChange: PropTypes.func.isRequired,
}

export default FilterBar
