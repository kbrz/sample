package net.kbrz.sample.ui.repos

import net.kbrz.sample.ui.repos.row.RepoRowViewModel

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

interface ReposViewAccess {

    fun refillList(repos: List<RepoRowViewModel>)
    fun showErrorMessage()

}