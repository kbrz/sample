package net.kbrz.sample.ui.base

import io.reactivex.disposables.CompositeDisposable

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

open class BaseViewModel {

    protected val dispossableBag = CompositeDisposable()

    fun onDestroy() {
        dispossableBag.clear()
    }

}