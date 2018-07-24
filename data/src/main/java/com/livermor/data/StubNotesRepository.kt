package com.livermor.data

import com.livermor.contract.data.NotesRepository
import com.livermor.contract.model.Note
import io.reactivex.Observable

/**
 * @author dumchev on 23.07.2018.
 */
class StubNotesRepository : NotesRepository {

    override fun allNotes(): Observable<List<Note>> {

        val list: List<Note> = (1..10).map { i ->
            val (code, lang) = if (i % 2 == 0) {
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
                """ to "python"
            } else {
                """
                    public static final String CONST = "SOME_CONST";

                    public static void main(String[] args) {
                        // initialize some value;
                        final int i = $i;
                        // print some code
                        System.out.println("number i");
                    }""" to "java"
            }

            Note(
                    id = i.toString(),
                    title = "Some $lang program",
                    text = code.trimIndent(),
                    lang = lang
            )
        }
        return Observable.just(list)
    }
}