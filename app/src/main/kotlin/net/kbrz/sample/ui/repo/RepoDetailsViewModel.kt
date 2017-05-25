package net.kbrz.sample.ui.repo

import net.kbrz.sample.model.Repo
import net.kbrz.sample.ui.base.BaseViewModel
import net.kbrz.sample.util.ObservableString

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

class RepoDetailsViewModel : BaseViewModel() {

    companion object {
        val DATE_FORMAT = "dd.MM.yyyy"
    }

    val title = ObservableString()
    val name = ObservableString()
    val description = ObservableString()
    val author = ObservableString()
    val createdAt = ObservableString()

    fun initialize(title: String, repo: Repo) {
        if (initialized) {
            return
        }
        initialized = true
        this.title.set(title)
        name.set(repo.name)
        description.set(repo.description)
        author.set(repo.owner?.login)
        createdAt.set(repo.createdAt?.toString(DATE_FORMAT))
    }

}