package julian.lozano.com.projectdelacruzlozano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VacateConfirmActivity extends AppCompatActivity {

    private Button btnSlot1, btnVacate, btnToOccupied;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacateconfirm);

        btnVacate = findViewById(R.id.vacate);
        btnToOccupied = findViewById(R.id.toOccupied);

        btnVacate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toHome = new Intent(VacateConfirmActivity.this, HomeActivity.class);
                startActivity(toHome);
            }
        });
        btnToOccupied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toOccupied = new Intent(VacateConfirmActivity.this, OccupiedActivity.class);
                startActivity(toOccupied);
            }
        });

    }
}
