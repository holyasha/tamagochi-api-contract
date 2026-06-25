import { useState } from 'react'
import { useOwnerContext } from '../hooks/useOwnerContext'
import SectionCard from '../components/ui/SectionCard'
import Loader from '../components/ui/Loader'
import ErrorMessage from '../components/ui/ErrorMessage'
import FilterBar from '../components/FilterBar'
import OwnerSearchBar from '../components/OwnerSearchBar'
import CreateOwnerForm from '../components/CreateOwnerForm'
import OwnerList from '../components/OwnerList'
import EditOwnerModal from '../components/EditOwnerModal'

function OwnersPage() {
  const {
    owners,
    isLoading,
    error,
    filter,
    search,
    setFilter,
    setSearch,
    handleCreate,
    handleUpdate,
    handleToggleStatus,
    handleDelete,
    clearError
  } = useOwnerContext()

  const [editingOwner, setEditingOwner] = useState(null)

  return (
    <div className="page-grid">
      {error && <ErrorMessage message={error} onClose={clearError} />}

      <SectionCard title="Создать нового владельца">
        <CreateOwnerForm onCreate={handleCreate} />
      </SectionCard>

      <SectionCard title="Фильтры и поиск">
        <FilterBar filter={filter} onFilterChange={setFilter} />
        <OwnerSearchBar search={search} onSearchChange={setSearch} />
      </SectionCard>

      <SectionCard title="Список владельцев">
        {isLoading ? (
          <Loader />
        ) : (
          <OwnerList
            owners={owners}
            onToggleStatus={handleToggleStatus}
            onEdit={setEditingOwner}
            onDelete={handleDelete}
          />
        )}
      </SectionCard>

      {editingOwner && (
        <EditOwnerModal
          owner={editingOwner}
          onUpdate={handleUpdate}
          onClose={() => setEditingOwner(null)}
        />
      )}
    </div>
  )
}

export default OwnersPage
