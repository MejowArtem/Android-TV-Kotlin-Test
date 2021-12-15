package io.artem.testtvapplicationkotlin

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import io.artem.testtvapplicationkotlin.RetrofitClient.retrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


 class BrowseJokesActivity : FragmentActivity() {

    private lateinit var mJokesFragment: JokesFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jokes_recycle_view)
       if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.posts_recycle_view, MainFragment())
                .commitNow()
        }
        testJokes()
    }

     private fun testJokes(){
        mJokesFragment = JokesFragment()
         supportFragmentManager
             .beginTransaction()
             .add(R.id.posts_recycle_view, mJokesFragment)
             .commit()
        val handler = Handler()
        handler.postDelayed({
            getJokes()
            //mJokesFragment.setJokeContent()
        }, TIMER_DELAY)
    }

    private fun getJokes(){
        RetrofitClient.BASE_URL = "http://rzhunemogu.ru/"
        val service = retrofitInstance!!.create(JsonApi::class.java)

        val call = service.getData(1)
        call.enqueue(object : Callback<JokeModel> {
            override fun onResponse(call: Call<JokeModel>, response: Response<JokeModel>) {
               //Toast.makeText(baseContext, response.body().toString() , Toast.LENGTH_LONG).show();
                response.body()?.let { mJokesFragment.setJokeContent(it) }
            }

            override fun onFailure(call: Call<JokeModel>, t: Throwable) {
                Toast.makeText(baseContext, t.message + "", Toast.LENGTH_LONG).show();
            }
        })
    }


    companion object {
        private val TIMER_DELAY = 1000L
    }
}