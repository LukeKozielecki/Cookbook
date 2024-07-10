package luke.koz.cookbook.cookbook.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import luke.koz.cookbook.R
import luke.koz.cookbook.cookbook.data.CookbookDish

@Composable
fun DishScreen(
    modifier: Modifier = Modifier,
    dish: CookbookDish,
    ) {

    Column (Modifier.fillMaxWidth()){
        Text(
            text = dish.name,
            style = MaterialTheme.typography.titleLarge
        )
        Row {
            Text(
                text = "Prep time ${dish.prepTime} minutes",
                style = MaterialTheme.typography.bodyLarge
            )
            //todo number into hourly format & embed it in string resource
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Cook time ${dish.cookingTime} minutes",
                style = MaterialTheme.typography.bodyLarge)
        }
//        for (ingredientNumber in dish.ingredients) {
//            Text(text = ingredientNumber)
//        }
        Text(
            text = dish.instruction,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DishScreenPrev() {
    DishScreen(
        dish = CookbookDish(
            id = 0,
            name = stringResource(R.string.dummy_dish_screen_prev_name),
            prepTime = 15.0,
            cookingTime = 40.0,
//            ingredients = listOf(
//                stringResource(R.string.dummy_dish_screen_prev_listItems)
//            ),
            instruction = stringResource(R.string.dummy_dish_screen_prev_instruction)
        )
    )
}