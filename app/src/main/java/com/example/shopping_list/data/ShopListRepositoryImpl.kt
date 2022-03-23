package com.example.shopping_list.data

import com.example.shopping_list.domain.ShopItem
import com.example.shopping_list.domain.ShopListRepository

object ShopListRepositoryImpl: ShopListRepository {

    private var shopList = mutableListOf<ShopItem>()

    var autoIncrementId = 0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) shopItem.id = autoIncrementId++
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldShopItem = getShopItem(shopItem.id)
        shopList.remove(oldShopItem)
        addShopItem(shopItem)
    }

    //если что убрать !!, а то хуйня поулчается
    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId }!!
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toMutableList()
    }
}