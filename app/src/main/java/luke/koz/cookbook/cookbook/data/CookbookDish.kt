package luke.koz.cookbook.cookbook.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cookbook_dish")
data class CookbookDish(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val prepTime : Double,
    val cookingTime : Double,
    //val ingredients: List<String>,
    val instruction: String,
    )