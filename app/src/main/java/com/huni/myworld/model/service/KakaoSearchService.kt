package com.huni.myworld.model.service

import com.huni.myworld.model.response.ImageSearchResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

//GET /v2/search/image HTTP/1.1
//Host: dapi.kakao.com
//Authorization: KakaoAK {REST_API_KEY}

//Parameter
//Name	Type	Description	Required
//query	String	검색을 원하는 질의어	O
//sort	String	결과 문서 정렬 방식, accuracy(정확도순) 또는 recency(최신순), 기본 값 accuracy	X
//page	Integer	결과 페이지 번호, 1~50 사이의 값, 기본 값 1	X
//size	Integer	한 페이지에 보여질 문서 수, 1~80 사이의 값, 기본 값 80	X

//Response
//meta
//Name	Type	Description
//total_count	Integer	검색된 문서 수
//pageable_count	Integer	total_count 중 노출 가능 문서 수
//is_end	Boolean	현재 페이지가 마지막 페이지인지 여부, 값이 false면 page를 증가시켜 다음 페이지를 요청할 수 있음

//documents
//Name	Type	Description
//collection	String	컬렉션
//thumbnail_url	String	미리보기 이미지 URL
//image_url	String	이미지 URL
//width	Integer	이미지의 가로 길이
//height	Integer	이미지의 세로 길이
//display_sitename	String	출처
//doc_url	String	문서 URL
//datetime	Datetime	문서 작성시간, ISO 8601
//[YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].000+[tz]

interface KakaoSearchService {
    @GET("/v2/search/image")
    fun searchImage(
        @Header("Authorization") auth:String,
        @Query("query") query:String,
        @Query("sort") sort:String,
        @Query("page") page:Int,
        @Query("size") size:Int
    ): Single<ImageSearchResponse>

//    fun sample_test( @Header("Authorization") auth:String,
//        @Query("query") query:String,
//        @Query("sort") sort:String,
//        @Query("page") page:Int,
//        @Query("size") size:Int): Call<ImageSearchResponse>
}