package com.livermor.contract.model

import java.util.*

/**
 * @author dumchev on 23.07.2018.
 */
data class Note(
        val id: String,
        val title: String,
        val content: String,
        val lang: String,
        val color: String?,
        val createdAt: Date,
        val updatedAt: Date
)

data class Folder(
        val color: String?,
        val createdAt: Date,
        val updatedAt: Date
)
