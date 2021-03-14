package com.itsz.usecase

import com.itsz.BaseRequest
import com.itsz.ToolTips
import com.itsz.model.Girl
import com.itsz.repository.FriendRepository

/**
 * @author itsZ
 * 具体的业务
 */
class GetGirlFriendUseCase(
    private val friendRepository: FriendRepository,
    toolTips: ToolTips? = null
) : CoroutineUseCase<GetGirlFriendUseCase.GirlRequest, Girl>(toolTips = toolTips) {

    override suspend fun execute(parameters: GirlRequest): Girl {
        return friendRepository.newGirlFriend(parameters)
    }


    /**
     * 入参
     */
    data class GirlRequest(var age: Int) : BaseRequest()
}