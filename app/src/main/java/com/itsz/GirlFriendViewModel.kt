package com.itsz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.itsz.aaf.InjectUtils
import com.itsz.data.ToastToolTips
import com.itsz.usecase.GetGirlFriendUseCase

/**
 * @author itsZ
 */
class GirlFriendViewModel : ViewModel() {

    private val girlRepository = InjectUtils.getGirlRepo()

    fun getGirlFriend() =
        liveData {
            val girlRequest = GetGirlFriendUseCase.GirlRequest(18)
            val result = GetGirlFriendUseCase(girlRepository,ToastToolTips()).invoke(girlRequest)
            emit(result)
        }

}