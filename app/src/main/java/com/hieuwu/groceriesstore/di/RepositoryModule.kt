package com.hieuwu.groceriesstore.di

import com.hieuwu.groceriesstore.data.repository.CategoryRepositoryImpl
import com.hieuwu.groceriesstore.data.repository.OrderRepositoryImpl
import com.hieuwu.groceriesstore.data.repository.ProductRepositoryImpl
import com.hieuwu.groceriesstore.data.repository.RecipeRepositoryImpl
import com.hieuwu.groceriesstore.data.repository.UserRepositoryImpl
import com.hieuwu.groceriesstore.domain.repository.CategoryRepository
import com.hieuwu.groceriesstore.domain.repository.OrderRepository
import com.hieuwu.groceriesstore.domain.repository.ProductRepository
import com.hieuwu.groceriesstore.domain.repository.RecipeRepository
import com.hieuwu.groceriesstore.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindRepository(impl: ProductRepositoryImpl): ProductRepository

    @Singleton
    @Binds
    abstract fun bindOrderRepository(impl: OrderRepositoryImpl): OrderRepository

    @Singleton
    @Binds
    abstract fun bindCategoryRepository(impl: CategoryRepositoryImpl): CategoryRepository

    @Singleton
    @Binds
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository

    @Singleton
    @Binds
    abstract fun bindRecipeRepository(impl: RecipeRepositoryImpl): RecipeRepository
}
