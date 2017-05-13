package net.kbrz.sample.rx

import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

class SchedulersWrapperTestImpl : SchedulersWrapper {

    val testScheduler by lazy { TestScheduler() }

    override val io: Scheduler = testScheduler
    override val mainThread: Scheduler = testScheduler
    override val computation: Scheduler = testScheduler

}