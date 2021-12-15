package io.artem.testtvapplicationkotlin

import android.os.Bundle
import android.util.Log
import androidx.leanback.app.BrowseSupportFragment
import androidx.recyclerview.widget.RecyclerView

class JokesFragment : BrowseSupportFragment(){

    var jokes: ArrayList<JokeModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Список анеков"


    }



    internal fun setJokeContent(response: JokeModel){
        val recycler = view?.findViewById(R.id.posts_recycle_view) as RecyclerView
        Log.w("Response tag",response.toString())
        jokes.add(response)
        Log.w("Jokes tag",jokes.toString())
        val adapter = JokeAdapter(jokes)
        Log.w("Adapter tag",adapter.toString())
        recycler.setAdapter(adapter)

        //imageDrawable
        //setDefaultBackground(TRANSLUCENT)
        /*buttonText = resources.getString(R.string.dismiss_error)
        buttonClickListener = View.OnClickListener {
            fragmentManager!!.beginTransaction().remove(this@ErrorFragment).commit()*/
    }

    companion object {
        private val TRANSLUCENT = true
    }
}