package com.livermor.boostnoteclient.model

import android.os.Parcelable
import com.example.delegateadapter.delegate.diff.IComparableItem
import kotlinx.android.parcel.Parcelize

/**
 * @author dumchev on 19.07.2018.
 */
@Parcelize
data class NoteItem(
        val id: String,
        val title: String,
        val text: String
) : IComparableItem, Parcelable {

    override fun id(): Any = id

    override fun content(): Any = this
}