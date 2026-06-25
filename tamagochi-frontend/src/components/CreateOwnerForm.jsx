import { useState } from 'react'
import PropTypes from 'prop-types'
import './CreateTamagochiForm.css'

function CreateOwnerForm({ onCreate }) {
  const [formData, setFormData] = useState({
    name: '',
    nickname: '',
    email: '',
    birthDate: ''
  })

  const handleSubmit = async (e) => {
    e.preventDefault()
    const success = await onCreate({
      ...formData,
      isActive: true
    })
    if (success) {
      setFormData({
        name: '',
        nickname: '',
        email: '',
        birthDate: ''
      })
    }
  }

  const handleChange = (field, value) => {
    setFormData({ ...formData, [field]: value })
  }

  return (
    <form onSubmit={handleSubmit} className="create-form">
      <div className="form-group">
        <div className="form-field">
          <label>Имя</label>
          <input
            type="text"
            value={formData.name}
            onChange={(e) => handleChange('name', e.target.value)}
            placeholder='Введите имя'
            required
          />
        </div>
        <div className="form-field">
          <label>Игровой ник</label>
          <input
            type="text"
            value={formData.nickname}
            onChange={(e) => handleChange('nickname', e.target.value)}
            placeholder='Введите ник'
          />
        </div>
        <div className="form-field">
          <label>Email</label>
          <input
            type="email"
            value={formData.email}
            onChange={(e) => handleChange('email', e.target.value)}
            placeholder='Введите email'
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
      </div>
      <button type="submit" className="create-button">
        Создать владельца
      </button>
    </form>
  )
}

CreateOwnerForm.propTypes = {
  onCreate: PropTypes.func.isRequired,
}

export default CreateOwnerForm
