package com.example.databind.data.api.NetworkUtils

import java.util.*

class ResourceKt<out T>(val status: Status, val data: T?, val message: String?, val fetchStatus: FetchStatus, val error: Throwable?=null, val serverTime: Date?=null) {

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }

        val resource = o as ResourceKt<*>?

        if (status !== resource!!.status) {
            return false
        }
        if (if (message != null) message != resource!!.message else resource!!.message != null) {
            return false
        }
        return if (data != null) data == resource.data else resource.data == null
    }

    override fun toString(): String {
        return "Resource{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}'
    }

    companion object {
        private var fetchStatus = FetchStatus()

        fun <T> success(data: T?, serverTime: Date?=null): ResourceKt<T> {
            fetchStatus = FetchStatus(false, true, false, false)
            return ResourceKt(Status.SUCCESS, data, null, fetchStatus, null, serverTime)
        }

        fun <T> error(msg: String, data: T?, error: Throwable?): ResourceKt<T> {
            fetchStatus = FetchStatus(false, false, true, true)
            return ResourceKt(Status.ERROR, data, msg, fetchStatus, error = error)
        }

        fun <T> loading(data: T?, nextPage: Int?): ResourceKt<T> {
            fetchStatus = FetchStatus(true, false, false, false)
            return ResourceKt(Status.LOADING, data, null, fetchStatus)
        }
    }


    fun setOnLast(): FetchStatus {
        return FetchStatus(false, true, false, false)
    }
}
