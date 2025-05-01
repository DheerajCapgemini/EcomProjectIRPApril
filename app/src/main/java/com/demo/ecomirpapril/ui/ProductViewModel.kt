package com.demo.ecomirpapril.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.ecomirpapril.api.NetworkResponse
import com.demo.ecomirpapril.api.RetrofitInstance
import com.demo.ecomirpapril.api.getOrEmpty
import com.demo.ecomirpapril.model.Product
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    private val productsApi = RetrofitInstance.productsApi
    private val _productsResult = MutableLiveData<NetworkResponse<List<Product>>>()
    val productResult : LiveData<NetworkResponse<List<Product>>> = _productsResult
    init {
        getData()
    }

    fun getData(){
        _productsResult.value = NetworkResponse.Loading
        viewModelScope.launch {
            try{
                val response = productsApi.getProducts()
                if(response.isSuccessful){
                    response.body()?.let {
                        _productsResult.value = NetworkResponse.Success(it)
                    }
                }else{
                    _productsResult.value = NetworkResponse.Error("Failed to load data")
                }
            }
            catch (e : Exception){
                _productsResult.value = NetworkResponse.Error("Failed to load data")
            }

        }
    }

    fun getProductById(id: Int): Product? {
        val productList = productResult.value?.getOrEmpty() ?: emptyList()
        return productList.find { it.id == id }
    }

}












