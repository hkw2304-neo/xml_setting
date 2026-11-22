package com.hkw.a1016_socialservice.ui.screen.viewmodel

import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.hkw.a1016_socialservice.R
import com.hkw.a1016_socialservice.data.SampleData
import com.hkw.a1016_socialservice.di.TestData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class ContainterViewState(
    val test: String = "컨테이너 뷰모델",
    val visibleNav: List<Int> = listOf(R.id.mainFragment, R.id.dashboardFragment,R.id.featureFragment),
    val photoUri: Uri? = null,
   val testArr:List<String> = emptyList()
)
@HiltViewModel
class ContainterViewModel  @Inject constructor(
    private val _test: TestData
): ViewModel() {

    private val _state = MutableStateFlow(ContainterViewState())
    val state = _state.asStateFlow()


    init{
        val test5 = _test.test

        Log.d("ContainterViewMot", "ContainterViewModel created : $test5")
        Log.d("ContainterViewModel", "ContainterViewModel created")
        SampleData.show()

        val sampleList:List<String> = listOf("test1","test12","test3","test4",)
        val sampleMap = sampleList.mapIndexed { index, string ->
            index to string
        }.toMap()

        val test2map = mapOf(
            "www" to "www"
        )

        val filetertemp =sampleList.filter{
            it.contains("1")
        }

        filetertemp.forEach {
            Log.d("filter", it)
        }




        test2map.map{

        }

        // forEach는 매개변수가 하나라서 () 묶어서 보내준다(구조분해할당)
        sampleMap.forEach { (i, string) ->
            Log.d("test map", "$i : $string")
        }

        val map2 = sampleMap.map{
            it.key to it.value + "map update"
        }.toMap()

        map2.forEach {
            Log.d("map2", it.value)
        }

        _state.update{
            it.copy(
                testArr = it.testArr + sampleList
            )
        }

        _state.value.testArr.forEachIndexed { index, value ->
            Log.d("test arr", " >> $value : $index")
        }





    }

    fun setPhotoUri(uri: Uri){
        _state.update{
            it.copy(
                photoUri = uri
            )
        }
    }
    fun changeText(){
        _state.update{
            it.copy(
                test = "change test"
            )
        }
    }

}