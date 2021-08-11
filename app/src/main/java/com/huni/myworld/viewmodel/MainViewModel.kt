package com.huni.myworld.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.huni.myworld.base.BaseKotlinViewModel
import com.huni.myworld.model.DataModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(private val model:DataModel): BaseKotlinViewModel() {
    private val TAG : String = MainViewModel::class.java.simpleName

//    private val _imageSearchResponseLiveData = MutableLiveData<ImageSearchResponse>()
//    val imageSearchResponseLiveData: LiveData<ImageSearchResponse>
//        get() = _imageSearchResponseLiveData
//
//    fun getImageSearch(query: String, page:Int, size:Int) {
//        addDisposable(model.getData(query, KakaoSearchSortEnum.Accuracy, page, size)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                it.run {
//                    if (documents.size > 0) {
//                        Log.d(TAG, "documents : $documents")
//                        _imageSearchResponseLiveData.postValue(this)
//                    }
//                    Log.d(TAG, "meta : $meta")
//                }
//            }, {
//                Log.d(TAG, "response error, message : ${it.message}")
//            }))
//    }
}