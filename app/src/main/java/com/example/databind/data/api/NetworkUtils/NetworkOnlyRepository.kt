package com.example.databind.data.api.NetworkUtils

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

abstract class NetworkOnlyRepository<ResultType, RequestType>
internal constructor() {

    private val result: MediatorLiveData<ResourceKt<ResultType>> = MediatorLiveData()

    init {
        result.postValue(ResourceKt.loading(null, null))
        val apiResponse = fetchService()
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            when (response?.isSuccessful) {
                true -> {
                    saveLoadedData(response.body as ResultType)
                    setValue(ResourceKt.success(response.body as ResultType?, response.serverDate))
                }
                false -> {
                    onFetchFailed(response.error)
                    setValue(ResourceKt.error(response.error.toString(), null, response.error))
                }
            }
        }

    }

    @WorkerThread
    protected abstract fun saveLoadedData(item: ResultType)

    @MainThread
    private fun setValue(newValue: ResourceKt<ResultType>) {
        result.value = newValue
    }

    fun asLiveData(): LiveData<ResourceKt<ResultType>> {
        return result
    }

    @MainThread
    protected abstract fun fetchService(): LiveData<ApiResponse<RequestType>>

    @MainThread
    protected abstract fun onFetchFailed(error: Throwable?)
}
