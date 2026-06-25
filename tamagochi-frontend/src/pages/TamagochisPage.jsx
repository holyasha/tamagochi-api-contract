import { useState } from 'react'
import { useTamagochiContext } from '../hooks/useTamagochiContext'
import SectionCard from '../components/ui/SectionCard'
import Loader from '../components/ui/Loader'
import ErrorMessage from '../components/ui/ErrorMessage'
import FilterBar from '../components/FilterBar'
import TamagochiSearchBar from '../components/TamagochiSearchBar'
import CreateTamagochiForm from '../components/CreateTamagochiForm'
import TamagochiList from '../components/TamagochiList'
import EditTamagochiModal from '../components/EditTamagochiModal'

function TamagochisPage() {
  const {
    tamagochis,
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
  } = useTamagochiContext()

  const [editingTamagochi, setEditingTamagochi] = useState(null)

  return (
    <div className="page-grid">
      {error && <ErrorMessage message={error} onClose={clearError} />}

      <SectionCard title="Создать нового питомца">
        <CreateTamagochiForm onCreate={handleCreate} />
      </SectionCard>

      <SectionCard title="Фильтры и поиск">
        <FilterBar filter={filter} onFilterChange={setFilter} />
        <TamagochiSearchBar search={search} onSearchChange={setSearch} />
      </SectionCard>

      <SectionCard title="Список питомцев">
        {isLoading ? (
          <Loader />
        ) : (
          <TamagochiList
            tamagochis={tamagochis}
            onToggleStatus={handleToggleStatus}
            onEdit={setEditingTamagochi}
            onDelete={handleDelete}
          />
        )}
      </SectionCard>

      {editingTamagochi && (
        <EditTamagochiModal
          tamagochi={editingTamagochi}
          onUpdate={handleUpdate}
          onClose={() => setEditingTamagochi(null)}
        />
      )}
    </div>
  )
}

export default TamagochisPage
