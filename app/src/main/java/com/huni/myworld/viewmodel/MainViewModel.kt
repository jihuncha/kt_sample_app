package com.huni.myworld.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.huni.myworld.base.BaseKotlinViewModel
import com.huni.myworld.model.DataModel
import com.huni.myworld.model.enum.KakaoSearchSortEnum
import com.huni.myworld.model.response.ImageSearchResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

//여태까지 제가 말씀드린 것과는 다르게 언더바로 시작하는 변수와 그렇지 않은 변수가 서로 쌍으로 붙어있습니다.
//이것은 외부에서는 Livedata를 변경하지 못하게 하고, 내부에서는 변경이 가능하게 하기 위한 구현입니다
//저런식으로 구현을 하게 되면, ViewModel에서는 _image.....LiveData.postValue()로 데이터를 변경할 수 있게 되고,
//image....LiveData로 언더바가 없는 변수를 외부에서 참조함으로서 postValue는 수행하지 못하고 observe만 가능하게 한 것이죠.
//
//
//그럼 이제 아시겠지만, 이 코드는 결국 네트워크로 데이터를 받아서 LiveData의 값을 postValue로 바꿔주고 있는 것입니다.
//그럼 이 LiveData를 View에서는 Observing함으로써 값의 변경을 알아차릴수 있게 되는것이죠.
//
//이제 아까 앞에서 넘어갔던 setValue와 postValue의 차이점을 서술해보겠습니다.
//만약 setValue나 postValue를 호출하는 당사자가 UI스레드일경우, 둘은 차이가 없습니다.
//그런데 만약 UI스레드가 아닐경우, setValue로 세팅한 값은 UI를 변경하지 못합니다.
//대신 postValue로 세팅한 값은 해당 값을 UI스레드로 post해주기 때문에 UI스레드가 아니라도 UI를 변경할 수 있게 됩니다.


class MainViewModel(private val model:DataModel): BaseKotlinViewModel() {
    private val TAG : String = MainViewModel::class.java.simpleName

    private val _imageSearchResponseLiveData = MutableLiveData<ImageSearchResponse>()
    val imageSearchResponseLiveData: LiveData<ImageSearchResponse>
        get() = _imageSearchResponseLiveData

    fun getImageSearch(query: String, page:Int, size:Int) {
        addDisposable(model.getData(query, KakaoSearchSortEnum.Accuracy, page, size)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.run {
                    if (documents.size > 0) {
                        Log.d(TAG, "documents : $documents")
                        _imageSearchResponseLiveData.postValue(this)
                    }
                    Log.d(TAG, "meta : $meta")
                }
            }, {
                Log.e(TAG, "response error, message : ${it.message}")
            }))
    }
}