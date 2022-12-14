package com.hieuwu.groceriesstore.domain.repository

import androidx.lifecycle.LiveData
import com.hieuwu.groceriesstore.domain.models.ProductModel
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    val products: Flow<List<ProductModel>>
    fun getProductById(productId: String): LiveData<ProductModel>
    fun getAllProducts(): LiveData<List<ProductModel>>
    fun getAllProductsByCategory(categoryId: String): Flow<List<ProductModel>>
    suspend fun refreshDatabase()
    suspend fun updateLineItemQuantityById(quantity: Int, id: Long)
    suspend fun removeLineItemById(id: Long)
    fun searchProductsListByName(name: String?): LiveData<List<ProductModel>>
}
