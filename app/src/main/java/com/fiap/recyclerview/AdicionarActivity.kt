package com.fiap.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fiap.recyclerview.model.Ingresso

class AdicionarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar)

        val nome: EditText = findViewById(R.id.etNome);
        val timeC: EditText = findViewById(R.id.etTimeCasa);
        val timeV: EditText = findViewById(R.id.etTimeVisitante);
        val campeonato: EditText = findViewById(R.id.etCampeonato);
        val estadio: EditText = findViewById(R.id.etEstadio);
        val setor: EditText = findViewById(R.id.etSetor);
        val valor: EditText = findViewById(R.id.etValor);

        findViewById<Button>(R.id.btAdicionar).setOnClickListener {
            val produto = Ingresso(
                nome.text.toString().trim(),
                timeC.text.toString().trim(),
                timeV.text.toString().trim(),
                campeonato.text.toString().trim(),
                estadio.text.toString().trim(),
                setor.text.toString().trim(),
                valor.text.toString().trim().toDouble()
            );
            adicionarItem(produto);

            nome.setText("");
            timeC.setText("");
            timeV.setText("");
            campeonato.setText("");
            estadio.setText("");
            setor.setText("");
            valor.setText("");
        }
    }

    private fun adicionarItem(item: Ingresso) {
        Database.listaIngressos.add(item);
        Toast.makeText(this, "Ingresso adicionado!", Toast.LENGTH_LONG).show();
    }
}