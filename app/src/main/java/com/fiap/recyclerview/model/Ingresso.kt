package com.fiap.recyclerview.model

import java.io.Serializable

data class Ingresso(
    val nome: String,
    val timeC: String,
    val timeV: String,
    val campeonato: String,
    val estadio: String,
    val setor: String,
    val valor: Double,
) : Serializable