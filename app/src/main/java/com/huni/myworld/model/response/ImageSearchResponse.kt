package com.huni.myworld.model.response


//Content-Type: application/json;charset=UTF-8
//{
//    "meta": {
//    "total_count": 422583,
//    "pageable_count": 3854,
//    "is_end": false
//},
//    "documents": [
//    {
//        "collection": "news",
//        "thumbnail_url": "https://search2.kakaocdn.net/argon/130x130_85_c/36hQpoTrVZp",
//        "image_url": "http://t1.daumcdn.net/news/201706/21/kedtv/20170621155930292vyyx.jpg",
//        "width": 540,
//        "height": 457,
//        "display_sitename": "한국경제TV",
//        "doc_url": "http://v.media.daum.net/v/20170621155930002",
//        "datetime": "2017-06-21T15:59:30.000+09:00"
//    },
//    ...
//    ]
//}

//데이터 보관 목적으로 만든 data class
//프로퍼티에 대한 toString(), hashCode(), equals(), copy() 메소드를 자동으로 만들어줌

//특징
//데이터 클래스의 생성자(primary constructor)는 1개 이상의 프로퍼티를 선언되어야 합니다.
//데이터 클래스의 생성자 프로퍼티는 val 또는 var으로 선언해야 합니다.
//데이터 클래스에 abstract, open, sealed, inner 를 붙일 수 없습니다.
//클래스에서 toString(), hashCode(), equals(), copy()를 override하면, 그 함수는 직접 구현된 코드를 사용합니다.
//데이터 클래스는 상속받을 수 없습니다.

data class ImageSearchResponse (
    var documents:ArrayList<Document>,
    var meta:Meta
) {
    data class Document(
        var collection:String,
        var thumbnail_url:String,
        var image_url:String,
        var width:Int,
        var height:Int,
        var display_sitename:String,
        var doc_url:String,
        var datetime:String
    )
    data class Meta(
        var total_count:Int,
        var pageable_count:Int,
        var is_end:Boolean
    )
}