package com.android.applemarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.applemarket.databinding.MainrecyclerviewBinding

class MyAdapter(private val myItem: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
    var itemClick : ItemClick? = null

    interface LongItemClick {
        fun onLongClick(view: View, position: Int)
    }
    var longItemClick : LongItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = MainrecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            itemClick?.onClick(it, position)
        }
        holder.itemView.setOnLongClickListener {
            longItemClick?.onLongClick(it, position)
            false
        }
        holder.iconImageView.setImageResource(myItem[position].aIcon)
        holder.listTitle.text = myItem[position].aTitle
        holder.listAddress.text = myItem[position].aAddress
        holder.listPrice.text = myItem[position].aPrice.toString()
        holder.chatCount.text = myItem[position].aCommentCnt.toString()
        holder.likeCount.text = myItem[position].alikeCnt.toString()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return myItem.size
    }

    inner class Holder(val binding: MainrecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val iconImageView = binding.iconItem
        val listTitle = binding.Title
        val listAddress = binding.address
        val listPrice = binding.price
        val chatCount = binding.commentCount
        val likeCount = binding.likeCount
    }
}