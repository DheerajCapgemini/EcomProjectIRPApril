package com.demo.ecomirpapril.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DeliveryScreen(navController: NavController) { // ✅ Pass navController
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(12.dp))
        SearchBar(searchQuery, onSearchQueryChanged = { searchQuery = it })
        Spacer(modifier = Modifier.height(12.dp))
    }
}

