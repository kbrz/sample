package net.kbrz.sample.di.component.view

import dagger.Subcomponent
import net.kbrz.sample.di.module.view.RepoDetailsModule
import net.kbrz.sample.di.scope.ActivityScope
import net.kbrz.sample.ui.repo.RepoDetailsActivity

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

@Subcomponent(modules = arrayOf(RepoDetailsModule::class))
@ActivityScope
interface RepoDetailsComponent {

    fun inject(repoDetailsActivity: RepoDetailsActivity)

}