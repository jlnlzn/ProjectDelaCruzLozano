package julian.lozano.com.projectdelacruzlozano;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {

    private Button btnSlot1, btnSlot2, btnSlot3, btnSlot4, btnSlot5,
    btnSlot6, btnSlot7, btnSlot8, btnSlot9;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mFirebaseDatabase = FirebaseDatabase.getInstance();

        btnSlot1 = findViewById(R.id.slott1);
        btnSlot2 = findViewById(R.id.slott2);
        btnSlot3 = findViewById(R.id.slott3);
        btnSlot4 = findViewById(R.id.slott4);
        btnSlot5 = findViewById(R.id.slott5);
        btnSlot6 = findViewById(R.id.slott6);
        btnSlot7 = findViewById(R.id.slott7);
        btnSlot8 = findViewById(R.id.slott8);
        btnSlot9 = findViewById(R.id.slott9);




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
                            Intent toOccupy = new Intent(HomeActivity.this, OccupiedActivity.class);
                            startActivity(toOccupy);

                       }else if(value.equals(true)){
                            dataSnapshot.getRef().setValue(false);
                            Intent toSlot = new Intent(HomeActivity.this, SlotActivity.class);
                            startActivity(toSlot);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        slots();
        btnSlot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot2");
                mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(false)) {
                            dataSnapshot.getRef().setValue(true);
                            Intent toOccupy = new Intent(HomeActivity.this, OccupiedActivity.class);
                            startActivity(toOccupy);

                        }else if(value.equals(true)){
                            dataSnapshot.getRef().setValue(false);
                            Intent toSlot = new Intent(HomeActivity.this, SlotActivity.class);
                            startActivity(toSlot);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        slots();
        btnSlot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot3");
                mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(false)) {
                            dataSnapshot.getRef().setValue(true);
                            Intent toOccupy = new Intent(HomeActivity.this, OccupiedActivity.class);
                            startActivity(toOccupy);


                        }else if(value.equals(true)){
                            dataSnapshot.getRef().setValue(false);
                            Intent toSlot = new Intent(HomeActivity.this, SlotActivity.class);
                            startActivity(toSlot);

                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        slots();
        btnSlot4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot4");
                mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(false)) {
                            dataSnapshot.getRef().setValue(true);
                            Intent toOccupy = new Intent(HomeActivity.this, OccupiedActivity.class);
                            startActivity(toOccupy);


                        }else if(value.equals(true)){
                            dataSnapshot.getRef().setValue(false);
                            Intent toSlot = new Intent(HomeActivity.this, SlotActivity.class);
                            startActivity(toSlot);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        slots();
        btnSlot5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot5");
                mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(false)) {
                            dataSnapshot.getRef().setValue(true);
                            Intent toOccupy = new Intent(HomeActivity.this, OccupiedActivity.class);
                            startActivity(toOccupy);

                        }else if(value.equals(true)){
                            dataSnapshot.getRef().setValue(false);
                            Intent toSlot = new Intent(HomeActivity.this, SlotActivity.class);
                            startActivity(toSlot);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        slots();
        btnSlot6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot6");
                mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(false)) {
                            dataSnapshot.getRef().setValue(true);
                            Intent toOccupy = new Intent(HomeActivity.this, OccupiedActivity.class);
                            startActivity(toOccupy);

                        }else if(value.equals(true)){
                            dataSnapshot.getRef().setValue(false);
                            Intent toSlot = new Intent(HomeActivity.this, SlotActivity.class);
                            startActivity(toSlot);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        slots();
        btnSlot7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot7");
                mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(false)) {
                            dataSnapshot.getRef().setValue(true);
                            Intent toOccupy = new Intent(HomeActivity.this, OccupiedActivity.class);
                            startActivity(toOccupy);

                        }else if(value.equals(true)){
                            dataSnapshot.getRef().setValue(false);
                            Intent toSlot = new Intent(HomeActivity.this, SlotActivity.class);
                            startActivity(toSlot);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        slots();
        btnSlot8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot8");
                mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(false)) {
                            dataSnapshot.getRef().setValue(true);
                            Intent toOccupy = new Intent(HomeActivity.this, OccupiedActivity.class);
                            startActivity(toOccupy);

                        }else if(value.equals(true)){
                            dataSnapshot.getRef().setValue(false);
                            Intent toSlot = new Intent(HomeActivity.this, SlotActivity.class);
                            startActivity(toSlot);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        slots();
        btnSlot9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot9");
                mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(false)) {
                            dataSnapshot.getRef().setValue(true);
                            Intent toOccupy = new Intent(HomeActivity.this, OccupiedActivity.class);
                            startActivity(toOccupy);

                        }else if(value.equals(true)){
                            dataSnapshot.getRef().setValue(false);
                            Intent toSlot = new Intent(HomeActivity.this, SlotActivity.class);
                            startActivity(toSlot);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }


    public void slots() {
        mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot");

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                if(value.equals(true)) {
                    btnSlot1.setBackground(getResources().getDrawable(R.drawable.green_button));

                } else if (value.equals(false)) {
                    btnSlot1.setBackground(getResources().getDrawable(R.drawable.red_button));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot2");

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                if(value.equals(true)) {
                    btnSlot2.setBackground(getResources().getDrawable(R.drawable.green_button));

                } else if (value.equals(false)) {
                    btnSlot2.setBackground(getResources().getDrawable(R.drawable.red_button));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot3");

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                if(value.equals(true)) {
                    btnSlot3.setBackground(getResources().getDrawable(R.drawable.green_button));

                } else if (value.equals(false)) {
                    btnSlot3.setBackground(getResources().getDrawable(R.drawable.red_button));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot4");

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                if(value.equals(true)) {
                    btnSlot4.setBackground(getResources().getDrawable(R.drawable.green_button));

                } else if (value.equals(false)) {
                    btnSlot4.setBackground(getResources().getDrawable(R.drawable.red_button));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot5");

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                if(value.equals(true)) {
                    btnSlot5.setBackground(getResources().getDrawable(R.drawable.green_button));

                } else if (value.equals(false)) {
                    btnSlot5.setBackground(getResources().getDrawable(R.drawable.red_button));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot6");

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                if(value.equals(true)) {
                    btnSlot6.setBackground(getResources().getDrawable(R.drawable.green_button));

                } else if (value.equals(false)) {
                    btnSlot6.setBackground(getResources().getDrawable(R.drawable.red_button));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot7");

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                if(value.equals(true)) {
                    btnSlot7.setBackground(getResources().getDrawable(R.drawable.green_button));

                } else if (value.equals(false)) {
                    btnSlot7.setBackground(getResources().getDrawable(R.drawable.red_button));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot8");

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                if(value.equals(true)) {
                    btnSlot8.setBackground(getResources().getDrawable(R.drawable.green_button));

                } else if (value.equals(false)) {
                    btnSlot8.setBackground(getResources().getDrawable(R.drawable.red_button));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mDatabaseReference = mFirebaseDatabase.getReference("ParkingSlot9");

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                if(value.equals(true)) {
                    btnSlot9.setBackground(getResources().getDrawable(R.drawable.green_button));

                } else if (value.equals(false)) {
                    btnSlot9.setBackground(getResources().getDrawable(R.drawable.red_button));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
