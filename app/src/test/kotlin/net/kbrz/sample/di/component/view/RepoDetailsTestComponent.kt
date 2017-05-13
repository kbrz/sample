package net.kbrz.sample.di.component.view

import dagger.Subcomponent
import net.kbrz.sample.di.module.view.RepoDetailsTestModule
import net.kbrz.sample.di.scope.ActivityScope
import net.kbrz.sample.ui.repo.RepoDetailsViewModelTest

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

@Subcomponent(modules = arrayOf(RepoDetailsTestModule::class))
@ActivityScope
interface RepoDetailsTestComponent {

    fun inject(repoDetailsViewModelTest: RepoDetailsViewModelTest)

}