package me.gly.homework1

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SearchViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.dog_info, parent, false)
) {

    fun bind(item: ItemTemplate) {
        itemView.findViewById<TextView>(R.id.name).setText(item.getName())
        itemView.findViewById<TextView>(R.id.age).setText("Age: " + item.getAge())
        itemView.findViewById<TextView>(R.id.gender).setText("Gender: " + item.getGender())
        itemView.findViewById<TextView>(R.id.health).setText("Health: " + item.getHealth())
    }

}

class SearchAdapter : RecyclerView.Adapter<SearchViewHolder>() {

    private var items = arrayListOf<ItemTemplate>()

    //  创建 ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val viewHolder = SearchViewHolder(parent)
        viewHolder.itemView.setOnClickListener{
            val position = viewHolder.adapterPosition
            val dog = items[position]
            val intent = Intent(parent.context, DetailActivity::class.java).apply {
                putExtra("name", dog.getName())
                putExtra("gender", dog.getGender())
                putExtra("age", dog.getAge())
                putExtra("health", dog.getHealth())
                putExtra("description", dog.getDescription())
            }
            parent.context.startActivity(intent)
        }
        return viewHolder
    }

    //  更新 ViewHolder
    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(items[position])

    }

    //  控制列表项个数
    override fun getItemCount(): Int {
        return items.size
    }

    //  刷新列表项
    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(items: List<ItemTemplate>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

}