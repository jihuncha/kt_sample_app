package com.huni.myworld.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

open class BaseKotlinViewModel: ViewModel() {

    /**
     *
     * 만약 구독자가 여러 곳에 있다면 이들을 폐기할 때마다 각 Disposable 객체의 dispose()를 호출해주어야 한다.
     * 이런 귀찮은 작업을 개발자들이 좋아할 리 없다. 이럴 땐 CompositeDisposable에 각각의 disposable을 추가해둔 후
     * 한꺼번에 폐기하면 된다.
     *
     */
    private val compositeDisposable = CompositeDisposable()

    /**
     *
     * 
     * */
    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    /**
     * 
     *  ViewModel은 View와의 생명주기를 공유하기 때문에 View가 사라질떄
     *  ViewModel의 onCleared()가 호출 -> observable 을 clear 시킨다.
     * */
    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}