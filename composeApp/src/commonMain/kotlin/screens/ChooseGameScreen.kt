package screens

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import components.ScaffoldExample

class ChooseGameScreen: Screen {

    @Composable
    override fun Content() {
            ScaffoldExample()
    }

}