package com.itsz.data.repositoryImpl

import com.itsz.data.net.dto.toDomainModel
import com.itsz.data.service.GirlService
import com.itsz.model.Girl
import com.itsz.repository.FriendRepository
import com.itsz.usecase.GetGirlFriendUseCase

/**
 * @author itsZ
 * 抽象业务的具体实现
 */
class GirlFriendRepository(private val service: GirlService) : FriendRepository {

    override suspend fun newGirlFriend(request: GetGirlFriendUseCase.GirlRequest): Girl {
//        val age = request.age 有必要的话，参数从这里传入，这里仅仅做个演示
        return service.getGirlFriend(/*age*/).toDomainModel()
    }

    companion object {
        private var instance: GirlFriendRepository? = null
        fun getInstance(service: GirlService) = instance ?: synchronized(this) {
            instance ?: GirlFriendRepository(service).also {
                instance = it
            }
        }
    }
}