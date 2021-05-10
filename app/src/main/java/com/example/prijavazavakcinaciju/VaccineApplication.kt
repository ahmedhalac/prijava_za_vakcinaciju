package com.example.prijavazavakcinaciju

import android.app.Application
import timber.log.Timber

class VaccineApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}