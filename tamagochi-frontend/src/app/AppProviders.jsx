import PropTypes from 'prop-types'
import { BrowserRouter } from 'react-router-dom'
import { TamagochiContextProvider } from '../context/TamagochiContext'
import { OwnerContextProvider } from '../context/OwnerContext'

function AppProviders({ children }) {
  return (
    <BrowserRouter>
      <TamagochiContextProvider>
        <OwnerContextProvider>
          {children}
        </OwnerContextProvider>
      </TamagochiContextProvider>
    </BrowserRouter>
  )
}

AppProviders.propTypes = {
  children: PropTypes.node.isRequired,
}

export default AppProviders
