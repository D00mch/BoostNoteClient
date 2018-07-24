package com.livermor.boostnoteclient.model

import android.os.Parcelable
import com.livermor.contract.model.Note
import com.example.delegateadapter.delegate.diff.IComparableItem
import kotlinx.android.parcel.Parcelize

/**
 * @author dumchev on 19.07.2018.
 */
@Parcelize
data class NoteUi(
        val id: String,
        val title: String,
        val text: String,
        val lang: String
) : IComparableItem, Parcelable {

    override fun id(): Any = id

    override fun content(): Any = this

    companion object {
        fun from(note: Note): NoteUi = with(note) {
            NoteUi(id, title, text, lang)
        }
    }
}