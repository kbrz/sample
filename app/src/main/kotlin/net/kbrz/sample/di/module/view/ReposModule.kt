package net.kbrz.sample.di.module.view

import dagger.Module
import dagger.Provides
import net.kbrz.sample.di.scope.ActivityScope
import net.kbrz.sample.ui.repos.ReposActivity
import net.kbrz.sample.ui.repos.ReposViewAccess
import net.kbrz.sample.ui.repos.row.RepoAdapter

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

@Module
@ActivityScope
class ReposModule(val reposActivity: ReposActivity) {

    @Provides
    @ActivityScope
    internal fun provideReposViewAccess(): ReposViewAccess {
        return reposActivity
    }

    @Provides
    @ActivityScope
    internal fun provideRepoAdapter(): RepoAdapter {
        return RepoAdapter(reposActivity)
    }

}