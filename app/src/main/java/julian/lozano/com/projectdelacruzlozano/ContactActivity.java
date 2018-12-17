package julian.lozano.com.projectdelacruzlozano;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class ContactActivity extends AppCompatActivity {

    HashMap<String, String> previousValues;

    private Button btnToSlot, btnSave;
    private TextView txtContact, txtName, txtPlate;
    DatabaseReference mDatabaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        txtName = findViewById(R.id.name);
        txtPlate = findViewById(R.id.plate);
        txtContact = findViewById(R.id.email);

        btnSave = findViewById(R.id.save);
        btnToSlot = findViewById(R.id.toSlot);

        Intent fromRegisterTwoIntent = getIntent();

        initializeViews();

        checkPreviousIntent(fromRegisterTwoIntent);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDetails();
            }
        });

    }

    private void initializeViews() {
        Intent fromSlotActivity = getIntent();

        if (fromSlotActivity != null) {
            previousValues = (HashMap<String, String>) fromSlotActivity.getSerializableExtra("previousValues");

            txtName = findViewById(R.id.name);
            txtName.setText(previousValues.get("userName"));

            txtPlate = findViewById(R.id.plate);
            txtPlate.setText(previousValues.get("userPlateNumber"));

            txtContact = findViewById(R.id.email);
            txtContact.setText(previousValues.get("userEmail"));

            mDatabaseReference = FirebaseDatabase.getInstance().getReference("ContactDetails");

            btnToSlot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent toSlot = new Intent(ContactActivity.this, SlotActivity.class);

                    toSlot.putExtra("previousValues", previousValues);
                    toSlot.putExtra("callingClass", "SlotActivity.java");

                    startActivity(toSlot);
                }
            });

        } else {
            Toast.makeText(ContactActivity.this, "Previous intent is empty.", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveDetails() {
        String contact_uid = mDatabaseReference.push().getKey();
        ContactDetails details = new ContactDetails(contact_uid, previousValues.get("userName"),
                previousValues.get("userPlateNumber"), previousValues.get("userEmail"));
        mDatabaseReference.child(contact_uid).setValue(details);
        Toast.makeText(ContactActivity.this, "Contact was saved.", Toast.LENGTH_SHORT).show();
        Intent toHome = new Intent(ContactActivity.this, HomeActivity.class);
        startActivity(toHome);
    }
    private void checkPreviousIntent (Intent intent) {
        String callingClass = intent.getStringExtra("callingClass");

        System.out.println(callingClass);

        if (callingClass != null && callingClass.equals("SlotActivity.java")) {
            HashMap<String, String> previousHashMap = (HashMap<String, String>) intent.getSerializableExtra("previousValues");

            txtName.setText(previousHashMap.get("userName"));
            txtPlate.setText(previousHashMap.get("userPlateNumber"));
            txtContact.setText(previousHashMap.get("userEmail"));
        }
    }
}
