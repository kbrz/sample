package net.kbrz.sample.di.module.view

import com.nhaarman.mockito_kotlin.mock
import dagger.Module
import dagger.Provides
import net.kbrz.sample.di.scope.ActivityScope
import net.kbrz.sample.ui.repo.RepoDetailsViewAccess

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

@Module
@ActivityScope
class RepoDetailsTestModule {

    @Provides
    @ActivityScope
    internal fun provideRepoDetailsViewAccess(): RepoDetailsViewAccess {
        return mock()
    }

}