package luke.koz.cookbook.cookbook.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CookbookDishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dish: CookbookDish)

    @Update
    suspend fun update(dish: CookbookDish)

    @Delete
    suspend fun delete(dish: CookbookDish)

    @Query("SELECT * from cookbook_dish WHERE id = :id")
    fun getDish(id: Int): Flow<CookbookDish>

    @Query("SELECT * from cookbook_dish ORDER BY name ASC")
    fun getAllDishes(): Flow<List<CookbookDish>>

}