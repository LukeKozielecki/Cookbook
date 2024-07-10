package luke.koz.cookbook

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import luke.koz.cookbook.cookbook.domain.CookbookDishViewModel
import luke.koz.cookbook.cookbook.domain.CookbookViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            CookbookViewModel(inventoryApplication().container.recipesRepository)
        }

        initializer {
            CookbookDishViewModel(this.createSavedStateHandle(), inventoryApplication().container.recipesRepository)
        }
    }
}
fun CreationExtras.inventoryApplication(): InventoryApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as InventoryApplication)