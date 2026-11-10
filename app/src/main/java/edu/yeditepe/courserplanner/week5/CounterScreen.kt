package edu.yeditepe.courserplanner.week5

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.yeditepe.courserplanner.ui.theme.CourserPlannerTheme

@Composable
fun CounterView(model: CounterViewModel){

    val counter = model.counter.collectAsState()

    Column() {

        Text(
            text = "Counter: ${counter.value}"
        )
        Row() {
            Button(onClick = {model.increment()}) {
                Text(text = "Increment")
            }
        }
        Button(onClick = {model.decrement()}) {
            Text(text = "Decrement")
        }
    }
    }

@Preview
@Composable
fun CounterScreenPreview(){
    val model : CounterViewModel = viewModel()
    CourserPlannerTheme{
        CounterView(model=model)

    }

}