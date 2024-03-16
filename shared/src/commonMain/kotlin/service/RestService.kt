package service

import data.SampleData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import models.Question
import models.Topic

class RestService {
}

val httpClient = HttpClient {
    install(ContentNegotiation) {
        json()
    }
}

suspend fun getTopics(): List<Topic> {
//    val result = httpClient.get("").body<List<Topic>>()
    val result = SampleData.topics
    delay(1000)
    return result
}

suspend fun getQuestions(topicId: Long): List<Question> {
    val result = SampleData.questions.filter { it.topicId==topicId }
    delay(1000)
    return result
}