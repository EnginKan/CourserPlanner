package edu.yeditepe.courserplanner.week6

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import edu.yeditepe.courserplanner.ui.theme.CourserPlannerTheme


@Composable
fun ProductCard(product: Product,navController: NavController){
    Card(
        onClick = {navController.navigate("detay/${product.id}")}
    ) { Text(text = "${product.name}")
    Text(text = "Price: ${product.price}$")}
}


@Composable
fun ProductCatalog(navController: NavController,
                   model: ProductViewModel){
    val state = model.products.collectAsState()

    LazyColumn(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        items(state.value){
            p->ProductCard(p,navController)
        }
    }

}

@Composable
fun ProductDetail(pId:Int, model: ProductViewModel){
     val product  = rememberSaveable {
         mutableStateOf<Product?>(model.getProductById(pId))
     }
         Column(

    ) {
     when(product.value){

        null->{Text(text = "No Product Exist with ID:$pId")}
        else-> {
            Text(text = "${product.value?.name}")
            Text(text = "${product.value?.description}")
            Text(text = "${product.value?.price}")
        }
    }
}
}

@Composable
fun ProductView(model: ProductViewModel,
                navController: NavController){

    NavHost(navController as NavHostController,
        startDestination = "katalog"){
        composable("katalog"){
            ProductCatalog(navController,model)
        }
        composable("detay/{id}",
            arguments = listOf(navArgument("id"){type=NavType.IntType})){
            stack->ProductDetail(stack.arguments?.getInt("id")?:100,model)

        }
    }
}

@Preview
@Composable
fun ProductViewPreview(){
    val model: ProductViewModel = viewModel()
    val controller = rememberNavController()
    CourserPlannerTheme(

    ) {
        ProductView(model,controller)
    }
}