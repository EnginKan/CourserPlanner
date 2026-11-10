package edu.yeditepe.courserplanner.week6

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class Product(
        val id:Int,
        val name: String,
        val description: String,
        val price: Double
        )

class ProductViewModel: ViewModel() {

    private var _products = MutableStateFlow<List<Product>>(
        listOf(Product(1,"Product1","description",101.0),
            Product(2,"Product2","description",103.0),
            Product(3,"Product3","description",110.0)
        )

    )
    val products: StateFlow<List<Product>>
        get() = _products.asStateFlow()

    fun getProductById(id: Int): Product?{
        return _products.value.filter { p->p.id==id }.first()
    }

}