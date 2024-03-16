package components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import models.Question
import models.QuestionScreenModel
import kotlin.random.Random

val sampleItems: List<String>
    get() = (0..99).map { "Item #$it | ${Random.nextInt()}" }

@Composable
fun LoadingContent() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListContent(items: List<String>, onClick: ((Int) -> Unit)? = null) {
    LazyColumn {
        itemsIndexed(items) { index, item ->
            ListItem(
                text = { Text(text = item) },
                modifier = if (onClick == null) Modifier else Modifier.clickable { onClick(index) }
            )
        }
    }
}

@Composable
fun DetailsContent(instance: Any, item: String, onClick: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = item,
            style = MaterialTheme.typography.h5
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = instance.toString().substringAfterLast('.'),
            style = MaterialTheme.typography.body2
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onClick,
            content = { Text(text = "Back") }
        )
    }
}

@Composable
fun AskQuestion(instance: QuestionScreenModel, item: Question, topic: String,  onClick: () -> Unit) {
    var text by rememberSaveable { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = topic,
            style = MaterialTheme.typography.h3
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = item.content,
            style = MaterialTheme.typography.h5
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = text,
            onValueChange = {data-> text = data },
            label = { Text("Ваш ответ") },
            trailingIcon = { Icon(Icons.Filled.Send, contentDescription = "Localized description",
                modifier = Modifier.clickable(onClick = onClick)
            ) }
        )

//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = onClick,
//            content = { Text(text = "Back") }
//        )
    }
}