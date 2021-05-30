package com.group3.license;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button register;
    private EditText firstname,lastname,midname,bday,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button
        register = findViewById(R.id.regBtn);
        //edit text
        firstname = findViewById(R.id.fname);
        lastname = findViewById(R.id.lname);
        midname = findViewById(R.id.mname);
        bday = findViewById(R.id.bday);
        address = findViewById(R.id.address);
        //onClick Listener
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String lname = firstname.getText().toString();
                String fname = lastname.getText().toString();
                String mname = midname.getText().toString();
                String addressVal = address.getText().toString();
                String birthday = bday.getText().toString();

                if(lname.isEmpty() && fname.isEmpty()  && mname.isEmpty()  && addressVal.isEmpty()  && birthday.isEmpty()){
                    Toast.makeText(MainActivity.this,"Fill up Form",Toast.LENGTH_LONG).show();
                }else{

                    Intent intent = new Intent(MainActivity.this,LicenseActivity.class);
                    intent.putExtra("Name", lname+fname+mname);
                    intent.putExtra("Address", addressVal);
                    intent.putExtra("Birthday", birthday);

                    startActivity(intent);
                    finish();

                }

            }
        });
    }
}