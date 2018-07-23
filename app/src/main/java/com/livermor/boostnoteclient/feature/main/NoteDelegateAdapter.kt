package com.livermor.boostnoteclient.feature.main

import com.example.delegateadapter.delegate.KDelegateAdapter
import com.livermor.boostnoteclient.model.NoteUi
import com.livermor.boostnoteclient.R
import kotlinx.android.synthetic.main.item_note.*

/**
 * @author dumchev on 19.07.2018.
 */
class NoteDelegateAdapter(private val onClick: (NoteUi) -> Unit) : KDelegateAdapter<NoteUi>() {

    override fun getLayoutId(): Int = R.layout.item_note

    override fun isForViewType(list: MutableList<*>, i: Int): Boolean = list[i] is NoteUi

    override fun onBind(item: NoteUi, viewHolder: KViewHolder) = with(viewHolder) {
        itemView.setOnClickListener { onClick(item) }
        tvTitle.text = item.title
        tvText.text = item.text
    }
}