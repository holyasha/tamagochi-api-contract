import { useState } from 'react'
import PropTypes from 'prop-types'
import './CreateTamagochiForm.css'

function CreateTamagochiForm({ onCreate }) {
  const [formData, setFormData] = useState({
    name: '',
    species: '',
    color: '',
    birthDate: '',
    ownerId: ''
  })

  const handleSubmit = async (e) => {
    e.preventDefault()
    const success = await onCreate({
      ...formData,
      ownerId: parseInt(formData.ownerId),
      isActive: true
    })
    if (success) {
      setFormData({
        name: '',
        species: '',
        color: '',
        birthDate: '',
        ownerId: ''
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
            <option value="">-- Выберите вид --</option>
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
      </div>
      <button type="submit" className="create-button">
        Создать питомца
      </button>
    </form>
  )
}

CreateTamagochiForm.propTypes = {
  onCreate: PropTypes.func.isRequired,
}

export default CreateTamagochiForm
