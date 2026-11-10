package edu.yeditepe.courserplanner.week6

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.yeditepe.courserplanner.ui.theme.CourserPlannerTheme


@Composable
fun SubScreen(mainText: String,
           nextRoute: String,
           navController: NavController){

    Column(modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text= mainText)
        Button(onClick = {navController.navigate(nextRoute)}) {
            Text("Go to next Destination")
        }
    }

}

@Composable
fun MainView(navController: NavController){

    NavHost(navController=navController as NavHostController,
        "second") {
        composable("first"){SubScreen("FirstScreen","second",navController)}
        composable("second"){SubScreen("SecondScreen","third",navController)}
        composable("third"){SubScreen("ThirdScreen","first",navController)}
    }


}

@Preview(showSystemUi = true)
@Composable
fun MainViewPreview(){
    val controller = rememberNavController()
    CourserPlannerTheme() {
        MainView(controller)
    }
}

