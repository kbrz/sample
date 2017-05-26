package net.kbrz.sample.ui.base

import android.support.v7.app.AppCompatActivity
import net.kbrz.sample.GithubApplication

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

open class BaseActivity : AppCompatActivity() {

    val githubApplication = applicationContext as GithubApplication

}