package com.itsz.data.service

import com.itsz.data.net.dto.GirlJson
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * @author itsZ
 * WebService API
 */
interface GirlService {

    @GET
    suspend fun getGirlFriend(
        @Url url: String = "https://gank.io/api/v2/data/category/Girl/type/Girl/page/1/count/10"
    ): GirlJson
}