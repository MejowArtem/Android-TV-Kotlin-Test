package io.artem.testtvapplicationkotlin

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView

internal class JokeAdapter(jokes: List<JokeModel>?) :
    RecyclerView.Adapter<JokeAdapter.ViewHolder>() {

    private val jokes: List<JokeModel>?
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: JokeModel = jokes!![position]
        var content: String = model.content
        content = content.replace("! -".toRegex(), "\n -")
        holder.joke.text = content
    }

    override fun getItemCount(): Int {
        return jokes?.size ?: 0
    }

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var joke: TextView

        init {
            joke = itemView.findViewById(R.id.post)
        }
    }

    init {
        this.jokes = jokes
    }
}