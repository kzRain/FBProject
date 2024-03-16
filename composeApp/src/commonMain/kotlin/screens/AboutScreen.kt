package screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen

class AboutScreen: Screen {
    @Composable
    override fun Content() {
        Column {
            Text("О Проекте", fontSize = 30.sp)

            Text("В Разработке")
        }
    }

}