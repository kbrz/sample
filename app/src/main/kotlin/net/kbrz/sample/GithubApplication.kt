package net.kbrz.sample

import android.app.Application
import net.kbrz.sample.di.component.AppComponent
import net.kbrz.sample.di.component.DaggerAppComponent
import net.kbrz.sample.di.module.ApiModule
import net.kbrz.sample.di.module.AppModule
import net.kbrz.sample.di.module.NetModule

/**
 * @author Konrad Brzykcy
 * @since 12.05.17
 */

class GithubApplication: Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .netModule(NetModule())
                .apiModule(ApiModule())
                .build()
    }

}