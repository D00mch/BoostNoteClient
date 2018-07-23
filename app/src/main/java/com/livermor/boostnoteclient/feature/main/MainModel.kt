package com.livermor.boostnoteclient.feature.main

import com.livermor.boostnoteclient.model.NoteUi

/**
 * @author dumchev on 23.07.2018.
 */
data class MainModel(
        val notes: List<NoteUi>,
        val isLoading: Boolean = false
        // some more data to show
)