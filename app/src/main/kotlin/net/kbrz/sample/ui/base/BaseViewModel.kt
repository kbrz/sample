package net.kbrz.sample.ui.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

open class BaseViewModel : ViewModel() {

    protected val disposableBag = CompositeDisposable()
    protected var initialized = false

    override fun onCleared() {
        super.onCleared()
        disposableBag.clear()
    }

}