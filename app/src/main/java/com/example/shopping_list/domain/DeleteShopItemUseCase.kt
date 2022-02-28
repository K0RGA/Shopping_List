package com.example.shopping_list.domain

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun deleteShopItem(shopItemId: Int){
        shopListRepository.deleteShopItem(shopItemId)
    }
}