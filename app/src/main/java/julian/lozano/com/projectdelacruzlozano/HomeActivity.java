package julian.lozano.com.projectdelacruzlozano;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {

    private Button btnSlot1, btnSlott1;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mFirebaseDatabase = FirebaseDatabase.getInstance();

        btnSlot1 = findViewById(R.id.slot1);
        btnSlott1 =findViewById(R.id.slott1);


        slots();
        btnSlot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot");
                mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(false)) {
                            dataSnapshot.getRef().setValue(true);
                            btnSlot1.setVisibility(View.INVISIBLE);
                            btnSlott1.setVisibility(View.VISIBLE);
//                            colorRed();
//                            Intent toVacant = new Intent(HomeActivity.this, VacantActivity.class);
//                            startActivity(toVacant);
                       }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        btnSlott1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot");

                mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if(value.equals(true)) {
                            dataSnapshot.getRef().setValue(false);
                            btnSlot1.setVisibility(View.VISIBLE);
                            btnSlott1.setVisibility(View.INVISIBLE);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                slots();
            }
        });
    }


    public void slots() {
        mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot");

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                if(value.equals(true)) {
                    btnSlot1.setVisibility(View.VISIBLE);
                    btnSlott1.setVisibility(View.INVISIBLE);
                } else if (value.equals(false)) {
                    btnSlot1.setVisibility(View.INVISIBLE);
                    btnSlott1.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void colorGreen() {
        btnSlot1.setBackground(getResources().getDrawable(R.drawable.green_button));
    }
    public void colorRed() {
        btnSlot1.setBackground(getResources().getDrawable(R.drawable.red_button));
    }
}
