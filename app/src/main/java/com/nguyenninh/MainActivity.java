package com.nguyenninh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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
        if (!validate()) {
            return;
        }
        RadioButton bt = (RadioButton) findViewById(rgGender.getCheckedRadioButtonId());

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.username = etName.getText().toString();
        customerEntity.email = etMail.getText().toString();
        customerEntity.phone = etPhone.getText().toString();
        customerEntity.gender = bt.getText().toString();
//        long id = db.customerDao().insertCustomer(customerEntity);
//        if (id > 0) {
//            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
//        }
        goToListUser();

    }
    private void onSearch(){

    }
    private void goToListUser() {
        Intent intent = new Intent(this, ListCustomerActivity.class);
        startActivity(intent);
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