package me.gly.homework1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  获取 RecyclerView 实例
        val list = findViewById<RecyclerView>(R.id.list)
        val adapter = SearchAdapter()
        //  RecyclerView 绑定 Adapter
        list.adapter = adapter
        //  RecyclerView 绑定纵向布局管理器
        list.layoutManager = LinearLayoutManager(this)

        val items = arrayListOf<ItemTemplate>()

        // 加入小狗信息
        items.add(ItemTemplate("Jack","A happy yellow dog!","Male", "2", "Healthy"))
        items.add(ItemTemplate("Tom","A happy red dog!","Female", "2", "Healthy"))
        items.add(ItemTemplate("William","A happy yellow dog!","Male", "3", "Healthy"))
        items.add(ItemTemplate("Thoma","A happy yellow dog!","Female", "1", "Healthy"))
        items.add(ItemTemplate("Kitty","A happy black dog!","Male", "3", "Healthy"))
        items.add(ItemTemplate("Lucas","A happy black dog!","Female", "2", "Blind"))
        items.add(ItemTemplate("Tim","A happy colorful dog!","Male", "4", "Healthy"))
        items.add(ItemTemplate("Wangwang","A happy white dog!","Female", "2", "Healthy"))

        adapter.updateItems(items)

        val searchEdit = findViewById<SearchEditText>(R.id.search_edit)
        searchEdit.addTextChangedListener(object : SearchEditText.Listener {
            override fun onChanged(content: String) {
                //  过滤列表项
                val filters = items.filter {
                    it.getName().contains(content)
                }
                adapter.updateItems(filters)
            }
        })

        //  点击取消按钮
        val cancel = findViewById<TextView>(R.id.cancel)
        cancel.setOnClickListener {
            finish()
        }

    }
}