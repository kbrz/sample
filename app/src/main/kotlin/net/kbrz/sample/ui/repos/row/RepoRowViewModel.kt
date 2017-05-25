package net.kbrz.sample.ui.repos.row

import net.kbrz.sample.model.Repo
import net.kbrz.sample.ui.base.RowViewModel
import net.kbrz.sample.util.ObservableString

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

class RepoRowViewModel(val repo: Repo) : RowViewModel<RepoRowViewAccess?> {

    val repoName = ObservableString(repo.name)

    override var viewAccess: RepoRowViewAccess? = null

    fun onClick() {
        viewAccess?.openDetails()
    }

}