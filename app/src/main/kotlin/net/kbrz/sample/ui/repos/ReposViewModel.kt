package net.kbrz.sample.ui.repos

import android.databinding.ObservableBoolean
import io.reactivex.Observable
import net.kbrz.sample.net.GithubApi
import net.kbrz.sample.rx.SchedulersWrapper
import net.kbrz.sample.ui.base.BaseViewModel
import net.kbrz.sample.ui.repos.row.RepoRowViewModel
import net.kbrz.sample.util.ObservableString
import net.kbrz.sample.util.addTo

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

class ReposViewModel : BaseViewModel() {

    val title = ObservableString()
    val refreshing = ObservableBoolean()

    lateinit var viewAccess: ReposViewAccess
    lateinit var githubApi: GithubApi
    lateinit var schedulers: SchedulersWrapper

    var models = mutableListOf<RepoRowViewModel>()

    fun inject(viewAccess: ReposViewAccess, githubApi: GithubApi, schedulers: SchedulersWrapper) {
        this.viewAccess = viewAccess
        this.githubApi = githubApi
        this.schedulers = schedulers
    }

    fun initialize(title: String) {
        if (initialized) {
            return
        }
        initialized = true
        this.title.set(title)
        fetchRepos()
    }

    fun fetchRepos() {
        githubApi.getUserRepositories("google")
                .subscribeOn(schedulers.io)
                .observeOn(schedulers.computation)
                .toObservable()
                .flatMap { Observable.fromIterable(it) }
                .map { RepoRowViewModel(it) }
                .toList()
                .doOnSubscribe { refreshing.set(true) }
                .doFinally { refreshing.set(false) }
                .observeOn(schedulers.mainThread)
                .subscribe(this::handleReposFetchSuccess, this::handleReposFetchError)
                .addTo(disposableBag)
    }

    internal fun handleReposFetchSuccess(repos: List<RepoRowViewModel>) {
        models.addAll(repos)
        viewAccess.notifyReposChanged()
    }

    internal fun handleReposFetchError(throwable: Throwable?) {
        viewAccess.showErrorMessage()
        throwable?.printStackTrace()
    }

}