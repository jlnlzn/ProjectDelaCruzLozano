package julian.lozano.com.projectdelacruzlozano;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class SlotActivity extends AppCompatActivity {

    private EditText etContactName, etEmail, etPlateNumber;

    private Button btnToContact, btnBackHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot);

        btnToContact = findViewById(R.id.toContact);
        btnBackHome = findViewById(R.id.backHome);

        initializeViews();

        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome = new Intent(SlotActivity.this, HomeActivity.class);
                startActivity(toHome);
            }
        });
    }

    private void initializeViews() {
        btnToContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etContactName = findViewById(R.id.contactName);
                etEmail = findViewById(R.id.emailAdd);
                etPlateNumber = findViewById(R.id.plateNumber);

                HashMap<String, String> register_values = new HashMap<>();
                if (!TextUtils.isEmpty(etContactName.getText()) && !TextUtils.isEmpty(etEmail.getText()) && !TextUtils.isEmpty(etPlateNumber.getText())) {
                    register_values.put("userName", etContactName.getText().toString());
                    register_values.put("userPlateNumber", etPlateNumber.getText().toString());
                    register_values.put("userEmail", etEmail.getText().toString());

                    Intent toContact = new Intent(SlotActivity.this, ContactActivity.class);

                    toContact.putExtra("previousValues", register_values);
                    toContact.putExtra("callingClass", "SlotActivity.java");

                    startActivity(toContact);
                } else {
                    Toast.makeText(SlotActivity.this, "Complete the details.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
