package com.example.inventory

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inventory.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.progressBar.visibility = View.VISIBLE
        ApiCall().getItems(this) { items ->
            binding.progressBar.visibility = View.GONE
//            val groupedItems: MutableList<GroupedItems> = mutableListOf()
//            for (item in items) {
//                  val itemList : MutableList<ItemList> = mutableListOf()
//                  val groupedItem = GroupedItems(item.listId, itemList)
//                  groupedItem.itemList?.add(ItemList(item.id,item.name))
//                  if ( groupedItems.any{it.listId == item.listId})
//                  { groupedItems.find { it.listId == item.listId }?.itemList?.add(ItemList(item.id,item.name))}
//                  else groupedItems.add(groupedItem)
//            }
            binding.recyclerview.layoutManager = LinearLayoutManager(this)
            val adapter = Adapter( this, items.filter{ it.name != null && it.name != "" }.sortedWith(
                compareBy<Item> { it.listId }.thenBy { it.name })
            )
            binding.recyclerview.adapter = adapter
        }


    }
}