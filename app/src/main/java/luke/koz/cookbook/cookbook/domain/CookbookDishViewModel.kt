package luke.koz.cookbook.cookbook.domain

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import luke.koz.cookbook.cookbook.data.RecipesRepository
import luke.koz.cookbook.navigation.DishDetailsSerializable

class CookbookDishViewModel (
    savedStateHandle: SavedStateHandle,
    dishRepository: RecipesRepository
): ViewModel() {
//    private val dishId: Int = checkNotNull(savedStateHandle[])

}