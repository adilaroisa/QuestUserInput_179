package com.example.pertemuan5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pertemuan5.R

// Definisi Warna (Biru Pastel)
private val PrimaryBlue = Color(0xFF64B5F6)
private val HeaderBackground = Color(0xFFE3F2FD)
private val White = Color.White
private val LightGray = Color(0xFFD3D3D3)

@Composable
fun FormDataPendaftaran(modifier: Modifier = Modifier) {
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    var namaDisubmit by remember { mutableStateOf("N/A") }
    var jenisDisubmit by remember { mutableStateOf("N/A") }
    var alamatDisubmit by remember { mutableStateOf("N/A") }
    var statusDisubmit by remember { mutableStateOf("N/A") }

    val genderOptions: List<String> = listOf("Laki-laki", "Perempuan")
    val statusOptions: List<String> = listOf("Janda", "Lajang", "Duda")

    Column(modifier = modifier.fillMaxSize()) {

        // 1. HEADER
        Surface(
            color = HeaderBackground,
            modifier = Modifier.fillMaxWidth()
        ) {
            HeaderPendaftaran()
        }

        // 2. KONTEN FORMULIR DALAM CARD
        Card(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            colors = CardDefaults.cardColors(containerColor = White),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
            shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 8.dp, bottomEnd = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = dimensionResource(R.dimen.jarak_antar_section)),
                verticalArrangement = Arrangement.spacedBy(8.dp), // Mengurangi jarak antar item
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(modifier = Modifier.height(12.dp)) // Mengurangi jarak atas

                // NAMA LENGKAP
                Text(text = stringResource(R.string.label_nama_lengkap), fontSize = 14.sp, style = MaterialTheme.typography.titleMedium)
                OutlinedTextField(
                    value = textNama,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = stringResource(R.string.hint_nama_lengkap)) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = PrimaryBlue,
                        unfocusedBorderColor = LightGray,
                    ),
                    onValueChange = { textNama = it }
                )

                Spacer(modifier = Modifier.height(12.dp)) // Mengurangi jarak antar section

                // JENIS KELAMIN
                Text(text = stringResource(R.string.label_jenis_kelamin), fontSize = 14.sp, style = MaterialTheme.typography.titleMedium)
                Column(verticalArrangement = Arrangement.spacedBy(0.dp)) { // Merapatkan RadioButton
                    genderOptions.forEach { item ->
                        SelectionOption(
                            label = item,
                            isSelected = textJK == item,
                            onClick = { textJK = item }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp)) // Mengurangi jarak antar section

                // STATUS PERKAWINAN
                Text(text = stringResource(R.string.label_status_perkawinan), fontSize = 14.sp, style = MaterialTheme.typography.titleMedium)
                Column(verticalArrangement = Arrangement.spacedBy(0.dp)) { // Merapatkan RadioButton
                    statusOptions.forEach { item ->
                        SelectionOption(
                            label = item,
                            isSelected = textStatus == item,
                            onClick = { textStatus = item }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp)) // Mengurangi jarak antar section

                // ALAMAT
                Text(text = stringResource(R.string.label_alamat), fontSize = 14.sp, style = MaterialTheme.typography.titleMedium)
                OutlinedTextField(
                    value = textAlamat,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = stringResource(R.string.hint_alamat)) },
                    minLines = 2, // Mengurangi tinggi minimal kolom alamat
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = PrimaryBlue,
                        unfocusedBorderColor = LightGray,
                    ),
                    onValueChange = { textAlamat = it }
                )

                Spacer(modifier = Modifier.height(12.dp))
            }
        }

        // 3. TOMBOL SUBMIT (DI LUAR CARD)
        Surface(
            color = White,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp), // Mengurangi padding tombol
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                    enabled = true,
                    shape = RoundedCornerShape(8.dp),
                    onClick = {
                        namaDisubmit = textNama
                        alamatDisubmit = textAlamat
                        jenisDisubmit = textJK
                        statusDisubmit = textStatus
                        println("Data Submitted: Nama=${textNama}, JK=${textJK}, Status=${textStatus}, Alamat=${textAlamat}")
                    }
                ) {
                    Text(stringResource(R.string.button_submit), color = White)
                }
            }
        }
    }
}

@Composable
fun HeaderPendaftaran() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = stringResource(R.string.form_title),
            color = Color.Black,
            fontSize = 20.sp,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(start = 24.dp)
        )
    }
}

@Composable
fun SelectionOption(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .selectable(
                selected = isSelected,
                onClick = onClick
            )
            .fillMaxWidth()
            .padding(end = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = isSelected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(selectedColor = PrimaryBlue)
        )
        Text(label)
    }
}