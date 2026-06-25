import PropTypes from 'prop-types'
import './ErrorMessage.css'

function ErrorMessage({ message, onClose }) {
  return (
    <div className="error-message">
      <span>{message}</span>
      {onClose && (
        <button className="error-close" onClick={onClose}>
          ×
        </button>
      )}
    </div>
  )
}

ErrorMessage.propTypes = {
  message: PropTypes.string.isRequired,
  onClose: PropTypes.func,
}

export default ErrorMessage
