package com.livermor.boostnoteclient.feature.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.livermor.boostnoteclient.log
import com.livermor.boostnoteclient.model.NoteUi
import com.livermor.contract.data.NotesRepository
import com.livermor.data.StubNotesRepository
import io.reactivex.disposables.CompositeDisposable

/**
 * @author dumchev on 19.07.2018.
 */
class MainViewModel : ViewModel() {

    // todo: provide with some DI
    private val notesRepository: NotesRepository = StubNotesRepository()

    private val disposables: CompositeDisposable = CompositeDisposable()
    private val mutableLiveData: MutableLiveData<MainModel> = MutableLiveData()
    val liveData: LiveData<MainModel> = mutableLiveData

    init {
        updateNotes()
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    private fun updateNotes() {
        notesRepository.allNotes()
                .flatMapIterable { it }
                .map { note -> NoteUi.from(note) }
                .toList()
                .map { notes -> MainModel(notes) }
                .subscribe(mutableLiveData::postValue, Throwable::log)
                .let { disposables.add(it) }
    }
}