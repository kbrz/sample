package net.kbrz.sample.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author Konrad Brzykcy
 * @since 12.05.17
 */

class SchedulersWrapperImpl : SchedulersWrapper {

    override val io: Scheduler
        get() = Schedulers.io()

    override val mainThread: Scheduler
        get() = AndroidSchedulers.mainThread()

    override val computation: Scheduler
        get() = Schedulers.computation()

}