package com.example.composemigration

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.poccomposemigration.R
import com.example.poccomposemigration.databinding.MigrationCardBinding

class MigrationAdapter(private val migrationList: List<String>) :
    RecyclerView.Adapter<MigrationAdapter.MigrationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MigrationViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.migration_card, parent, false),
    )

    override fun onBindViewHolder(holder: MigrationViewHolder, position: Int) {
        holder.bind(migrationList[position])
    }

    override fun getItemCount() = migrationList.size
    class MigrationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = MigrationCardBinding.bind(itemView)
        fun bind(item: String) {
            binding.cardText.text = item
        }
    }
}
