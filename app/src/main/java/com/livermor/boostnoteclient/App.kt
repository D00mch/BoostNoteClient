package com.livermor.boostnoteclient

import android.app.Application
import io.github.kbiakov.codeview.classifier.CodeProcessor

/**
 * @author dumchev on 19.07.2018.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        CodeProcessor.init(this)
    }
}