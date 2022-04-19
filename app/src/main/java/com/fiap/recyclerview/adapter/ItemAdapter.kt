package com.fiap.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.fiap.recyclerview.R
import com.fiap.recyclerview.model.Ingresso

// Classe responsavel pela adaptacao de uma lista de dados para uma RecycleView
    class ItemAdapter(val dataset: List<Ingresso>, val onProdutoClickListener: OnProdutoClickListener):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    // Inner class responsavel pelo acesso via codigo aos componentes do layout de cada item
    class ItemViewHolder(view: View, val onProdutoClickListener: OnProdutoClickListener): RecyclerView.ViewHolder(view), View.OnClickListener {
        val tvTimeC = view.findViewById<TextView>(R.id.tvTimeCasa);
        val tvTimeV = view.findViewById<TextView>(R.id.tvTimeVisitante);
        val tvEstadio = view.findViewById<TextView>(R.id.tvEstadio);
        val tvSetor = view.findViewById<TextView>(R.id.tvSetor);
        val tvCampeonato = view.findViewById<TextView>(R.id.tvCampeonato);
        val tvValor = view.findViewById<TextView>(R.id.tvValor);
        val clItemLista = view.findViewById<ConstraintLayout>(R.id.clItemLista);

        init {
            clItemLista.setOnClickListener(this);
        }

        override fun onClick(v: View?) {
            onProdutoClickListener.onProdutoClick(adapterPosition);
        }
    }

    // Funcao responsavel pela criacao de uma instancia de ItemViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false);
        return ItemViewHolder(adapterLayout, onProdutoClickListener);
    }

    // Função responsavel pela associacao de um objeto de dados a uma instancia ItemViewHolder
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val produto = dataset[position];
        holder.tvTimeC.text = produto.timeC;
        holder.tvTimeV.text = produto.timeV;
        holder.tvEstadio.text = produto.estadio;
        holder.tvSetor.text = " (" + produto.setor + ")";
        holder.tvCampeonato.text = produto.campeonato;
        holder.tvValor.text = String.format("%.2f", produto.valor);
    }

    // Funcao responsavel por retornar o tamanho da lista de dados
    override fun getItemCount(): Int {
        return dataset.size
    }

    interface OnProdutoClickListener {
        fun onProdutoClick(prodPosition: Int);
    }
}