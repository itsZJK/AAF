package com.itsz.aaf

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.itsz.GirlFriendViewModel
import com.itsz.aaf.base.delegate.viewBinding
import com.itsz.aaf.databinding.ActivityMainBinding
import com.itsz.doFailure
import com.itsz.doOnSuccess
import com.itsz.extension.setOnDebouncedClickListener

/**
 * @author itsZ
 */
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()
    private val girlFriendViewModel: GirlFriendViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.classView.text = "Loading"
        binding.classView.setOnDebouncedClickListener {
            getGirlFriend()
        }

    }

    private fun getGirlFriend() {
        girlFriendViewModel.getGirlFriend().observe(this, Observer { result ->
            result.doFailure {
                Log.d("doFailure", "onCreate: $it")
            }
            result.doOnSuccess {
//                Log.d("doOnSuccess", "onCreate: $it")
                binding.classView.text = it.avatar
            }
        })
    }
}



