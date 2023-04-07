package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository
import br.com.igorbag.githubsearch.ui.MainActivity

class RepositoryAdapter(private val mActivity: MainActivity, private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var carItemListener: (Repository) -> Unit = {}

    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.reposName.text = repositories[position].name
        holder.share.setOnClickListener{
            val repository = repositories[position]
            mActivity.shareRepositoryLink(repository.htmlUrl)
        }
    }

    override fun getItemCount(): Int = repositories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val reposName: TextView
        val share: ImageView

        init{
            view.apply {
                reposName = findViewById(R.id.tv_repos_name)
                share = findViewById(R.id.iv_share)
            }
        }

    }
}


