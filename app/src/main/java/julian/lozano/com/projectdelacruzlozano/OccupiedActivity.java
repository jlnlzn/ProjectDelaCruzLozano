package julian.lozano.com.projectdelacruzlozano;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.http.HTTP;

public class OccupiedActivity extends AppCompatActivity {
    private Button btnGoVacate, btnContact, btnBackHome;
    private TextView txtContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_occupied);

        btnGoVacate = findViewById(R.id.goVacate);
        btnContact = findViewById(R.id.contact);
        txtContact = findViewById(R.id.email);
        btnBackHome = findViewById(R.id.backHome);

        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backHome = new Intent (OccupiedActivity.this, HomeActivity.class);
                startActivity(backHome);
                finish();
            }
        });

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
                Intent sendIntent = new Intent(OccupiedActivity.this, SendSMS.class);
                startActivity(sendIntent);
            }
        });
    }
}
