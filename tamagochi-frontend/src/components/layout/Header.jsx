import { NavLink } from 'react-router-dom'
import './Header.css'

function Header() {
  return (
    <header className="app-header">
      <div className="header-content">
        <h1 className="app-title">Tamagochi Management System</h1>
        <p className="app-subtitle">Управление питомцами и владельцами</p>
        <nav className="app-nav">
          <NavLink to="/tamagochis" className="nav-link">
            Питомцы
          </NavLink>
          <NavLink to="/owners" className="nav-link">
            Владельцы
          </NavLink>
        </nav>
      </div>
    </header>
  )
}

export default Header
