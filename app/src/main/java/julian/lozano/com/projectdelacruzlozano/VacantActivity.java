package julian.lozano.com.projectdelacruzlozano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VacantActivity extends AppCompatActivity {

    private Button btnToOccupied, btnBackHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacant);

        btnBackHome = findViewById(R.id.backHome);
        btnToOccupied = findViewById(R.id.toOccupied);

        btnToOccupied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toOccupied = new Intent(VacantActivity.this, SlotActivity.class);
                startActivity(toOccupied);
            }
        });

        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backHome = new Intent(VacantActivity.this, HomeActivity.class);
                startActivity(backHome);
            }
        });
    }
}
