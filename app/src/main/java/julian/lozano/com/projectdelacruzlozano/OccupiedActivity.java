package julian.lozano.com.projectdelacruzlozano;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OccupiedActivity extends AppCompatActivity {
    private Button btnGoVacate, btnContact, btnBackHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_occupied);


        btnGoVacate = findViewById(R.id.goVacate);
        btnContact = findViewById(R.id.contact);
        btnBackHome = findViewById(R.id.backHome);

        btnGoVacate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toVacate = new Intent(OccupiedActivity.this, VacateConfirmActivity.class);
                startActivity(toVacate);
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toContact = new Intent(OccupiedActivity.this, ContactActivity.class);
                startActivity(toContact);
            }
        });

        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toHome = new Intent(OccupiedActivity.this, HomeActivity.class);
                startActivity(toHome);
            }
        });
    }
}
