package com.tsitsi.jmtvehiclelicenserenewal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tsits on 11/03/17.
 */

public class Payment extends AppCompatActivity {
    Button payReceipt;
    TextView regnum;
    TextView months;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_receipt);

        payReceipt = (Button) findViewById(R.id.payReceiptButton);
        regnum = (TextView) findViewById(R.id.actualPaymentRegNumTextView);
        months = (TextView) findViewById(R.id.actualPaymentRegDurationTextview);

        regnum.setText(MainActivity.UserData[3]);
        months.setText(MainActivity.UserData[4]);

        payReceipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Payment.this, "Payment successful", Toast.LENGTH_LONG).show();
            }
        });
    }
}
