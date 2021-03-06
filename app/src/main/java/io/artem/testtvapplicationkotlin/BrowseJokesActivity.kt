package io.artem.testtvapplicationkotlin

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.artem.testtvapplicationkotlin.RetrofitClient.retrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


 class BrowseJokesActivity : FragmentActivity() {

    private lateinit var mJokesFragment: JokesFragment
    var manager: LinearLayoutManager? = null
     var recycler: RecyclerView? = null
     var jokes: ArrayList<JokeModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.w("Time tag","Setting content view")
        setContentView(R.layout.jokes_recycle_view)
         recycler = findViewById(R.id.posts_recycle_view)
        recycler?.layoutManager = LinearLayoutManager(this)
       /* if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.posts_recycle_view, MainFragment())
                .commitNow()
        }*/
        Log.w("Time tag","Calling testJokes")
        manager = LinearLayoutManager(this)
        testJokes()
    }

     private fun testJokes(){
         Log.w("Time tag","Creating fragment in Activity")
        mJokesFragment = JokesFragment()
         Log.w("Time tag","Fragment created")
             supportFragmentManager.beginTransaction().add(R.id.posts_recycle_view, mJokesFragment).commit()
        val handler = Handler()
         Log.w("Time tag","Handler post delayed")
        handler.postDelayed({
            getJokes()
            //mJokesFragment.setJokeContent()
        }, TIMER_DELAY)
    }

    private fun getJokes(){
        RetrofitClient.BASE_URL = "http://rzhunemogu.ru/"
        val service = retrofitInstance!!.create(JsonApi::class.java)
        Log.w("Time tag","Retrofit instance created. Calling GET")
        val call = service.getData(1)
        call.enqueue(object : Callback<JokeModel> {
            override fun onResponse(call: Call<JokeModel>, response: Response<JokeModel>) {
                Log.w("Time tag","GET successful. Calling the setJokeContent now")
               //Toast.makeText(baseContext, response.body().toString() , Toast.LENGTH_LONG).show();
                setJokeContent(response.body())
            }

            override fun onFailure(call: Call<JokeModel>, t: Throwable) {
                Toast.makeText(baseContext, t.message + "", Toast.LENGTH_LONG).show();
            }
        })
    }

     var jokesCount = 0
     fun setJokeContent(response: JokeModel?){
         Log.w("Time tag","Entered the setJokeContent")
         Log.w("Response tag",response.toString())

         response?.let { jokes.add(it) };
         if(jokesCount <3) {
             jokesCount++
             testJokes()

         }

         val jokeAdapter = JokeAdapter(jokes)
         recycler?.adapter = jokeAdapter
     }


    companion object {
        private val TIMER_DELAY = 1000L
    }
}