package screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.currentCompositeKeyHash
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import components.AskQuestion
import components.DetailsContent
import components.LoadingContent
import models.DetailsScreenModel
import models.QuestionScreenModel

data class TestScreen(
    val text: String,
    val topicId: Long,
    val index: Int,
    val maxIndex: Int,
    val onClick: () -> Unit
): Screen {
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { QuestionScreenModel(topicId) }
        val state by screenModel.state.collectAsState()
        when (val result = state) {
            is QuestionScreenModel.State.Loading -> LoadingContent()
            is QuestionScreenModel.State.Result -> {
                AskQuestion(screenModel, result.item, text, onClick)
            }
        }

        LaunchedEffect(currentCompositeKeyHash) {
            screenModel.getItem(index)
        }
    }

}
