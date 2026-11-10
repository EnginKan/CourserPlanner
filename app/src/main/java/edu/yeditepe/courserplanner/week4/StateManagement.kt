package edu.yeditepe.courserplanner.week4

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import edu.yeditepe.courserplanner.ui.theme.CourserPlannerTheme


/*Example1 : Score Card Example*/

@Composable
fun ScoreCard(){
    var counter: MutableState<Int> = rememberSaveable{mutableStateOf(0)}
    Card() {
        Text(text= "Score: ${counter.value}")
        Button(onClick = {counter.value++}){
            Text(text= "Increment")
        }
    }
}

//@Preview
//@Composable
//fun ScoreCardPreview(){
//    CourserPlannerTheme {
//        ScoreCard()
//    }
//
//}

/*Example 2: Survey Question*/

@Composable
fun MultipleChoiceOption(isSelected:Boolean,
                         answers: String,
                         onClick:()->Unit) {
    Row {
        RadioButton(
            selected = isSelected,
            onClick = onClick)
        Text(text = answers)
    }
}
class Question(val question: String, val answers: List<String>)
@Composable
fun SurveyQuestion(question: Question){
    var selectedAnswer : String? by rememberSaveable { mutableStateOf(null)}
    Card (){
        Text(text= question.question)
        question.answers.forEach {
            option->MultipleChoiceOption(selectedAnswer.equals(option),
            option,
                onClick = {selectedAnswer = option})
        }

    }

}

@Composable
fun SurveyScreen(questions: List<Question>){
    var index: Int by rememberSaveable {mutableStateOf(0) }
    Column() {
        Text(text="${index+1}/{${questions.size}")

        SurveyQuestion(questions.get(index))
        Row{
            Button(
                onClick = {index--},
                enabled = index>0
            ){
                Text(text = "Prev")
            }
            Button(
                onClick = {index++},
                enabled = index < questions.size
            ){
                Text(text = "Next")
            }
        }
    }

}

@Preview
@Composable
fun SurveyScreenPreview() {
    val question= Question("question text",listOf("option1","option2","option3"))
    val qlist: MutableList<Question> = mutableListOf(question,question,question)
    CourserPlannerTheme() {
        SurveyScreen(qlist)
    }
}
