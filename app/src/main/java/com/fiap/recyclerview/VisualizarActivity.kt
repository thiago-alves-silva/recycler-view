package com.fiap.recyclerview

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fiap.recyclerview.model.Ingresso

class VisualizarActivity : AppCompatActivity() {
    private lateinit var ingresso: Ingresso;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar)

        ingresso = intent.getSerializableExtra("ingresso") as Ingresso;

        val tvNome = findViewById<TextView>(R.id.tvNome);
        val tvTimeC = findViewById<TextView>(R.id.tvTimeCasa);
        val tvTimeV = findViewById<TextView>(R.id.tvTimeVisitante);
        val tvEstadio = findViewById<TextView>(R.id.tvEstadio);
        val tvSetor = findViewById<TextView>(R.id.tvSetor);
        val tvCampeonato = findViewById<TextView>(R.id.tvCampeonato);
        val tvValor = findViewById<TextView>(R.id.tvValor);

        tvNome.text = ingresso.nome;
        tvTimeC.text = ingresso.timeC;
        tvTimeV.text = ingresso.timeV;
        tvEstadio.text = ingresso.estadio;
        tvSetor.text = ingresso.setor;
        tvCampeonato.text = ingresso.campeonato;
        tvValor.text = String.format("%.2f", ingresso.valor);
    }
}