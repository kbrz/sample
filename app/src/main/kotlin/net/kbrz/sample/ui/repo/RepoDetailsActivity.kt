package net.kbrz.sample.ui.repo

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import net.kbrz.sample.R
import net.kbrz.sample.databinding.ActivityRepoDetailsBinding
import net.kbrz.sample.di.module.view.RepoDetailsModule
import net.kbrz.sample.model.Repo
import net.kbrz.sample.ui.base.BaseActivity
import javax.inject.Inject

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

class RepoDetailsActivity : BaseActivity(), RepoDetailsViewAccess {

    @Inject
    lateinit var model: RepoDetailsViewModel

    lateinit var binding: ActivityRepoDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repo = intent?.getParcelableExtra<Repo>(EXTRA_REPO)

        if (repo == null) {
            finish()
            return
        }

        githubApplication.appComponent.add(RepoDetailsModule(this)).inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_repo_details)
        binding.model = model

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        model.initialize(getString(R.string.repo_details_title), repo)
    }

}

val EXTRA_REPO = "EXTRA_REPO"

fun createRepoDetailsIntent(context: Context, repo: Repo): Intent {
    val intent = Intent(context, RepoDetailsActivity::class.java)
    intent.putExtra(EXTRA_REPO, repo)
    return intent
}

