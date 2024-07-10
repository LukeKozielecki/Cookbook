package luke.koz.cookbook.cookbook.data

import kotlinx.coroutines.flow.Flow

interface RecipesRepository {
    /**
     * Retrieve all the recipes from the the given data source.
     */
    fun getAllRecipesStream(): Flow<List<CookbookDish>>

    /**
     * Retrieve an recipe from the given data source that matches with the [id].
     */
    fun getRecipeStream(id: Int): Flow<CookbookDish?>

    /**
     * Insert recipe in the data source
     */
    suspend fun insertRecipe(recipe: CookbookDish)

    /**
     * Delete recipe from the data source
     */
    suspend fun deleteRecipe(recipe: CookbookDish)

    /**
     * Update recipe in the data source
     */
    suspend fun updateRecipe(recipe: CookbookDish)
}