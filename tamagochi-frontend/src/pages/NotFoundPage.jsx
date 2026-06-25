import { Link } from 'react-router-dom'
import './NotFoundPage.css'

function NotFoundPage() {
  return (
    <div className="not-found-page">
      <div className="not-found-content">
        <h1 className="not-found-title">404</h1>
        <p className="not-found-text">Страница не найдена</p>
        <Link to="/tamagochis" className="not-found-link">
          Вернуться на главную
        </Link>
      </div>
    </div>
  )
}

export default NotFoundPage
