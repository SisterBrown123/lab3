package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TipAdapter(
    private val tips: List<Tip>,
    private val onClick: (Tip) -> Unit
) : RecyclerView.Adapter<TipAdapter.TipViewHolder>() {

    class TipViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tipImage: ImageView = view.findViewById(R.id.tipImage)
        val dayBadge: TextView = view.findViewById(R.id.dayBadge)
        val tipTitle: TextView = view.findViewById(R.id.tipTitle)
        val tipShortDesc: TextView = view.findViewById(R.id.tipShortDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tip, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tips[position]
        val ctx = holder.itemView.context

        holder.tipImage.setImageResource(tip.imageResId)
        holder.dayBadge.text = ctx.getString(R.string.day_format, tip.dayNumber)
        holder.tipTitle.text = ctx.getString(tip.titleResId)
        holder.tipShortDesc.text = ctx.getString(tip.shortDescResId)

        holder.itemView.setOnClickListener {
            onClick(tip)
        }
    }

    override fun getItemCount(): Int {
        return tips.size
    }
}
