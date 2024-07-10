package luke.koz.cookbook.cookbook.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [CookbookDish::class], version = 1, exportSchema = false)
abstract class CookbookDatabase :RoomDatabase() {

    abstract fun dishDao(): CookbookDishDao

    companion object {
        @Volatile
        private var Instance: CookbookDatabase? = null

        fun getDatabase(context: Context): CookbookDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, CookbookDatabase::class.java, "item_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }

        }
    }
}