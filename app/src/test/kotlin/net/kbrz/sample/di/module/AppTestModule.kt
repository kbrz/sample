package net.kbrz.sample.di.module

import com.nhaarman.mockito_kotlin.mock
import dagger.Module
import dagger.Provides
import net.kbrz.sample.net.GithubApi
import net.kbrz.sample.rx.SchedulersWrapper
import net.kbrz.sample.rx.SchedulersWrapperTestImpl
import javax.inject.Singleton

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

@Module
@Singleton
class AppTestModule {

    @Provides
    @Singleton
    internal fun provideGithubApi(): GithubApi {
        return mock()
    }

    @Provides
    @Singleton
    internal fun provideSchedulersWrapper(): SchedulersWrapper {
        return SchedulersWrapperTestImpl()
    }

}