package luke.koz.cookbook.cookbook.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import luke.koz.cookbook.cookbook.data.CookbookDish
import luke.koz.cookbook.cookbook.data.RecipesRepository

data class CookbookUiState(val itemList: List<CookbookDish> = listOf())

class CookbookViewModel (recipesRepository : RecipesRepository) : ViewModel() {
    val cookbookUiState : StateFlow<CookbookUiState> =
        recipesRepository.getAllRecipesStream().map { CookbookUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = CookbookUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}