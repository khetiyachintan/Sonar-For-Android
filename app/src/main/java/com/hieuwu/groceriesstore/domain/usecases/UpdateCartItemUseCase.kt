package com.hieuwu.groceriesstore.domain.usecases

import com.hieuwu.groceriesstore.domain.models.LineItemModel
import com.hieuwu.groceriesstore.domain.models.OrderModel
import kotlinx.coroutines.flow.Flow

interface UpdateCartItemUseCase {
    suspend fun updateLineItem(lineItemModel: LineItemModel)
    suspend fun removeLineItem(lineItemModel: LineItemModel)
    fun getCurrentCart(): Flow<OrderModel?>
}
