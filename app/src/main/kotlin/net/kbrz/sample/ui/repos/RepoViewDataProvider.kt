package net.kbrz.sample.ui.repos

import android.support.v7.widget.RecyclerView
import net.kbrz.sample.ui.repos.row.RepoAdapter

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

interface RepoViewDataProvider {

    val adapter: RepoAdapter
    val layoutManager: RecyclerView.LayoutManager
    val itemAnimator: RecyclerView.ItemAnimator

}