package net.kbrz.sample.di.component.view

import dagger.Subcomponent
import net.kbrz.sample.di.module.view.ReposTestModule
import net.kbrz.sample.di.scope.ActivityScope
import net.kbrz.sample.ui.repos.ReposViewModelTest

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

@Subcomponent(modules = arrayOf(ReposTestModule::class))
@ActivityScope
interface ReposTestComponent {

    fun inject(reposViewModelTest: ReposViewModelTest)

}