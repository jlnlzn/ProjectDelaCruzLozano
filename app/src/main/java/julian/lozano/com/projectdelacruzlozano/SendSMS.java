package julian.lozano.com.projectdelacruzlozano;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendSMS extends AppCompatActivity {
    private Button btnSendSms;
    private EditText txtContactNum, txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        if (ContextCompat.checkSelfPermission(SendSMS.this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(SendSMS.this,
                    Manifest.permission.SEND_SMS)) {
                ActivityCompat.requestPermissions(SendSMS.this,
                        new String[]{Manifest.permission.SEND_SMS}, 1);
            } else {
                ActivityCompat.requestPermissions(SendSMS.this,
                        new String[]{Manifest.permission.SEND_SMS}, 1);
            }
        } else {

        }
        btnSendSms = findViewById(R.id.sendMsg);
        txtContactNum = findViewById(R.id.contactNum);
        txtMessage = findViewById(R.id.message);

        btnSendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = txtContactNum.getText().toString();
                String msg = txtMessage.getText().toString();

                try{
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(number, null, msg, null, null);
                    Toast.makeText(SendSMS.this, "Sent!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(SendSMS.this, "Fail!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        switch(requestCode){
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission (SendSMS.this,
                            Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "Permission granted!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "No permission granted!", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}
