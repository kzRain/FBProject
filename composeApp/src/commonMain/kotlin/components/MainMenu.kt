package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import screens.AboutScreen
import screens.ChooseGameScreen
import screens.SettingScreen

@Composable
fun MainMenuComponent() {
    val navigator = LocalNavigator.currentOrThrow

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Меню", fontSize = 30.sp)
        Spacer(modifier = Modifier.height(25.dp))
        Button(
            modifier = Modifier.width(250.dp),
            onClick = {
                navigator.push(ChooseGameScreen())
            }
        ) {
            Text("Играть", fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.height(45.dp))
        Button(
            modifier = Modifier.width(250.dp),
            onClick = {
                navigator.push(SettingScreen())
            }
        ) {
            Text("Настройки", fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.height(45.dp))
        Button(
            modifier = Modifier.width(250.dp),
            onClick = {
                navigator.push(AboutScreen())
            }
        ) {
            Text("О Проекте", fontSize = 30.sp)
        }
    }
}