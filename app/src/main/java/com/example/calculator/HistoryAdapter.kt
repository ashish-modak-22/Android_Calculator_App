package com.example.calculator


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter(
    private val historyList: List<HistoryModel>     // List of history items to be displayed
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    // Creating the view holder: It holds the reference to the views inside each item card
    inner class HistoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvExpression: TextView = itemView.findViewById(R.id.tvHistoryExpression)
        val  tvResult: TextView = itemView.findViewById(R.id.tvHistoryResult)
    }

    // This function will inflate the item_history.xml file and wraps it in a ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return HistoryViewHolder(view)
    }

    // This function will bind actual data from historyList into the card views
    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item = historyList[position]

        holder.tvExpression.text = item.expression
        holder.tvResult.text = "= ${item.result}"
    }

    // Counting the number of items inside the list
    override fun getItemCount(): Int = historyList.size
}