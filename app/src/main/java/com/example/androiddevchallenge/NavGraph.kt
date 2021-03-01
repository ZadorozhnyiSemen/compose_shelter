package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.MainDestinations.DOG_DETAIL_ID_KEY
import com.example.androiddevchallenge.ui.screens.dog.DogDetails
import com.example.androiddevchallenge.ui.screens.shelter.Shelter

object MainDestinations {
    const val SHELTER_ROUTE = "shelter"
    const val DOG_DETAIL_ROUTE = "dog"
    const val DOG_DETAIL_ID_KEY = "dogId"
}

@Composable
fun NavGraph(startDestination: String = MainDestinations.SHELTER_ROUTE) {
    val navController = rememberNavController()

    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.SHELTER_ROUTE) {
            Shelter(selectDog = actions.selectDog)
        }
        composable(
            "${MainDestinations.DOG_DETAIL_ROUTE}/{$DOG_DETAIL_ID_KEY}",
            arguments = listOf(navArgument(DOG_DETAIL_ID_KEY) { type = NavType.IntType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            DogDetails(
                arguments.getInt(DOG_DETAIL_ID_KEY),
                upPress = actions.upPress,
            )
        }
    }
}

/**
 * Models the navigation actions in the app.
 */
class MainActions(navController: NavHostController) {
    val selectDog: (Int) -> Unit = { dogId: Int ->
        navController.navigate("${MainDestinations.DOG_DETAIL_ROUTE}/$dogId")
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}