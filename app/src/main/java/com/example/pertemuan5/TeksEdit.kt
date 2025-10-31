package com.example.pertemuan5

import androidx.compose.runtime.Composable

@Composable
fun FormDataDiri(modifier: Modifier = Modifier
){
    var textNama by remember {mutableStateOf("")}
    var textAlamat by remember {mutableStateOf("")}
    var textJK by remember {mutableStateOf("")}