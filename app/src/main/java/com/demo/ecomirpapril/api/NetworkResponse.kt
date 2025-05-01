package com.demo.ecomirpapril.api

//T refers to WeatherModel
sealed class NetworkResponse<out T> {
    data class Success<out T>(val data : T) : NetworkResponse<T>()
    data class Error(val message : String) : NetworkResponse<Nothing>()
    object Loading : NetworkResponse<Nothing>()
}

inline fun <reified T> NetworkResponse<T>.getOrEmpty(): T {
    return when (this) {
        is NetworkResponse.Success -> this.data
        else -> when (T::class) {
            List::class -> emptyList<Any>() as T
            else -> throw IllegalStateException("No default empty value for ${T::class}")
        }
    }
}
