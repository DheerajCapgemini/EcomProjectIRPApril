package com.demo.ecomirpapril.ui.sales.salesScreen

import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.demo.ecomirpapril.api.getOrEmpty
import com.demo.ecomirpapril.ui.ProductViewModel

@Composable
fun FlashSaleScreen(viewModel: ProductViewModel, navController: NavHostController) {
    val productState by viewModel.productResult.observeAsState()
    val productList = productState?.getOrEmpty() ?: emptyList()
    Box(modifier = Modifier.fillMaxSize())
    {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 2000.dp),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(productList) { product ->
                ProductCard(product)
                {
                    navController.navigate(("productDetail/${product.id}"))
                }
            }
        }
    }
}