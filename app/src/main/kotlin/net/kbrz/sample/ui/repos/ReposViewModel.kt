package net.kbrz.sample.ui.repos

import android.databinding.ObservableBoolean
import android.util.Log
import io.reactivex.Observable
import net.kbrz.sample.di.scope.ActivityScope
import net.kbrz.sample.net.GithubApi
import net.kbrz.sample.rx.SchedulersWrapper
import net.kbrz.sample.ui.base.BaseViewModel
import net.kbrz.sample.ui.repos.row.RepoRowViewModel
import net.kbrz.sample.util.ObservableString
import net.kbrz.sample.util.addTo
import javax.inject.Inject

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

@ActivityScope
class ReposViewModel @Inject constructor() : BaseViewModel() {

    val title = ObservableString()
    val refreshing = ObservableBoolean()

    @Inject
    lateinit var viewAccess: ReposViewAccess

    @Inject
    lateinit var githubApi: GithubApi

    @Inject
    lateinit var schedulers: SchedulersWrapper

    fun initializa(title: String) {
        this.title.set(title)
        fetchRepos()
    }

    fun fetchRepos() {
        githubApi.getUserRepositories("google")
                .subscribeOn(schedulers.io)
                .observeOn(schedulers.computation)
                .toObservable()
                .flatMap { Observable.fromIterable(it) }
                .doOnNext { Log.d("dupa", it.toString()) }
                .map { RepoRowViewModel(it) }
                .toList()
                .doOnSubscribe { refreshing.set(true) }
                .doFinally { refreshing.set(false) }
                .observeOn(schedulers.mainThread)
                .subscribe(this::handleReposFetchSuccess, this::handleReposFetchError)
                .addTo(dispossableBag)
    }

    internal fun handleReposFetchSuccess(repos: List<RepoRowViewModel>) {
        viewAccess.refillList(repos)
    }

    internal fun handleReposFetchError(throwable: Throwable?) {
        viewAccess.showErrorMessage()
        throwable?.printStackTrace()
    }

}