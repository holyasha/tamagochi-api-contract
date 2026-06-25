import { memo } from 'react'
import PropTypes from 'prop-types'
import TamagochiCard from './TamagochiCard'

const TamagochiList = memo(function TamagochiList({ tamagochis, onToggleStatus, onEdit, onDelete }) {
  if (tamagochis.length === 0) {
    return <p style={{ textAlign: 'center', color: '#666' }}>Питомцы не найдены</p>
  }

  return (
    <div className="items-grid">
      {tamagochis.map((tamagochi) => (
        <TamagochiCard
          key={tamagochi.id}
          tamagochi={tamagochi}
          onToggleStatus={onToggleStatus}
          onEdit={onEdit}
          onDelete={onDelete}
        />
      ))}
    </div>
  )
})

TamagochiList.propTypes = {
  tamagochis: PropTypes.arrayOf(PropTypes.object).isRequired,
  onToggleStatus: PropTypes.func.isRequired,
  onEdit: PropTypes.func.isRequired,
  onDelete: PropTypes.func.isRequired,
}

export default TamagochiList
