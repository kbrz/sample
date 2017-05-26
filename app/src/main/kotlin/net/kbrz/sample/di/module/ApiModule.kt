package net.kbrz.sample.di.module

import dagger.Module
import dagger.Provides
import net.kbrz.sample.net.GithubApi
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author Konrad Brzykcy
 * @since 12.05.17
 */

@Module
@Singleton
class ApiModule {

    @Provides
    @Singleton
    internal fun provideGithubApi(retrofit: Retrofit): GithubApi = retrofit.create(GithubApi::class.java)

}