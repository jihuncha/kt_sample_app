package com.huni.myworld.model

import com.huni.myworld.model.enum.KakaoSearchSortEnum
import com.huni.myworld.model.response.ImageSearchResponse
import io.reactivex.rxjava3.core.Single

interface DataModel {
    fun getData(query:String, sort: KakaoSearchSortEnum, page:Int, size:Int): Single<ImageSearchResponse>
}

//class DataModelImpl: DataModel{
//    override fun getData() {
//        return
//    }
//}