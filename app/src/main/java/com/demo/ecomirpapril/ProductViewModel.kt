package com.demo.ecomirpapril


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.ecomirpapril.api.NetworkResponse
import com.demo.ecomirpapril.api.RetrofitInstance
import com.demo.ecomirpapril.model.Product
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    private val productsApi = RetrofitInstance.productsApi
    private val _productsResult = MutableLiveData<NetworkResponse<Product>>()
    val productResult : LiveData<NetworkResponse<Product>> = _productsResult
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

}












