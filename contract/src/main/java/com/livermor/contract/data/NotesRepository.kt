package com.livermor.contract.data

import com.livermor.contract.model.Note
import io.reactivex.Observable

/**
 * @author dumchev on 23.07.2018.
 */
interface NotesRepository {

    fun allNotes(): Observable<List<Note>>
}