package luke.koz.cookbook

import android.app.Application
import luke.koz.cookbook.cookbook.data.AppContainer
import luke.koz.cookbook.cookbook.data.AppDataContainer

class InventoryApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
