import { memo } from 'react'
import PropTypes from 'prop-types'

const OwnerCard = memo(function OwnerCard({ owner, onToggleStatus, onEdit, onDelete }) {
  const isActive = owner.isActive !== false

  return (
    <div className={`item-card ${!isActive ? 'inactive' : ''}`}>
      <div className="item-header">
        <div className="item-name">{owner.name}</div>
        <div className={`status-badge ${isActive ? 'active' : 'inactive'}`}>
          {isActive ? 'Активен' : 'Неактивен'}
        </div>
      </div>

      <div className="item-details">
        <div className="item-property">
          <span className="property-label">ID:</span>
          <span className="property-value">{owner.id}</span>
        </div>
        {owner.nickname && (
          <div className="item-property">
            <span className="property-label">Игровой ник:</span>
            <span className="property-value">{owner.nickname}</span>
          </div>
        )}
        {owner.email && (
          <div className="item-property">
            <span className="property-label">Email:</span>
            <span className="property-value">{owner.email}</span>
          </div>
        )}
        <div className="item-property">
          <span className="property-label">Дата рождения:</span>
          <span className="property-value">{owner.birthDate}</span>
        </div>
        <div className="item-property">
          <span className="property-label">Количество питомцев:</span>
          <span className="property-value">{owner.tamagochisCount || 0}</span>
        </div>
      </div>

      <div className="item-actions">
        <button
          className={`action-button toggle-button ${!isActive ? '' : 'deactivate'}`}
          onClick={() => onToggleStatus(owner.id, isActive)}
        >
          {isActive ? 'Деактивировать' : 'Активировать'}
        </button>
        <button className="action-button edit-button" onClick={() => onEdit(owner)}>
          Изменить
        </button>
        <button className="action-button delete-button" onClick={() => onDelete(owner.id)}>
          Удалить
        </button>
      </div>
    </div>
  )
})

OwnerCard.propTypes = {
  owner: PropTypes.shape({
    id: PropTypes.number.isRequired,
    name: PropTypes.string.isRequired,
    nickname: PropTypes.string,
    email: PropTypes.string,
    birthDate: PropTypes.string.isRequired,
    tamagochisCount: PropTypes.number,
    isActive: PropTypes.bool,
  }).isRequired,
  onToggleStatus: PropTypes.func.isRequired,
  onEdit: PropTypes.func.isRequired,
  onDelete: PropTypes.func.isRequired,
}

export default OwnerCard
