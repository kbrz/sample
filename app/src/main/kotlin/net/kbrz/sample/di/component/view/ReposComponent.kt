package net.kbrz.sample.di.component.view

import dagger.Subcomponent
import net.kbrz.sample.di.module.view.ReposModule
import net.kbrz.sample.di.scope.ActivityScope
import net.kbrz.sample.ui.repos.ReposActivity

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

@Subcomponent(modules = arrayOf(ReposModule::class))
@ActivityScope
interface ReposComponent {

    fun inject(activity: ReposActivity)

}