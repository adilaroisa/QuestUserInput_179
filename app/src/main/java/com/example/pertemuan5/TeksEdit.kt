package com.example.pertemuan5

import androidx.compose.runtime.Composable

@Composable
fun FormDataDiri(modifier: Modifier = Modifier
){
    // variabel-variabel untuk mengingat nilai masukan dari keyboard
    var textNama by remember {mutableStateOf("")}
    var textAlamat by remember {mutableStateOf("")}
    var textJK by remember {mutableStateOf("")}

    //variabel-variabel untuk menyimpan data yang diperoleh dari komponen UI
    var nama by remember {mutableStateOf("")}
    var alamat by remember {mutableStateOf("")}
    var jenis by remember {mutableStateOf("")}

    // Daftar opsi untuk Radio Button Jenis Kelamin
    val gender: List<String> = listOf("Laki-laki","Perempuan")