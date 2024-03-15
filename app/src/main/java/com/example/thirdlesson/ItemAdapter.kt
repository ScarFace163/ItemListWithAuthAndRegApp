package com.example.thirdlesson

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(var items : List<Item>, var context : Context) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val name : TextView = view.findViewById(R.id.itemName)
        val description : TextView = view.findViewById(R.id.itemDescr)
        val image : ImageView = view.findViewById(R.id.itemImage)
        val price : TextView = view.findViewById(R.id.itemPrice)
        val button:Button = view.findViewById(R.id.itemButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = items[position].name
        holder.description.text = items[position].descr
        holder.price.text = items[position].price.toString()

        val imageId = context.resources.getIdentifier(
            items[position].title,
            "drawable",
            context.packageName)
        holder.image.setImageResource(imageId)

        holder.button.setOnClickListener {
            val intent = Intent(context, item_activity::class.java)

            intent.putExtra("itemName", items[position].name)
            intent.putExtra("itemText", items[position].text)
            intent.putExtra("itemImage", imageId)


            context.startActivity(intent)
        }
    }
}