import { useState } from 'react'
import PropTypes from 'prop-types'
import './Modal.css'

function EditOwnerModal({ owner, onUpdate, onClose }) {
  const [formData, setFormData] = useState({
    name: owner.name,
    nickname: owner.nickname || '',
    email: owner.email || '',
    birthDate: owner.birthDate,
    isActive: owner.isActive !== false
  })

  const handleSubmit = async (e) => {
    e.preventDefault()
    const success = await onUpdate(owner.id, formData)
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
          <h2 className="modal-title">Редактировать владельца</h2>
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
              <label>Игровой ник</label>
              <input
                type="text"
                value={formData.nickname}
                onChange={(e) => handleChange('nickname', e.target.value)}
              />
            </div>
            <div className="form-field">
              <label>Email</label>
              <input
                type="email"
                value={formData.email}
                onChange={(e) => handleChange('email', e.target.value)}
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

EditOwnerModal.propTypes = {
  owner: PropTypes.object.isRequired,
  onUpdate: PropTypes.func.isRequired,
  onClose: PropTypes.func.isRequired,
}

export default EditOwnerModal
