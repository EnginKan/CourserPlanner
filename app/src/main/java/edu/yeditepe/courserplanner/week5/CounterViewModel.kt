package edu.yeditepe.courserplanner.week5

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CounterViewModel: ViewModel() {

    private var _counter = MutableStateFlow<Int>(0)

    val counter: StateFlow<Int>
        get() = _counter.asStateFlow()

    fun decrement(){
        _counter.value--
    }

    fun increment(){
        _counter.value++
    }

}
