package com.example.inventory

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    var id: String,
    var listId: String,
    var name: String

): Parcelable

//data class GroupedItems(
//    var listId: String,
//    var itemList: MutableList<ItemList>? = mutableListOf()
//)
//data class ItemList(
//    var id: String,
//    var name: String
//)
