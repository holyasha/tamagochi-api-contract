import './App.css'
import { Navigate, Route, Routes } from 'react-router-dom'
import AppLayout from './components/layout/AppLayout'
import TamagochisPage from './pages/TamagochisPage'
import OwnersPage from './pages/OwnersPage'
import NotFoundPage from './pages/NotFoundPage'

function App() {
  return (
    <Routes>
      <Route element={<AppLayout />}>
        <Route path="/" element={<Navigate to="/tamagochis" replace />} />
        <Route path="/tamagochis" element={<TamagochisPage />} />
        <Route path="/owners" element={<OwnersPage />} />
        <Route path="*" element={<NotFoundPage />} />
      </Route>
    </Routes>
  )
}

export default App
