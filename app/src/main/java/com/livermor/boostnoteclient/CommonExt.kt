package com.livermor.boostnoteclient

import android.util.Log

/**
 * @author dumchev on 23.07.2018.
 */
inline fun <reified T> T.TAG() = T::class.java.simpleName

inline fun Throwable.log() {
    Log.e(TAG(), this.toString())
}
