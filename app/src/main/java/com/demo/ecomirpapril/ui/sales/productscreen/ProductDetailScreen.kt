package com.demo.ecomirpapril.ui.sales.productscreen

import android.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.demo.ecomirpapril.ui.ProductViewModel
import com.demo.ecomirpapril.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    viewModel: ProductViewModel,
    productId: Int,
    navController: NavController,
) {
    val productDetails = viewModel.getProductById(productId)
    productDetails?.let {
        product->
        Scaffold(
            containerColor = Color.White,
            topBar = {
                TopAppBar(
                    title = { Text("Product Details", style = MaterialTheme.typography.headlineMedium) },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_menu_revert),
                                contentDescription = "Back"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Purple40,
                        titleContentColor = Color.Black
                    )
                )
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    ProductImageSection(product)
                    Spacer(modifier = Modifier.height(16.dp))
                    ProductPricingSection(product)
                    ProductDetailsSection(product)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        )
    }
}
