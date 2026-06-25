import { useState } from 'react'
import PropTypes from 'prop-types'
import './Modal.css'

function EditTamagochiModal({ tamagochi, onUpdate, onClose }) {
  const [formData, setFormData] = useState({
    name: tamagochi.name,
    species: tamagochi.species,
    color: tamagochi.color,
    birthDate: tamagochi.birthDate,
    ownerId: tamagochi.owner?.id || '',
    health: tamagochi.health || 100,
    happiness: tamagochi.happiness || 100,
    hunger: tamagochi.hunger || 0,
    energy: tamagochi.energy || 100,
    clearliness: tamagochi.clearliness || 100,
    isActive: tamagochi.isActive !== false
  })

  const handleSubmit = async (e) => {
    e.preventDefault()
    const success = await onUpdate(tamagochi.id, {
      ...formData,
      ownerId: parseInt(formData.ownerId)
    })
    if (success) {
      onClose()
    }
  }

  const handleChange = (field, value) => {
    setFormData({ ...formData, [field]: value })
  }

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal-content" onClick={(e) => e.stopPropagation()}>
        <div className="modal-header">
          <h2 className="modal-title">Редактировать питомца</h2>
          <button className="modal-close" onClick={onClose}>
            ×
          </button>
        </div>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <div className="form-field">
              <label>Имя</label>
              <input
                type="text"
                value={formData.name}
                onChange={(e) => handleChange('name', e.target.value)}
                required
              />
            </div>
            <div className="form-field">
              <label>Вид</label>
              <select
                value={formData.species}
                onChange={(e) => handleChange('species', e.target.value)}
                required
              >
                <option value="Кошка">Кошка</option>
                <option value="Собака">Собака</option>
                <option value="Робот">Робот</option>
                <option value="Пришелец">Пришелец</option>
                <option value="Дракон">Дракон</option>
              </select>
            </div>
            <div className="form-field">
              <label>Цвет</label>
              <input
                type="text"
                value={formData.color}
                onChange={(e) => handleChange('color', e.target.value)}
                required
              />
            </div>
            <div className="form-field">
              <label>Дата рождения</label>
              <input
                type="date"
                value={formData.birthDate}
                onChange={(e) => handleChange('birthDate', e.target.value)}
                required
              />
            </div>
            <div className="form-field">
              <label>ID владельца</label>
              <input
                type="number"
                value={formData.ownerId}
                onChange={(e) => handleChange('ownerId', e.target.value)}
                min="1"
                required
              />
            </div>
            <div className="form-field">
              <label>Здоровье (0-100)</label>
              <input
                type="number"
                value={formData.health}
                onChange={(e) => handleChange('health', parseInt(e.target.value))}
                min="0"
                max="100"
                required
              />
            </div>
            <div className="form-field">
              <label>Счастье (0-100)</label>
              <input
                type="number"
                value={formData.happiness}
                onChange={(e) => handleChange('happiness', parseInt(e.target.value))}
                min="0"
                max="100"
                required
              />
            </div>
            <div className="form-field">
              <label>Голод (0-100)</label>
              <input
                type="number"
                value={formData.hunger}
                onChange={(e) => handleChange('hunger', parseInt(e.target.value))}
                min="0"
                max="100"
                required
              />
            </div>
            <div className="form-field">
              <label>Энергия (0-100)</label>
              <input
                type="number"
                value={formData.energy}
                onChange={(e) => handleChange('energy', parseInt(e.target.value))}
                min="0"
                max="100"
                required
              />
            </div>
            <div className="form-field">
              <label>Чистота (0-100)</label>
              <input
                type="number"
                value={formData.clearliness}
                onChange={(e) => handleChange('clearliness', parseInt(e.target.value))}
                min="0"
                max="100"
                required
              />
            </div>
            <div className="form-field">
              <label>Статус</label>
              <select
                value={String(formData.isActive)}
                onChange={(e) => handleChange('isActive', e.target.value === 'true')}
                required
              >
                <option value="true">Активен</option>
                <option value="false">Неактивен</option>
              </select>
            </div>
          </div>
          <button type="submit" className="create-button">
            Сохранить изменения
          </button>
        </form>
      </div>
    </div>
  )
}

EditTamagochiModal.propTypes = {
  tamagochi: PropTypes.object.isRequired,
  onUpdate: PropTypes.func.isRequired,
  onClose: PropTypes.func.isRequired,
}

export default EditTamagochiModal
