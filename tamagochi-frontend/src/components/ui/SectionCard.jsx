import PropTypes from 'prop-types'
import './SectionCard.css'

function SectionCard({ title, children }) {
  return (
    <section className="section-card">
      {title && <h2 className="section-title">{title}</h2>}
      <div className="section-content">{children}</div>
    </section>
  )
}

SectionCard.propTypes = {
  title: PropTypes.string,
  children: PropTypes.node.isRequired,
}

export default SectionCard
