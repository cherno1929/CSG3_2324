package com.example.myapplication

import android.app.Application
import android.media.MediaPlayer
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner

class myapp : Application(), LifecycleObserver {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)

        mediaPlayer = MediaPlayer.create(this, R.raw.cancion)
        mediaPlayer?.isLooping = true
        mediaPlayer?.setVolume(1.0f, 1.0f)
    }

    fun setVolume(v: Float){
        mediaPlayer?.setVolume(v, v)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onAppBackgrounded() {
        Logger.log("APP BACKGROUNDED")
        mediaPlayer?.pause()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onAppForegrounded() {
        Logger.log("APP FOREGROUNDED")
        mediaPlayer?.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onAppDestroyed() {
        Logger.log("APP DESTROYED")
        mediaPlayer?.stop()
        mediaPlayer?.release()
    }

    object Logger {
        fun log(message: String) {
            Log.d("Logger", message)
        }
    }
}