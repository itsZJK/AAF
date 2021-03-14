package com.itsz

/**
 *  @author itsZ
 */
sealed class Result<out T> {

  data class Success<out T>(val data: T) : Result<T>()

  data class Failure(val throwable: Throwable?) : Result<Nothing>()

  data class FeatureFailure<out T>(val errors: T) : Result<T>()

  override fun toString(): String {
    return when (this) {
      is Success<*> -> "Success[data = $data]"
      is Failure -> "Error[exception = $throwable]"
      is FeatureFailure -> "Error[exception = $errors]"
    }
  }
}

val Result<*>.succeeded: Boolean
  get() = (this is Result.Success) && data != null

val <T> Result<T>.data: T?
  get() = (this as? Result.Success)?.data

inline fun <reified T> Result<T>.doOnSuccess(success: (T) -> Unit) {
  if (succeeded) {
    success(data!!)
  }
}

inline fun <reified T> Result<T>.doFailure(failure: (Throwable?) -> Unit) {
  if (this is Result.Failure) {
    failure(throwable)
  }
}

inline fun <reified T> Result<T>.doFeatureFailure(featureError: (T) -> Unit) {
  if (this is Result.FeatureFailure) {
    featureError(errors)
  }
}