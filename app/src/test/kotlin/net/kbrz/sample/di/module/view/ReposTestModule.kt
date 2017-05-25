package net.kbrz.sample.di.module.view

import com.nhaarman.mockito_kotlin.mock
import dagger.Module
import dagger.Provides
import net.kbrz.sample.di.scope.ActivityScope
import net.kbrz.sample.ui.repos.ReposViewAccess
import net.kbrz.sample.ui.repos.ReposViewModel
import net.kbrz.sample.ui.repos.row.RepoAdapter

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
    internal fun provideRepoAdapter(): RepoAdapter {
        return mock()
    }

    @Provides
    @ActivityScope
    internal fun provideReposViewModel(): ReposViewModel {
        return ReposViewModel()
    }

}