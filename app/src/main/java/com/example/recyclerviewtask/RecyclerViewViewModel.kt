package com.example.recyclerviewtask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecyclerViewViewModel : ViewModel() {

    private var _photoIdList = MutableLiveData<MutableList<Int>>()
    private var _index = MutableLiveData<Int>()
    private var _adapter = MutableLiveData<PhotoAdapter>()



    val adapter: LiveData<PhotoAdapter>
        get() = _adapter
    val photoIdList: LiveData<MutableList<Int>>
        get() = _photoIdList

    val index: LiveData<Int>
        get() = _index

    init {
        _adapter.value = PhotoAdapter()
        _photoIdList.value = mutableListOf(
            R.drawable.eduardo,
            R.drawable.eduardo1,
            R.drawable.eduardo2,
            R.drawable.eduardo3)
        _index.value = 0
    }

}