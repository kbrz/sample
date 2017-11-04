package net.kbrz.sample.di.module.view

import android.arch.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import net.kbrz.sample.di.scope.ActivityScope
import net.kbrz.sample.net.GithubApi
import net.kbrz.sample.rx.SchedulersWrapper
import net.kbrz.sample.ui.repos.ReposActivity
import net.kbrz.sample.ui.repos.ReposViewAccess
import net.kbrz.sample.ui.repos.ReposViewModel
import net.kbrz.sample.ui.repos.row.RepoAdapter

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

@Module
@ActivityScope
class ReposModule(private val reposActivity: ReposActivity) {

    @Provides
    @ActivityScope
    internal fun provideReposViewAccess(): ReposViewAccess = reposActivity

    @Provides
    @ActivityScope
    internal fun provideReposViewModel(viewAccess: ReposViewAccess, githubApi: GithubApi, schedulers: SchedulersWrapper): ReposViewModel {
        val viewModel = ViewModelProviders.of(reposActivity).get(ReposViewModel::class.java)
        viewModel.inject(viewAccess, githubApi, schedulers)
        return viewModel
    }

    @Provides
    @ActivityScope
    internal fun provideRepoAdapter(reposViewModel: ReposViewModel): RepoAdapter = RepoAdapter(reposActivity, reposViewModel.models)

}