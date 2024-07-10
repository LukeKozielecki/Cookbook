package luke.koz.cookbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import luke.koz.cookbook.cookbook.presentation.CookbookHubScreen
import luke.koz.cookbook.cookbook.presentation.CookbookTopBar
import luke.koz.cookbook.navigation.AppNavigationHost
import luke.koz.cookbook.ui.theme.CookbookTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CookbookTheme {
                Scaffold(
                    modifier = Modifier,
                    topBar = { CookbookTopBar(title = R.string.app_name) },
                ) { innerPadding ->
                    Column (modifier = Modifier.fillMaxSize().padding(innerPadding)){
                        AppNavigationHost(Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}