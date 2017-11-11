package com.tsitsi.jmtvehiclelicenserenewal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by tsits on 11/03/17.
 */

public class Registration extends AppCompatActivity {
    public static final String TAG = "TOGGLE" ;
    Button editRecords;
    Button proceedPayment;
    TextView name;
    TextView surname;
    TextView booknum;
    TextView regnum;
    TextView duration;
    TextView address;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_succesful);
        editRecords = (Button) findViewById(R.id.editRecordButton);
        proceedPayment = (Button) findViewById(R.id.proceedPaymentButton);
        name = (TextView) findViewById(R.id.actualNameTextview);
        surname = (TextView) findViewById(R.id.actualSurnameTextView);
        booknum = (TextView) findViewById(R.id.actualBookNumTextView);
        regnum = (TextView) findViewById(R.id.actualRegNumTextview);
        duration = (TextView) findViewById(R.id.actualMonthsTextView);
        address = (TextView) findViewById(R.id.actualAddressTextView);

        name.setText(MainActivity.UserData[0]);
        surname.setText(MainActivity.UserData[1]);
        booknum.setText(MainActivity.UserData[2]);
        regnum.setText(MainActivity.UserData[3]);
        duration.setText((MainActivity.UserData[4]));
        address.setText(MainActivity.UserData[5]);

        editRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this, MainActivity.class);
                intent.putExtra(TAG, "toggle");
                startActivity(intent);
            }
        });

        proceedPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePayment();
            }
        });

    }

    public void makePayment(){
        Intent intent = new Intent(this, Payment.class);
        startActivity(intent);
    }
}
