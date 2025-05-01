package com.demo.ecomirpapril.ui.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.demo.ecomirpapril.ui.ProductViewModel
import com.demo.ecomirpapril.ui.search.DeliveryScreen
import com.demo.ecomirpapril.ui.sales.salesScreen.FlashSaleScreen

@Composable
fun HomeScreen(navController: NavHostController) {
    val productViewModel: ProductViewModel = viewModel()
    LazyColumn{
        item {
            DeliveryScreen(navController=navController)
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            FlashSaleScreen(productViewModel,navController=navController)
        }
    }

}
