package net.kbrz.sample.di.module.view

import com.nhaarman.mockito_kotlin.mock
import dagger.Module
import dagger.Provides
import net.kbrz.sample.di.scope.ActivityScope
import net.kbrz.sample.net.GithubApi
import net.kbrz.sample.rx.SchedulersWrapper
import net.kbrz.sample.ui.repos.ReposViewAccess
import net.kbrz.sample.ui.repos.ReposViewModel

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

@Module
@ActivityScope
class ReposTestModule {

    @Provides
    @ActivityScope
    internal fun provideReposViewAccess(): ReposViewAccess {
        return mock()
    }

    @Provides
    @ActivityScope
    internal fun provideReposViewModel(viewAccess: ReposViewAccess, githubApi: GithubApi, schedulers: SchedulersWrapper): ReposViewModel {
        val viewModel = ReposViewModel()
        viewModel.inject(viewAccess, githubApi, schedulers)
        return viewModel
    }

}