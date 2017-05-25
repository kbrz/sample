package net.kbrz.sample.ui.repos.row

import android.databinding.ObservableInt
import net.kbrz.sample.model.Repo
import net.kbrz.sample.ui.base.RowViewModel
import net.kbrz.sample.util.ObservableString

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

class RepoRowViewModel(val repo: Repo) : RowViewModel<RepoRowViewAccess?> {

    val repoName = ObservableString(repo.name)
    val language = ObservableString(repo.language)
    val starsCount = ObservableInt(repo.stars ?: 0)
    val forksCount = ObservableInt(repo.forks ?: 0)

    override var viewAccess: RepoRowViewAccess? = null

    fun onClick() {
        viewAccess?.openDetails()
    }

}