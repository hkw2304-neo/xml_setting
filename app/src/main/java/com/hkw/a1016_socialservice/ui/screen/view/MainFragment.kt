package com.hkw.a1016_socialservice.ui.screen.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.hkw.a1016_socialservice.databinding.MainFragmentBinding
import com.hkw.a1016_socialservice.ui.screen.viewmodel.ContainterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import kotlin.time.Duration.Companion.milliseconds


@AndroidEntryPoint
class MainFragment : Fragment(){

    private var _binding: MainFragmentBinding? = null
    val binding get() = _binding!!
    private val viewModel: ContainterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 별도 선언안하면 포그라운드에서 작업
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            Log.d("where thread1" , Thread.currentThread().name)
        }
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            Log.d("where thread2" , Thread.currentThread().name)
        }

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Default) {
            Log.d("where thread3" , Thread.currentThread().name)
        }

        // 비동기로 시작되서 안기달리고 3-1-2 찍힌다
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){

                Log.d("delay", "delay one1")
                delay(2000.milliseconds)
                Log.d("delay", "delay one2")
            }
        }
        Log.d("delay", "delay one3")


        Log.d("MainFragment", viewModel.state.value.test)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}