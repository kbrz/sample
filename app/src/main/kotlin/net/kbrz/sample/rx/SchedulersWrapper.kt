package net.kbrz.sample.rx

/**
 * @author Konrad Brzykcy
 * @since 12.05.17
 */
interface SchedulersWrapper {

    val io: io.reactivex.Scheduler
    val mainThread: io.reactivex.Scheduler
    val computation: io.reactivex.Scheduler

}