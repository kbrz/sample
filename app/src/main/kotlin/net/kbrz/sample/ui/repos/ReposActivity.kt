package net.kbrz.sample.ui.repos

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import net.kbrz.sample.R
import net.kbrz.sample.databinding.ActivityReposBinding
import net.kbrz.sample.di.module.view.ReposModule
import net.kbrz.sample.ui.base.BaseActivity
import net.kbrz.sample.ui.repos.row.RepoAdapter
import net.kbrz.sample.ui.repos.row.RepoRowViewModel
import javax.inject.Inject

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

class ReposActivity : BaseActivity(), ReposViewAccess, RepoViewDataProvider {

    @Inject
    lateinit var model: ReposViewModel

    private lateinit var binding: ActivityReposBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        githubApplication.appComponent.add(ReposModule(this)).inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_repos)
        binding.model = model
        binding.data = this

        registerModel(model)

        setSupportActionBar(binding.toolbar)

        model.initialize(getString(R.string.repos_title))
    }

    //region ReposViewAccess
    override fun refillList(repos: List<RepoRowViewModel>) {
        adapter.refill(repos)
    }

    override fun showErrorMessage() {
        Snackbar.make(binding.clRoot, getString(R.string.repos_fetch_error), Snackbar.LENGTH_SHORT).show()
    }
    //endregion

    //region RepoViewDataProvider
    @Inject
    override lateinit var adapter: RepoAdapter

    override val layoutManager: RecyclerView.LayoutManager by lazy {
        LinearLayoutManager(this)
    }

    override val itemAnimator: RecyclerView.ItemAnimator by lazy {
        DefaultItemAnimator()
    }
    //endregion

}