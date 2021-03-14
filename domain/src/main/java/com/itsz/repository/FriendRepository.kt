package com.itsz.repository

import com.itsz.model.Girl
import com.itsz.usecase.GetGirlFriendUseCase

/**
 * @author itsZ
 * 抽象业务接口
 */
interface FriendRepository {

    suspend fun newGirlFriend(request: GetGirlFriendUseCase.GirlRequest): Girl
}