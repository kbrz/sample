package net.kbrz.sample.ui.base

import android.support.v7.app.AppCompatActivity
import net.kbrz.sample.GithubApplication

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

open class BaseActivity : AppCompatActivity() {

    protected val githubApplication: GithubApplication
        get() = applicationContext as GithubApplication

    private val registeredModels = mutableListOf<BaseViewModel>()

    protected fun registerModel(viewModel: BaseViewModel) {
        registeredModels.add(viewModel)
    }

    override fun onDestroy() {
        super.onDestroy()
        registeredModels.forEach(BaseViewModel::onDestroy)
        registeredModels.clear()
    }

}