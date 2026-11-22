package com.hkw.a1016_socialservice.di

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

/*
@Inject constructor()
주입할 시 힐트가 해당 클래스를 만드는 방법을 명시
 */
@Singleton
class TestData @Inject constructor() {

    val test = "11"

    fun show(){
        val smaple = "test"
        Log.d("ddd","test:$test")
    }
}