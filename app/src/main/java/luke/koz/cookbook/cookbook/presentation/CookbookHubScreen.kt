package luke.koz.cookbook.cookbook.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import luke.koz.cookbook.AppViewModelProvider
import luke.koz.cookbook.R
import luke.koz.cookbook.cookbook.data.CookbookDish
import luke.koz.cookbook.cookbook.domain.CookbookViewModel
import luke.koz.cookbook.ui.theme.CookbookTheme

@Composable
fun CookbookHubScreen(
    modifier: Modifier,
    onDishClick: (Int) -> Unit,
    viewModel: CookbookViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val cookbookUiState by viewModel.cookbookUiState.collectAsState()
    CookbookHubBody(
        dishList = cookbookUiState.itemList,
//        dishList = listOf(
//            CookbookDish(0,"Medium rare spiky-ears", 15.0, 15.0, /*listOf(),*/"Instruction"),
//            CookbookDish(1,"Roasted half-ling", 15.0, 15.0, /*listOf(),*/"Instruction"),
//            CookbookDish(2,"Deep fired who-man", 15.0, 15.0, /*listOf(),*/"Instruction")
//        ),
        onDishClick = onDishClick
    )
}

@Composable
fun CookbookHubBody(
    modifier: Modifier = Modifier,
    dishList: List<CookbookDish>,
    onDishClick: (Int) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        if (dishList.isEmpty()) {
            Text(
                text = stringResource(R.string.dish_list_empty),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
            )
        } else {
            CookbookDishList(
                modifier = modifier,
                dishList = dishList,
                onDishClick = { onDishClick(it.id)}
            )
        }
    }
}

@Composable
fun CookbookDishList(
    modifier: Modifier = Modifier,
    dishList: List<CookbookDish>,
    onDishClick: (CookbookDish) -> Unit,
) {
    LazyColumn {
        items(items = dishList, key = { it.id }) { recipe ->
            CookBookRecipe(recipe = recipe,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .clickable { onDishClick(recipe) })
        }
    }
}

@Composable
fun CookBookRecipe(
    recipe: CookbookDish,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            Row (modifier = Modifier.fillMaxWidth()){
                Text(text = recipe.name)
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
private fun CookbookHubScreenPrev() {
    CookbookTheme {
        CookbookHubScreen(
            modifier = Modifier.fillMaxSize(),
            viewModel = viewModel(),
            onDishClick = {}
        )
    }
}

@Preview (showBackground = true)
@Composable
private fun CookBookRecipePrev() {
    CookbookTheme {
        CookBookRecipe(
            recipe = CookbookDish(id = 0, "Sparky who-man soup", 15.0, 15.0, /*listOf(),*/"Instruction")
        )
    }
}