package com.itsz.aaf

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.itsz.GirlFriendViewModel
import com.itsz.doFailure
import com.itsz.doOnSuccess

/**
 * @author itsZ
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val girlFriendViewModel:GirlFriendViewModel  by viewModels()

        girlFriendViewModel.getGirlFriend().observe(this, Observer { result ->
            result.doFailure {
                Log.d("doFailure", "onCreate: $it")
            }
            result.doOnSuccess {
                Log.d("doOnSuccess", "onCreate: $it")
            }
        })
    }
}



