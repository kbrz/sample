package net.kbrz.sample.di.module.view

import android.arch.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import net.kbrz.sample.di.scope.ActivityScope
import net.kbrz.sample.ui.repo.RepoDetailsActivity
import net.kbrz.sample.ui.repo.RepoDetailsViewAccess
import net.kbrz.sample.ui.repo.RepoDetailsViewModel

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

@Module
@ActivityScope
class RepoDetailsModule(val repoDetailsActivity: RepoDetailsActivity) {

    @Provides
    @ActivityScope
    internal fun provideRepoDetailsViewAccess(): RepoDetailsViewAccess = repoDetailsActivity

    @Provides
    @ActivityScope
    internal fun provideRepoDetailsViewModel(): RepoDetailsViewModel {
        val viewModel = ViewModelProviders.of(repoDetailsActivity).get(RepoDetailsViewModel::class.java)
        return viewModel
    }

}