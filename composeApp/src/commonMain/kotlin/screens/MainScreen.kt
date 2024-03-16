package screens

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import components.MainMenuComponent

class MainScreen : Screen {

    @Composable
    override fun Content() {
            MainMenuComponent()
    }

}