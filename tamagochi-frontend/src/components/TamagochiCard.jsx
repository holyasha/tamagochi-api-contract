import { memo } from 'react'
import PropTypes from 'prop-types'
import './TamagochiCard.css'

const TamagochiCard = memo(function TamagochiCard({ tamagochi, onToggleStatus, onEdit, onDelete }) {
  const isActive = tamagochi.isActive !== false

  return (
    <div className={`item-card ${!isActive ? 'inactive' : ''}`}>
      <div className="item-header">
        <div className="item-name">{tamagochi.name}</div>
        <div className={`status-badge ${isActive ? 'active' : 'inactive'}`}>
          {isActive ? 'Активен' : 'Неактивен'}
        </div>
      </div>

      <div className="item-details">
        <div className="item-property">
          <span className="property-label">ID:</span>
          <span className="property-value">{tamagochi.id}</span>
        </div>
        <div className="item-property">
          <span className="property-label">Вид:</span>
          <span className="property-value">{tamagochi.species}</span>
        </div>
        <div className="item-property">
          <span className="property-label">Цвет:</span>
          <span className="property-value">{tamagochi.color}</span>
        </div>
        <div className="item-property">
          <span className="property-label">Дата рождения:</span>
          <span className="property-value">{tamagochi.birthDate}</span>
        </div>
        <div className="item-property">
          <span className="property-label">Здоровье:</span>
          <span className="property-value">{tamagochi.health}</span>
        </div>
        <div className="item-property">
          <span className="property-label">Счастье:</span>
          <span className="property-value">{tamagochi.happiness}</span>
        </div>
        <div className="item-property">
          <span className="property-label">Голод:</span>
          <span className="property-value">{tamagochi.hunger}</span>
        </div>
        <div className="item-property">
          <span className="property-label">Энергия:</span>
          <span className="property-value">{tamagochi.energy}</span>
        </div>
        <div className="item-property">
          <span className="property-label">Чистота:</span>
          <span className="property-value">{tamagochi.clearliness}</span>
        </div>
        {tamagochi.owner && (
          <div className="item-property">
            <span className="property-label">Владелец:</span>
            <span className="property-value">{tamagochi.owner.name}</span>
          </div>
        )}
      </div>

      <div className="item-actions">
        <button
          className={`action-button toggle-button ${!isActive ? '' : 'deactivate'}`}
          onClick={() => onToggleStatus(tamagochi.id, isActive)}
        >
          {isActive ? 'Деактивировать' : 'Активировать'}
        </button>
        <button className="action-button edit-button" onClick={() => onEdit(tamagochi)}>
          Изменить
        </button>
        <button className="action-button delete-button" onClick={() => onDelete(tamagochi.id)}>
          Удалить
        </button>
      </div>
    </div>
  )
})

TamagochiCard.propTypes = {
  tamagochi: PropTypes.shape({
    id: PropTypes.number.isRequired,
    name: PropTypes.string.isRequired,
    species: PropTypes.string.isRequired,
    color: PropTypes.string.isRequired,
    birthDate: PropTypes.string.isRequired,
    health: PropTypes.number,
    happiness: PropTypes.number,
    hunger: PropTypes.number,
    energy: PropTypes.number,
    clearliness: PropTypes.number,
    isActive: PropTypes.bool,
    owner: PropTypes.shape({
      id: PropTypes.number,
      name: PropTypes.string,
    }),
  }).isRequired,
  onToggleStatus: PropTypes.func.isRequired,
  onEdit: PropTypes.func.isRequired,
  onDelete: PropTypes.func.isRequired,
}

export default TamagochiCard
