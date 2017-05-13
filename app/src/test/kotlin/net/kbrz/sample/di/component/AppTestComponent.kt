package net.kbrz.sample.di.component

import dagger.Component
import net.kbrz.sample.di.component.view.RepoDetailsTestComponent
import net.kbrz.sample.di.component.view.ReposTestComponent
import net.kbrz.sample.di.module.AppTestModule
import net.kbrz.sample.di.module.view.RepoDetailsTestModule
import net.kbrz.sample.di.module.view.ReposTestModule
import javax.inject.Singleton

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

@Component(modules = arrayOf(AppTestModule::class))
@Singleton
interface AppTestComponent {

    fun add(reposTestModule: ReposTestModule): ReposTestComponent
    fun add(repoDetailsTestModule: RepoDetailsTestModule): RepoDetailsTestComponent

}