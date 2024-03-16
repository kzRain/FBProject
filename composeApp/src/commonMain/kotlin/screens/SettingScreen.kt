package screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen

class SettingScreen: Screen {
    @Composable
    override fun Content() {
        Column {
            Text("Настройки", fontSize = 30.sp)

            Text("В Разработке")
        }
    }

}