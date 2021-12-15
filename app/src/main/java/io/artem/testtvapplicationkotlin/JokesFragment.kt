package io.artem.testtvapplicationkotlin

import android.icu.lang.UCharacter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.leanback.app.BrowseSupportFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class JokesFragment : Fragment(){

    var jokes: ArrayList<JokeModel> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.w("Time tag","Creating fragment")
        super.onCreate(savedInstanceState)
        //Log.w("Time tag","Setting title")
        //title = "Список анеков"


    }



     fun setJokeContent(response: JokeModel){
        Log.w("Time tag","Entered the setJokeContent")
        val recycler = view?.findViewById(R.id.posts_recycle_view) as RecyclerView
        Log.w("Time tag","Created recycler")
        val manager = LinearLayoutManager(context)
        Log.w("Time tag","Created LinearLayoutManager")
       // recycler.layoutManager = manager
        Log.w("Time tag","Set manager to recycler")
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