package com.livermor.boostnoteclient.feature.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.delegateadapter.delegate.diff.DiffUtilCompositeAdapter
import com.livermor.boostnoteclient.R
import com.livermor.boostnoteclient.bind
import com.livermor.boostnoteclient.feature.edit.EditFragment
import com.livermor.boostnoteclient.model.NoteItem
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private val mainAdapter = DiffUtilCompositeAdapter.Builder()
            .add(NoteDelegateAdapter(this::goOnEditScreen))
            .build()


    // todo: use some router mechanics instead
    private fun goOnEditScreen(note: NoteItem) {
        supportFragmentManager.beginTransaction()
                .add(R.id.clRoot, EditFragment.instance(note))
                .addToBackStack(null)
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain.run {
            layoutManager = LinearLayoutManager(context)
            adapter = mainAdapter
        }

        viewModel.liveData.bind(this, mainAdapter::swapData)
    }
}
