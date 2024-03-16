package data

import models.Message
import models.Question
import models.QuestionType
import models.Topic

object SampleData {
    val topics = listOf(
        Topic(1,"Первый","Тесты по матеше"),
        Topic(2,"Второй","Тесты по геоме"),

    )
    val questions = listOf(
        Question(1,1,QuestionType.SIMPLE,"Сколько будет 2+2?"),
        Question(2,1,QuestionType.SIMPLE,"Сколько будет 2*2?"),
        Question(3,1,QuestionType.SIMPLE,"Сколько будет 2-2?"),
        Question(4,1,QuestionType.SIMPLE,"Сколько будет 2/2?"),
        Question(5,2,QuestionType.SIMPLE,"Вычислите площадь квадрата со стороной 2?"),
        Question(6,2,QuestionType.SIMPLE,"Вычислите площадь равнобедренного треугольника у которого высота равна основанию длиной 2?"),
        Question(7,2,QuestionType.SIMPLE,"Вычислите площадь выпуклого равностороннего шестиугольника со стороной 2?"),
        Question(8,2,QuestionType.SIMPLE,"Сколько ребер у тетраэдра?"),
    )
}