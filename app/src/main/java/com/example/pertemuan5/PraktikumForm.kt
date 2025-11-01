package com.example.pertemuan5


import com.example.pertemuan5.R


private val PrimaryBlue = Color(0xFF64B5F6) // Biru untuk tombol
private val HeaderBackground = Color(0xFFE3F2FD) // Biru untuk header
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

        // 1. HEADER (Menempel di atas)
        Surface(
            color = HeaderBackground,
            modifier = Modifier.fillMaxWidth()
        ) {
            HeaderPendaftaran()
        }

        // 2. KONTEN FORMULIR DALAM CARD
        // Penyesuaian padding horizontal pada Card agar lebih kecil
        Card(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 24.dp), // <-- Mengurangi lebar Card dengan padding tambahan
            colors = CardDefaults.cardColors(containerColor = White),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
            shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 8.dp, bottomEnd = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = dimensionResource(R.dimen.jarak_antar_section)), // Padding di dalam Card
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.jarak_antar_item_minor)),
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.jarak_antar_section)))

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

                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.jarak_antar_section)))

                // JENIS KELAMIN
                Text(text = stringResource(R.string.label_jenis_kelamin), fontSize = 14.sp, style = MaterialTheme.typography.titleMedium)
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    genderOptions.forEach { item ->
                        SelectionOption(
                            label = item,
                            isSelected = textJK == item,
                            onClick = { textJK = item }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.jarak_antar_section)))

                // STATUS PERKAWINAN
                Text(text = stringResource(R.string.label_status_perkawinan), fontSize = 14.sp, style = MaterialTheme.typography.titleMedium)
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    statusOptions.forEach { item ->
                        SelectionOption(
                            label = item,
                            isSelected = textStatus == item,
                            onClick = { textStatus = item }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.jarak_antar_section)))

                // ALAMAT
                Text(text = stringResource(R.string.label_alamat), fontSize = 14.sp, style = MaterialTheme.typography.titleMedium)
                OutlinedTextField(
                    value = textAlamat,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = stringResource(R.string.hint_alamat)) },
                    minLines = 3,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = PrimaryBlue,
                        unfocusedBorderColor = LightGray,
                    ),
                    onValueChange = { textAlamat = it }
                )

                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.jarak_antar_section)))
            }
        }

        // 3. TOMBOL SUBMIT
        Surface(
            color = White,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp) // <-- Menyesuaikan padding horizontal tombol juga
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = dimensionResource(R.dimen.jarak_antar_item_minor)),
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
            modifier = Modifier.padding(start = 24.dp) // <-- Menyesuaikan padding header
        )
    }
}
