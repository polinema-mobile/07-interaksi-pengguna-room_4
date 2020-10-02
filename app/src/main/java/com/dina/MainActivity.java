package com.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton, radioButton2;
    EditText edtTanggalLahir, edtNama, edtNim;
    Spinner spinnerJurusan;
    Calendar calendar;
    DatePickerDialog picker;
    Button btnGetIntent, btnGetParcelable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTanggalLahir = (EditText) findViewById(R.id.edtTanggalLahir);
        edtTanggalLahir.setInputType(InputType.TYPE_NULL);
        edtTanggalLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        edtTanggalLahir.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, day);
                picker.show();
            }
        });

        edtNama = (EditText) findViewById(R.id.edtNama);
        edtNim = (EditText) findViewById(R.id.edtNim);
        edtTanggalLahir = (EditText) findViewById(R.id.edtTanggalLahir);
        radioGroup = findViewById(R.id.radioGroup);
        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        spinnerJurusan =(Spinner) findViewById(R.id.spinnerJurusan);
        btnGetIntent = (Button) findViewById(R.id.btnSubmit);

        btnGetIntent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("data1", edtNama.getText().toString());
                intent.putExtra("data2", edtNim.getText().toString());
                intent.putExtra("data3", edtTanggalLahir.getText().toString());
                if(radioButton.isChecked()){
                    radioButton = (RadioButton) findViewById(selectedId);
                    intent.putExtra("data4", radioButton.getText().toString());
                }else{
                    intent.putExtra("data4", radioButton2.getText().toString());
                }
                intent.putExtra("data5", spinnerJurusan.getSelectedItem().toString());
                startActivity(intent);
            }
        });
        btnGetParcelable = findViewById(R.id.btnParcelable);
        btnGetParcelable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivityParcelabel.class);

                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton data4 = (RadioButton) findViewById(selectedId);
                Mahasiswa mahasiswa = new Mahasiswa(edtNama.getText().toString(), edtNim.getText().toString(), edtTanggalLahir.getText().toString(), data4.getText().toString(), spinnerJurusan.getSelectedItem().toString());

                intent.putExtra("Parcelable", mahasiswa);
                startActivity(intent);
            }
        });

    }
}