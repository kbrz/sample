package net.kbrz.sample.ui.repos.row

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import net.kbrz.sample.R
import net.kbrz.sample.databinding.RowRepoBinding
import net.kbrz.sample.ui.repo.createRepoDetailsIntent
import net.kbrz.sample.ui.repos.ReposActivity

/**
 * @author Konrad Brzykcy
 * @since 13.05.2017
 */

class RepoAdapter(private val context: ReposActivity, private val models: MutableList<RepoRowViewModel>) : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RepoViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = DataBindingUtil.inflate<RowRepoBinding>(inflater, R.layout.row_repo, parent, false)
        return RepoViewHolder(binding)
    }

    override fun getItemCount() = models.size

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) = holder.bind(models[position])

    inner class RepoViewHolder(private val binding: RowRepoBinding)
        : RecyclerView.ViewHolder(binding.root),
          RepoRowViewAccess {

        fun bind(model: RepoRowViewModel) {
            model.viewAccess = this
            binding.model = model
            binding.executePendingBindings()
        }

        override fun openDetails() {
            val repo = models[adapterPosition].repo
            context.startActivity(createRepoDetailsIntent(context, repo))
        }

    }

}