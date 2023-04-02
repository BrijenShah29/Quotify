package com.example.randomquotes_retrofit_mvvm.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.randomquotes_retrofit_mvvm.R
import com.example.randomquotes_retrofit_mvvm.models.Result

class QuoteAdapter(val context: Context, var list : List<Result>) : RecyclerView.Adapter<QuoteAdapter.QuoteAdapterViewHolder>() {

    inner class QuoteAdapterViewHolder(view : View): RecyclerView.ViewHolder(view) {

        val quoteText: TextView = view.findViewById(R.id.quoteText2)
        val quoteAuthor: TextView = view.findViewById(R.id.quoteAuthor2)

        fun bind(item: Result , context: Context) {
            quoteText.text=""
            quoteAuthor.text = ""
            quoteText.text = item.content
            quoteAuthor.text = item.author

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quote_layout, parent, false)
        return QuoteAdapterViewHolder(view)
    }


    override fun onBindViewHolder(holder: QuoteAdapterViewHolder, position: Int) {
        holder.bind(list[position], context)


    }


    override fun getItemCount(): Int {
        return list.size
    }
}