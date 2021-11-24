package com.graps.remindme.ui.base

import androidx.lifecycle.ViewModel
import com.graps.remindme.util.add
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class BaseViewModel : ViewModel() {
    private val disposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

    fun <T> observe(
        observable: Observable<T>,
        onComplete:(T) -> Unit,
        onError: (Throwable) -> Unit
    ){
        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onComplete, onError).add(disposable)
    }
}