package models

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import service.getQuestions

class QuestionScreenModel(
    val topicId: Long
) : StateScreenModel<QuestionScreenModel.State>(State.Loading) {

    sealed class State {
        object Loading : State()
        data class Result(val item: Question) : State()
    }

    fun getItem(index: Int) {
        screenModelScope.launch {
            delay(1_000)
            val questions = getQuestions(topicId)
            val result = if (questions.size<=index) questions.last() else {
                if (index<0) questions.first() else questions[index]
            }
            mutableState.value = State.Result(result)
        }
    }

    override fun onDispose() {
        println("ScreenModel: dispose details")
    }
}