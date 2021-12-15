package io.artem.testtvapplicationkotlin

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.os.Build
import android.text.Html
import android.view.View
import android.widget.TextView

internal class PostAdapter(posts: List<PostModel>?) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    private val posts: List<PostModel>?
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post: PostModel = posts!![position]
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.post.text = Html.fromHtml(post.elementPureHtml, Html.FROM_HTML_MODE_LEGACY)
        } else {
            holder.post.text = Html.fromHtml(post.elementPureHtml)
        }
    }

    override fun getItemCount(): Int {
        return posts?.size ?: 0
    }

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var post: TextView

        init {
            post = itemView.findViewById(R.id.post)
        }
    }

    init {
        this.posts = posts
    }
}