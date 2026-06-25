import { memo } from 'react'
import PropTypes from 'prop-types'
import OwnerCard from './OwnerCard'

const OwnerList = memo(function OwnerList({ owners, onToggleStatus, onEdit, onDelete }) {
  if (owners.length === 0) {
    return <p style={{ textAlign: 'center', color: '#666' }}>Владельцы не найдены</p>
  }

  return (
    <div className="items-grid">
      {owners.map((owner) => (
        <OwnerCard
          key={owner.id}
          owner={owner}
          onToggleStatus={onToggleStatus}
          onEdit={onEdit}
          onDelete={onDelete}
        />
      ))}
    </div>
  )
})

OwnerList.propTypes = {
  owners: PropTypes.arrayOf(PropTypes.object).isRequired,
  onToggleStatus: PropTypes.func.isRequired,
  onEdit: PropTypes.func.isRequired,
  onDelete: PropTypes.func.isRequired,
}

export default OwnerList
