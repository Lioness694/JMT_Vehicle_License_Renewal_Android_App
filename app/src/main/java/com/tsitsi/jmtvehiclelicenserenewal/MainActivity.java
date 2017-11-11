package com.tsitsi.jmtvehiclelicenserenewal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String [] UserData = new String[6];

    Button invisibleProceedPayment;
    Button submitButton;
    EditText nameEditText;
    EditText surnameEditText;
    EditText addressEditText;
    EditText regnumEditText;
    EditText booknumEdiText;
    EditText durationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        invisibleProceedPayment = (Button) findViewById(R.id.invisiblePaymentButton);
        invisibleProceedPayment.setVisibility(View.INVISIBLE);
        submitButton = (Button) findViewById(R.id.submitButton);
        nameEditText = (EditText) findViewById(R.id.firstNameEditText);
        surnameEditText = (EditText) findViewById(R.id.lastNameEditText);
        addressEditText = (EditText) findViewById(R.id.addressEditText);
        regnumEditText = (EditText) findViewById(R.id.vehicleRegNumEditText);
        booknumEdiText = (EditText) findViewById(R.id.vehicleBookNumEditText);
        durationEditText = (EditText) findViewById(R.id.paymentDurationEditText);

        try {
            Intent intent = getIntent();
            String toggle = intent.getStringExtra(Registration.TAG);
            if (toggle != null) {
                toggleButtons();
            }
        }catch(Exception e){

        }

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    registerUser();
            }
        });


        invisibleProceedPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Payment.class);
                startActivity(intent);
            }
        });

    }

    public void toggleButtons(){
        if(invisibleProceedPayment.getVisibility() == View.VISIBLE){
            invisibleProceedPayment.setVisibility(View.INVISIBLE);
        }else{
            invisibleProceedPayment.setVisibility(View.VISIBLE);
        }
    }

    public void registerUser(){
        User currentUser = new User();
        UsersDataSource datasource = new UsersDataSource(this);
        datasource.create(currentUser);
        datasource.readUser();
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }

    public class User{
        String name = nameEditText.getText().toString();
        String surname = surnameEditText.getText().toString();
        String vehicle_book_num = booknumEdiText.getText().toString();
        String vehicle_reg_num = regnumEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String payment_duration = durationEditText.getText().toString();


        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getVehicle_book_num() {
            return vehicle_book_num;
        }

        public String getVehicle_reg_num() {
            return vehicle_reg_num;
        }

        public String getAddress() {
            return address;
        }

        public String getPayment_duration() {
            return payment_duration;
        }
    }



}
