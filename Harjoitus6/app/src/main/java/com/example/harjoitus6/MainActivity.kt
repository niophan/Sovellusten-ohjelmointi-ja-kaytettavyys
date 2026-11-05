package com.example.harjoitus6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
data object ProductListRoute

@Serializable
data class ProductDetailRoute(
    val itemId: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProductExplorerApp()
        }
    }

    override fun onPause() {
        super.onPause()
        println("Activity paused")
    }

    override fun onStop() {
        super.onStop()
        println("Activity stopped")
    }

    override fun onResume() {
        super.onResume()
        println("Activity resumed")
    }
}

@Composable
fun ProductExplorerApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ProductListRoute) {
        composable<ProductListRoute> {
            ProductsListScreen(
                onProductClick = { productId ->
                    navController.navigate(ProductDetailRoute(itemId = productId))
                }
            )
        }
        composable<ProductDetailRoute> { backStackEntry ->
            val detailRoute = backStackEntry.toRoute<ProductDetailRoute>()
            println("itemId: $detailRoute")
            val product = products.find { it.id == detailRoute.itemId } ?: products[0]
            println("product: $product")
            ProductDetails(
                item = product,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
