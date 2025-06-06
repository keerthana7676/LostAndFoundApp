package com.example.found;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ReportFoundActivity extends AppCompatActivity {

    EditText etItemName, etLocation, etDescription, etContact;
    Button btnSubmit;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_found);

        dbHelper = new DatabaseHelper(this);

        etItemName = findViewById(R.id.etItemName);
        etLocation = findViewById(R.id.etLocation);
        etDescription = findViewById(R.id.etDescription);
        etContact = findViewById(R.id.etContact);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            String name = etItemName.getText().toString();
            String location = etLocation.getText().toString();
            String description = etDescription.getText().toString();
            String contact = etContact.getText().toString();

            if (name.isEmpty() || location.isEmpty() || contact.isEmpty()) {
                Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean inserted = dbHelper.insertLostItem(name, location, description, contact, "Found");

            if (inserted) {
                Toast.makeText(this, "Found item submitted", Toast.LENGTH_SHORT).show();
                etItemName.setText("");
                etLocation.setText("");
                etDescription.setText("");
                etContact.setText("");
            } else {
                Toast.makeText(this, "Failed to submit", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
