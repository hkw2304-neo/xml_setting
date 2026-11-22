package com.hkw.a1016_socialservice.data

import android.util.Log
import com.google.gson.Gson


data class sampleModel(
    val item: String,
    val count: Int
)
data class parentModel(
    val item: String,
    val child: sampleModel
)

object SampleData {
    val sampleData = mapOf(
        "section1" to mapOf(
            "tesst1" to "apple"
        )
    )
    val sampleData1 = mapOf(
        "section1" to mapOf(
            "test1" to "apple1",
            "test2" to "apple2"
        ),
        "section2" to mapOf(
            "test3" to "apple3",
            "test4" to "apple4"
        )
    )

    val test = listOf(sampleModel("test",1))
    val test2 = listOf(parentModel("test1", sampleModel("test",1)))
    fun show(){
        val test = Gson().toJson(test)

        var test3 = emptyList<sampleModel>()
        repeat(4){
            test3 += listOf(sampleModel("test",it))
        }
    }

}