package com.alfred.gasstationposition.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alfred.gasstationposition.core.navigation.AppRoutes.MAIN_ROUTE
import com.alfred.gasstationposition.ui.view.MainView

/**
 * @author Alfredo Sanz
 * @time 2023
 */


@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = MAIN_ROUTE,
    navActions: NavigationActions = remember(navController) { NavigationActions(navController) }
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(MAIN_ROUTE,
                   arguments = listOf()
        ) {
            val mainView = ViewsStore.getMainView()
            mainView.createView(
            )
        }
    }
}


