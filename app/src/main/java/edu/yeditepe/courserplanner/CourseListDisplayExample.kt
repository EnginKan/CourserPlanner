package edu.yeditepe.courserplanner.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.yeditepe.courserplanner.ui.theme.CourserPlannerTheme

class Course(
    val id : Int,
    val code: String,
    val name: String,
    val credits: Int,
    val registeredStudent: Int
)

@Composable
fun CourseList(courses: List<Course>){

    LazyColumn(
        modifier= Modifier.fillMaxWidth().fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(courses){
            c->CourseItem(c)
        }
    }
}
@Composable
fun CourseItem(course : Course){
    Column{
        CourseDescription(course)
        CourseName(course.name)
    }
}
@Composable
fun CourseDescription(course : Course){
   Row(
       modifier = Modifier.fillMaxWidth(),
       horizontalArrangement = Arrangement.Center
   ){
       Text(
           text= course.code,
           fontWeight = FontWeight.Bold
       )
       Text(text="Credit: ${course.credits}")
       Text(text= "Stud: ${course.registeredStudent}")
   }

}
@Composable
fun CourseName(courseName: String){

    Text(modifier = Modifier.fillMaxWidth()
        .padding(10.dp),
        text = courseName,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.SansSerif,
        textAlign = TextAlign.Center
    )
}

@Preview(showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun CourseItemPreview(){
    val course = Course(5,"ACM 431",
        "Mobile App. Dev.",3,40)
    var list: MutableList<Course> =mutableListOf()
    repeat(20){ list.add(course)}
    CourserPlannerTheme() {
        CourseList(list)
    }
}