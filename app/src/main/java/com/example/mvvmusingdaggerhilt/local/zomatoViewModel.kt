package com.example.mvvmusingdaggerhilt.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmusingdaggerhilt.local.response.DataItem
import com.example.mvvmusingdaggerhilt.util.Event
import com.example.mvvmusingdaggerhilt.util.Result
import com.example.mvvmusingdaggerhilt.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class zomatoViewModel @Inject constructor(
    private val zomatoRepo: ZomatoRepo
) :ViewModel(){

    //zomato live data
    private val _zomato = MutableLiveData<Event<Result<DataItem>>>()
    val zomato: LiveData<Event<Result<DataItem>>> = _zomato

    fun getZomato() = viewModelScope.launch {
        _zomato.postValue(Event(Result(Status.LOADING, null, null)))
        _zomato.postValue(Event(zomatoRepo.getZomato()))
    }
}