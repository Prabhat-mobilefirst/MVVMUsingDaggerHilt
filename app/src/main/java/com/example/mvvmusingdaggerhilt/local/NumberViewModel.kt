package com.example.mvvmusingdaggerhilt.local


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmusingdaggerhilt.local.response.NumberResponse
import com.example.mvvmusingdaggerhilt.util.Event
import com.example.mvvmusingdaggerhilt.util.Result
import com.example.mvvmusingdaggerhilt.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NumberViewModel @Inject constructor(
    private val repo: NumberRepo
//    private val zomatoRepo: ZomatoRepo
) : ViewModel() {


    //live data
    private val _fact = MutableLiveData<Event<Result<NumberResponse>>>()
    val fact: LiveData<Event<Result<NumberResponse>>> = _fact

    fun getNumberFact(number: Int) = viewModelScope.launch {
        _fact.postValue(Event(Result(Status.LOADING, null, null)))
        _fact.postValue(Event(repo.getNumberFact(number)))

    }

    //zomato live data
    /*    private val _zomato = MutableLiveData<Event<Result<DataItem>>>()
        val zomato: LiveData<Event<Result<DataItem>>> = _zomato

        fun getZomato() = viewModelScope.launch {
            _zomato.postValue(Event(Result(Status.LOADING, null, null)))
            _zomato.postValue(Event(zomatoRepo.getZomato()))
        }*/
}