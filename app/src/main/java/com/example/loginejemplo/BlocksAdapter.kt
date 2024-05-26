package com.example.loginejemplo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BlocksAdapter(private val blocks: List<Block>, private val listener: OnItemClickListener) : RecyclerView.Adapter<BlocksAdapter.BlockViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class BlockViewHolder(itemView: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val imagenBlock: ImageView = itemView.findViewById(R.id.imagen)
        val nombreBlock: TextView = itemView.findViewById(R.id.materia)
        val descriptionBlock: TextView = itemView.findViewById(R.id.promedio)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlockViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_block, parent, false)
        return BlockViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: BlockViewHolder, position: Int) {
        val block = blocks[position]
        holder.imagenBlock.setImageResource(block.imageResId)
        holder.nombreBlock.text = block.text
        holder.descriptionBlock.text = block.text2
    }

    override fun getItemCount(): Int = blocks.size
}

