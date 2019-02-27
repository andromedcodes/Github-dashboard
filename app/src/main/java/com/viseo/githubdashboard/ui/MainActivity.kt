package com.viseo.githubdashboard.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.viseo.githubdashboard.R
import com.viseo.githubdashboard.data.responses.SearchUserResponse
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private var job: Job? = null
    private var results: SearchUserResponse? = null
    private var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this
        job = CoroutineScope(Dispatchers.IO).launch {
            //results = getData()
            withContext(Dispatchers.Main) {
                Toast.makeText(mContext, results?.totalCount.toString(), Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    // todo: this is just RAW for the moment but later on it should be moved into the view model, Api response should be
    // mapped and then passed to the view using data-binding adapters.
    private suspend fun getData(): SearchUserResponse =
        Injector.makeService()
            .lookupUsersByUsernameAsync("JakeWharton")
            .await()


    override fun onDestroy() {
        job?.cancel()
        super.onDestroy()
    }
}
