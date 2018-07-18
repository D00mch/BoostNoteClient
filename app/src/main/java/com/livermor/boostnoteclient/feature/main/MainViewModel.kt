package com.livermor.boostnoteclient.feature.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.delegateadapter.delegate.diff.IComparableItem
import com.livermor.boostnoteclient.model.NoteItem

/**
 * @author dumchev on 19.07.2018.
 */
class MainViewModel : ViewModel() {

    private val mutableLiveData: MutableLiveData<List<IComparableItem>> = MutableLiveData()
    val liveData: LiveData<List<IComparableItem>> = mutableLiveData

    init {
        updateNotes()
    }

    private fun updateNotes() {
        Thread {
            val notes = getMockNotes()
            mutableLiveData.postValue(notes)
        }.start()
    }

    private fun getMockNotes(): List<IComparableItem> {

        return (1..10).map { i ->
            val (code, name) = if (i % 2 == 0) {
                """
                    # change this value for a different result
                    num = $i

                    # uncomment to take input from the user
                    #num = int(input("Enter a number: "))

                    if num < 0:
                       print("Enter a positive number")
                    else:
                       sum = 0
                       # use while loop to iterate un till zero
                       while(num > 0):
                           sum += num
                           num -= 1
                       print("The sum is",sum)
                """ to "Python"
            } else {
                """
                    public static final String CONST = "SOME_CONST";

                    public static void main(String[] args) {
                        // initialize some value;
                        final int i = $i;
                        // print some code
                        System.out.println("number i");
                    }""" to "Java"
            }

            NoteItem(
                    id = i.toString(),
                    title = "Some $name program",
                    text = code.trimIndent()
            )
        }
    }
}