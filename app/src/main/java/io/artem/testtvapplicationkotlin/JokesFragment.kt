package io.artem.testtvapplicationkotlin

import android.icu.lang.UCharacter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.leanback.app.BrowseSupportFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class JokesFragment : Fragment(){


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.w("Time tag","Creating fragment")
        super.onCreate(savedInstanceState)
        //Log.w("Time tag","Setting title")
        //title = "Список анеков"


    }



     fun setJokeContent(response: JokeModel, manager: LinearLayoutManager?){
        Log.w("Time tag","Entered the setJokeContent")
         var jokes: ArrayList<JokeModel> = ArrayList()
        Log.w("Time tag","Created recycler")
         val recycler = view?.findViewById(R.id.posts_recycle_view) as? RecyclerView
        recycler?.layoutManager = manager
        Log.w("Time tag","Set manager to recycler")
        Log.w("Response tag",response.toString())
        jokes.add(response);
        Log.w("Jokes tag",jokes.toString())

        val jokeAdapter = JokeAdapter(jokes)
         jokeAdapter.notifyDataSetChanged()
        Log.w("Adapter tag",jokeAdapter.itemCount.toString())
        recycler?.adapter = jokeAdapter
         Log.w("Recycler adapter tag", recycler?.adapter.toString())
        //setDefaultBackground(TRANSLUCENT)
        /*buttonText = resources.getString(R.string.dismiss_error)
        buttonClickListener = View.OnClickListener {
            fragmentManager!!.beginTransaction().remove(this@ErrorFragment).commit()*/
    }

    companion object {
        private val TRANSLUCENT = true
    }
}