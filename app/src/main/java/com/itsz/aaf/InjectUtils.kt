package com.itsz.aaf

import com.itsz.data.net.HttpClient
import com.itsz.data.repositoryImpl.GirlFriendRepository
import com.itsz.data.service.GirlService
import com.itsz.repository.FriendRepository

/**
 * @author itsZ
 */
object InjectUtils {

    private val girlService: GirlService by lazy {
        HttpClient.getInstance().createService(GirlService::class.java)
    }

    fun getGirlRepo(): FriendRepository = GirlFriendRepository.getInstance(girlService)
}