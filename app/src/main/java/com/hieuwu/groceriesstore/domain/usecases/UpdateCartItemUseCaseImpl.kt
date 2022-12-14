package com.hieuwu.groceriesstore.domain.usecases

import com.hieuwu.groceriesstore.domain.models.LineItemModel
import com.hieuwu.groceriesstore.domain.models.OrderModel
import com.hieuwu.groceriesstore.domain.repository.OrderRepository
import com.hieuwu.groceriesstore.domain.repository.ProductRepository
import com.hieuwu.groceriesstore.utilities.OrderStatus
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdateCartItemUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository,
    private val orderRepository: OrderRepository
) : UpdateCartItemUseCase {
    override suspend fun updateLineItem(lineItemModel: LineItemModel) {
        productRepository.updateLineItemQuantityById(lineItemModel.quantity!!, lineItemModel.id!!)
    }

    override suspend fun removeLineItem(lineItemModel: LineItemModel) {
        productRepository.removeLineItemById(lineItemModel.id!!)
    }
    override fun getCurrentCart(): Flow<OrderModel?> {
        return orderRepository.getOneOrderByStatus(OrderStatus.IN_CART)
    }
}
