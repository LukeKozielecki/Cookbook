package luke.koz.cookbook.cookbook.data

import kotlinx.coroutines.flow.Flow

class OfflineRecipesRepository (private val dishDAO: CookbookDishDao) : RecipesRepository {
    override fun getAllRecipesStream(): Flow<List<CookbookDish>> = dishDAO.getAllDishes()

    override fun getRecipeStream(id: Int): Flow<CookbookDish?> = dishDAO.getDish(id)

    override suspend fun insertRecipe(recipe: CookbookDish) = dishDAO.insert(recipe)

    override suspend fun deleteRecipe(recipe: CookbookDish) = dishDAO.delete(recipe)

    override suspend fun updateRecipe(recipe: CookbookDish) = dishDAO.update(recipe)
}
