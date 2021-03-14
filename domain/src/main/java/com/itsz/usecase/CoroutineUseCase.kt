package com.itsz.usecase

import com.itsz.BaseRequest
import com.itsz.Result
import com.itsz.ToolTips
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author itsZ
 */
abstract class CoroutineUseCase<in P : BaseRequest, Response>(
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val toolTips: ToolTips? = null
) {

    suspend operator fun invoke(parameters: P): Result<Response> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters).let { r ->
                    Result.Success(r)
                }
            }
        } catch (e: Exception) {
            if (shouldShowNotification()) {
                val cause = e.cause?.toString()
                toolTips?.toastTip(cause)
            }
            Result.Failure(e)
        }
    }

    protected abstract suspend fun execute(parameters: P): Response

    open fun shouldShowNotification() = true

}