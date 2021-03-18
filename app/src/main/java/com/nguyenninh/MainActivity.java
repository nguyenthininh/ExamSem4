package com.nguyenninh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName, etMail, etPhone;
    Button btAdd, btSearch;
    RadioGroup rgGender;
    AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getAppDatabase(this);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etMail = findViewById(R.id.etEmail);
        rgGender = findViewById(R.id.rgGender);
        btAdd = findViewById(R.id.btAddCustomer);
        btSearch = findViewById(R.id.btSearchCustomer);
        btAdd.setOnClickListener(this);
        btSearch.setOnClickListener(this);


    }

    private void insertCustomer(){

    }

    private void findCustomer(){

    }

    private void getAllCustomer(){

    }

    private void onAdd(){

    }
    private void onSearch(){

    }



    private boolean validate() {
        String mes = null;
        if (etName.getText().toString().trim().isEmpty()) {
            mes = "Chưa nhập username";
        }else if (etPhone.getText().toString().trim().isEmpty()) {
            mes = "Chưa nhập số điện thoại";
        }
        if (mes != null) {
            Toast.makeText(this, mes, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btAddCustomer:
                onAdd();
                break;
            case R.id.btSearchCustomer:
                onSearch();
                break;
            default:
                break;
        }
    }
}