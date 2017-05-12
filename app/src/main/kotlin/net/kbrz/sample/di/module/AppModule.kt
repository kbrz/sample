package net.kbrz.sample.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Konrad Brzykcy
 * @since 12.05.17
 */

@Module
@Singleton
class AppModule(val applicationContext: Context) {

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return applicationContext
    }

}
