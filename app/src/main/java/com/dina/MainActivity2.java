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
        TextView tvData1 = (TextView) findViewById(R.id.tv_name_content);
        TextView tvData2 = (TextView) findViewById(R.id.tv_nim_content);
        TextView tvData3 = (TextView) findViewById(R.id.tv_birth_date_content);
        TextView tvData4 = (TextView) findViewById(R.id.tv_gender_content);
        TextView tvData5 = (TextView) findViewById(R.id.tv_department_content);
        /**
         * Kita cek apakah ada Bundle atau tidak
         */
        if(getIntent().getExtras()!=null){
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
            tvData1.setText(bundle.getString("data1"));
            tvData2.setText(bundle.getString("data2"));
            tvData3.setText(bundle.getString("data3"));
            tvData4.setText(bundle.getString("data4"));
            tvData5.setText(bundle.getString("data5"));

        }else{
            /**
             * Apabila Bundle tidak ada, ambil dari Intent
             */
            tvData1.setText(getIntent().getStringExtra("data1"));
            tvData2.setText(getIntent().getStringExtra("data2"));
            tvData3.setText(getIntent().getStringExtra("data3"));
            tvData4.setText(getIntent().getStringExtra("data4"));
            tvData5.setText(getIntent().getStringExtra("data5"));
        }
    }

}
