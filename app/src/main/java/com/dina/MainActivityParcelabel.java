package com.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivityParcelabel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelabel);
        TextView nama = (TextView) findViewById(R.id.item_name);
        TextView nim = (TextView) findViewById(R.id.item_nim);
        TextView tanggal = (TextView) findViewById(R.id.item_tanggal);
        TextView jk = (TextView) findViewById(R.id.item_jenis_kelamin);
        TextView jurusan = (TextView) findViewById(R.id.item_jurusan);

        Mahasiswa biodata = getIntent().getParcelableExtra("BIODATA");

        nama.setText( biodata.getNama());
        nim.setText(biodata.getNim());
        tanggal.setText(biodata.getTanggal());
        jk.setText (biodata.getJk());
        jurusan.setText(biodata.getJurusan());
    }
}