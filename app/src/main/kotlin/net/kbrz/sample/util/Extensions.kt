package net.kbrz.sample.util

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

fun Disposable.addTo(disposableBag: CompositeDisposable) {
    disposableBag.add(this)
}
