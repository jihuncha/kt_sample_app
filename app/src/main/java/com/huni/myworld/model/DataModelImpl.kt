package com.huni.myworld.model

import com.huni.myworld.R
import com.huni.myworld.model.enum.KakaoSearchSortEnum
import com.huni.myworld.model.response.ImageSearchResponse
import com.huni.myworld.model.service.KakaoSearchService
import io.reactivex.rxjava3.core.Single

class DataModelImpl(private val service: KakaoSearchService):DataModel{

    private val KAKAO_APP_KEY: String = "5a17a924eca098dbed22e0a1091f0c69"

    override fun getData(query:String, sort: KakaoSearchSortEnum, page:Int, size:Int): Single<ImageSearchResponse> {
        return service.searchImage(auth = "KakaoAK $KAKAO_APP_KEY", query = query, sort = sort.sort, page = page, size = size)
    }
}