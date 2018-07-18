package com.livermor.boostnoteclient

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData

/**
 * @author dumchev on 19.07.2018.
 */
inline fun <T> LiveData<T>.bind(owner: LifecycleOwner, crossinline observer: (t: T) -> Unit) {
    this.observe(owner, android.arch.lifecycle.Observer { it?.let(observer) })
}