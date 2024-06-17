package com.example.crud_task.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.crud_task.R


class BrandAdapter(
    private val context: Context,
    private val nameList: List<String>,
    private val imageList: List<Int>
) : BaseAdapter() {

    override fun getCount(): Int {
        return nameList.size
    }

    override fun getItem(position: Int): Any {
        return nameList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_brand, parent, false) // in the layout whole activity are not used
        val textView: TextView = view.findViewById(R.id.textView_brand)
        val imageView: ImageView = view.findViewById(R.id.imageView2)
        textView.text = nameList[position]
        imageView.setImageResource(imageList[position])
        return view
    }
}
