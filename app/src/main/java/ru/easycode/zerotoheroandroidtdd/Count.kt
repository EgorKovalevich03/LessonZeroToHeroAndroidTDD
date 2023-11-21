package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun increment(number: String) : UiState


    class Base(private val step:Int, private val max:Int):Count{

        init {
            if(step<1) throw IllegalStateException("step should be positive, but was $step")
            if(max<1) throw IllegalStateException("max should be positive, but was $max")
            if(max<step) throw IllegalStateException("max should be more than step")
        }

        override fun increment(number: String): UiState {
            val digits = number.toInt()
            val res = digits + step
            return if(res+step <= max){
                UiState.Base(res.toString())
            } else {
                UiState.Max(res.toString())
            }
        }

    }
}