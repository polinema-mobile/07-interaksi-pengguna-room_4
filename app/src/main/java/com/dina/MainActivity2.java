package com.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView namaMhs = (TextView) findViewById(R.id.Nama_mahasiswa);
        TextView nimMhs = (TextView) findViewById(R.id.nim);
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        String nim = intent.getStringExtra("NIM");

        namaMhs.setText("Nama : "+name);
        nimMhs.setText("NIM   : "+nim);

    }
}