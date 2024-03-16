package models

import kotlinx.serialization.Serializable

enum class QuestionType {
    SIMPLE, IMAGED, SIMPLE_ANSWERED, IMAGE_ANSERED
}
@Serializable
data class Topic(
    val id: Long,
    val topicName: String,
    val topicDescr: String
)
@Serializable
data class Question(
    val id: Long,
    val topicId: Long,
    val questionType: QuestionType,
    val content: String,
    val contentImage: String? = null,
    val answers: List<Answer>? = null,
)

@Serializable
data class Answer(
    val id: Long,
    val questionId: Long,
    val content: String
)