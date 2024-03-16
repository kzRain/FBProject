package kz.beigam.fbproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import screens.MainScreen
import ui.FBTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FBTheme {
                Navigator(
                    screen = MainScreen()
                ) {navigator->
                    FadeTransition(navigator)
                }
            }
        }
    }
}


