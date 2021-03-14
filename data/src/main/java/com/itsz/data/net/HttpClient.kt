package com.itsz.data.net

import com.itsz.data.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author itsZ
 * 网络请求的配置
 */
class HttpClient private constructor(){

    companion object {
        private const val BASE_URL = "https://api.github.com/"

        fun getInstance(): HttpClient {
            return Holder.INSTANCE
        }
    }

    private object Holder {
        val INSTANCE = HttpClient()
    }

    private val retrofit: Retrofit by lazy {
        createRetrofit()
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(createOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(/*mGson*/))
            .build()
    }

    /**
     * 生成接口实例
     */
    fun <T> createService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }


    private fun createOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                enableDebugTools()
            }
//            addInterceptor(HttpHeaderInterceptor(sp))
            updateTimeout()
        }
            .build()


    private fun OkHttpClient.Builder.enableDebugTools() {
        addNetworkInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
//        addNetworkInterceptor(StethoInterceptor())
    }

    private fun OkHttpClient.Builder.updateTimeout(
        connect: Long = 20,
        read: Long = 20,
        write: Long = 20
    ) {
        connectTimeout(connect, TimeUnit.SECONDS)
        readTimeout(read, TimeUnit.SECONDS)
        writeTimeout(write, TimeUnit.SECONDS)
    }

}