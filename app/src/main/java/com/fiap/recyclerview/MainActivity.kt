package com.fiap.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fiap.recyclerview.adapter.ItemAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), ItemAdapter.OnProdutoClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabAddBtn = findViewById<FloatingActionButton>(R.id.fabAddBtn)
        fabAddBtn.setOnClickListener {
            val intent = Intent(this, AdicionarActivity::class.java);
            startActivity(intent);
        }
    }

    override fun onResume() {
        super.onResume();
        val rvIngressos = findViewById<RecyclerView>(R.id.rvIngressos);
        rvIngressos.layoutManager = LinearLayoutManager(this);
        rvIngressos.adapter = ItemAdapter(Database.listaIngressos, this);
    }

    override fun onProdutoClick(prodPosition: Int) {
        val intent = Intent(this, VisualizarActivity::class.java);
        intent.putExtra("ingresso", Database.listaIngressos[prodPosition])
        startActivity(intent);
    }
}