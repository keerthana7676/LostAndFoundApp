package com.example.found;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ReportLostActivity extends AppCompatActivity {

    EditText etItemName, etLocation, etDescription, etContact;
    Button btnSubmitLost;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_lost);

        etItemName = findViewById(R.id.etItemName);
        etLocation = findViewById(R.id.etLocation);
        etDescription = findViewById(R.id.etDescription);
        etContact = findViewById(R.id.etContact);
        btnSubmitLost = findViewById(R.id.btnSubmitLost);

        dbHelper = new DatabaseHelper(this);

        btnSubmitLost.setOnClickListener(v -> {
            String name = etItemName.getText().toString();
            String location = etLocation.getText().toString();
            String desc = etDescription.getText().toString();
            String contact = etContact.getText().toString();

            if (name.isEmpty() || location.isEmpty() || desc.isEmpty() || contact.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                boolean inserted = dbHelper.insertLostItem(name, location, desc, contact, "Lost");

                if (inserted) {
                    Toast.makeText(this, "Lost item reported!", Toast.LENGTH_SHORT).show();
                    etItemName.setText("");
                    etLocation.setText("");
                    etDescription.setText("");
                    etContact.setText("");
                } else {
                    Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
