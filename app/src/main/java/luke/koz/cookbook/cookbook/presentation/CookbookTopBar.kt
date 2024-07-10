package luke.koz.cookbook.cookbook.presentation

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import luke.koz.cookbook.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CookbookTopBar(
    modifier: Modifier = Modifier,
    title: Int,
) {
    CenterAlignedTopAppBar(
        title = { Text (stringResource (id = title)) },)
}

@Preview
@Composable
private fun CookbookTopBarPrev() {
    CookbookTopBar(
        modifier = Modifier,
        title = R.string.app_name
    )
}