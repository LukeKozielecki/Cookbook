package luke.koz.cookbook.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.coroutines.flow.first
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import luke.koz.cookbook.cookbook.data.AppDataContainer
import luke.koz.cookbook.cookbook.data.CookbookDish
import luke.koz.cookbook.cookbook.presentation.CookbookHubScreen
import luke.koz.cookbook.cookbook.presentation.DishScreen

@Composable
fun AppNavigationHost(
    modifier: Modifier,
    navController: NavHostController = rememberNavController(),
) {
    //https://medium.com/androiddevelopers/navigation-compose-meet-type-safety-e081fb3cf2f8
    NavHost(
        navController = navController,
        startDestination = HubSerializable,
    ) {
        composable<HubSerializable> {
            CookbookHubScreen(
                modifier = modifier.fillMaxSize(),
                onDishClick = { id ->
                    navController.navigate(
                        route = DishDetailsSerializable(id
//                            dishAtId = CookbookDish(1,"DummyName.",20.0,20.0,"Instruction")
                        )
                    )//todo remake this to retrive respective item from repository based on it
                }
            )
        }
        composable<DishDetailsSerializable> {
//            val args = it.toRoute<DishDetailsSerializable>()
//            DishScreen(
//                dish = args.dishAtId
//            )
            Column {
                Text(text = it.toString())
                Text(text = id.toString())
                DishScreen(dish = CookbookDish(1, "DummyName.", 20.0, 20.0, "Instruction"))
            }
        }
    }
}

@Serializable
object HubSerializable

@Serializable
data class DishDetailsSerializable (
    val dummy : Int,
//    @Contextual
//    val dishAtId : CookbookDish
)