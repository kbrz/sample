package net.kbrz.sample.di.component

import dagger.Component
import net.kbrz.sample.di.module.ApiModule
import net.kbrz.sample.di.module.AppModule
import net.kbrz.sample.di.module.NetModule
import javax.inject.Singleton

/**
 * @author Konrad Brzykcy
 * @since 12.05.17
 */

@Component(modules = arrayOf(
        AppModule::class,
        NetModule::class,
        ApiModule::class
))
@Singleton
interface AppComponent