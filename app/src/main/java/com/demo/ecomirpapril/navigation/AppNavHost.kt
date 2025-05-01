package com.demo.ecomirpapril.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.demo.ecomirpapril.ui.ProductViewModel
import com.demo.ecomirpapril.ui.favourites.FavoritesScreen
import com.demo.ecomirpapril.ui.sales.productscreen.ProductDetailScreen
import com.demo.ecomirpapril.ui.home.HomeScreen
import com.demo.ecomirpapril.ui.profile.ProfileScreen
import com.demo.ecomirpapril.ui.sales.salesScreen.FlashSaleScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    val productViewModel: ProductViewModel = viewModel()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home_screen",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home_screen") {
                HomeScreen(navController = navController)
            }

            composable("flash_sale_screen") {
                FlashSaleScreen(productViewModel,navController = navController)
            }

            composable("favourites_screen") {
                FavoritesScreen(navController = navController)
            }

            composable("profile_screen") {
                ProfileScreen()
            }

            composable("productDetail/{productId}") { backStackEntry ->
                val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
                if (productId != null) {
                    ProductDetailScreen(
                        productViewModel,
                        productId = productId,
                        navController = navController,
                    )
                }
            }
        }
    }
}
