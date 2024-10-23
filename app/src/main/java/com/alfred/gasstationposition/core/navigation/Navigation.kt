package com.alfred.gasstationposition.core.navigation

import androidx.navigation.NavHostController
import com.alfred.gasstationposition.core.navigation.AppScreens.MAIN_SCREEN


/**
 * @author Alfredo Sanz
 * @time 2023
 */

private object AppScreens {
    const val MAIN_SCREEN = "main"

}

object AppArgs {
    const val LOGIN_ARG = "loginArg"
    const val SIGN_ARG = "signArg"
}

object AppRoutes {
    const val MAIN_ROUTE = "$MAIN_SCREEN"
}

class NavigationActions(private val navController: NavHostController) {

    fun navigateToMain() {
        navController.navigate("$MAIN_SCREEN")
    }
}