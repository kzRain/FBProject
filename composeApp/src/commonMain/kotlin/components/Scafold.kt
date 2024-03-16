package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.runBlocking
import models.Question
import models.Topic
import screens.TestScreen
import service.getQuestions
import service.getTopics

@Composable
fun ScaffoldExample() {
    var presses by remember { mutableStateOf(0) }
    val navigator = LocalNavigator.currentOrThrow
    val topics: List<Topic> = runBlocking { getTopics() }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Top app bar")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                contentColor = MaterialTheme.colors.secondary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                )
            }
        }
    ) { innerPadding ->
        var currentIndex by rememberSaveable { mutableStateOf(0) }
        val navigator = LocalNavigator.currentOrThrow

        Column(
            modifier = Modifier
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Список тестов")
//                KamelImage(
//                    asyncPainterResource("https://img.freepik.com/free-photo/vibrant-colors-nature-close-up-wet-purple-daisy-generated-by-artificial-intellingence_25030-63819.jpg?w=1380&t=st=1707535132~exp=1707535732~hmac=3888e7b8452c0aa8861f132285a9391b7274eaf885da3f06496d3c4800b5c5ba"),
//                    contentDescription = null
//                )
                topics.forEach {
                    val questions = runBlocking { getQuestions(it.id) }
                    Button(
                        onClick = {
                            navigator.push(
                                TestScreen(
                                    it.topicName,
                                    it.id,
                                    currentIndex,
                                    questions.size - 1
                                ) {
                                    showQuestion(navigator, currentIndex+1, questions, it)
                                })
                        }
                    ) {
                        Text(it.topicName)
                    }
                }

            }

        }
    }
}

fun showQuestion(navigator: Navigator, currentIndex: Int, questions: List<Question>, topic: Topic) {
    println("------------------------------")
    println("currentIndex=$currentIndex")
    println("maxIndex=${questions.size - 1}")
    println("==============================")
    if (currentIndex < questions.size - 1) {
        navigator.pop()
        navigator.push(
            TestScreen(
                topic.topicName,
                topic.id,
                currentIndex,
                questions.size - 1
            ){showQuestion(navigator, currentIndex+1, questions, topic)}
        )

    } else {
        navigator.pop()
    }
}
