package com.nutry.vkapplication

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.nutry.vkapplication.AppCard
import com.nutry.vkapplication.ui.theme.VKApplicationTheme
import kotlinx.serialization.Serializable


@Serializable
object ListRoute

@Serializable
data class DetailRoute(val itemId: Int)

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = ListRoute) {
        composable<ListRoute>{
            AppListScreen(onAppClick = { clickedId ->
                navController.navigate(DetailRoute(itemId = clickedId))
            })
        }
        composable<DetailRoute> { backStackEntry  ->
            val args: DetailRoute = backStackEntry.toRoute<DetailRoute>()
            val id: Int = args.itemId
            AppCard(
                ItemId = id,
                onShowcaseAppClick = { showcaseAppId ->
                    // случайно сделал переход по карточкам влдаопджлавыопджл
                    //navController.navigate(DetailRoute(itemId = showcaseAppId))
                    navController.navigate(ListRoute) {
                        popUpTo(ListRoute) { inclusive = false }
                    }
                }
            )
        }
    }
}

@Preview
@Composable
private fun ggggg() {
    VKApplicationTheme() {
        AppNavHost()
    }
}