package julian.lozano.com.projectdelacruzlozano;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    ViewPager mViewPager;
    private FirebaseAuth mAuth;
    Button btnLogin;
    EditText etEmail;
    EditText etPassword;
    Button btnSignup;
    EditText etSignupEmail;
    EditText etSignupPassword;
    EditText etSignupConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        btnLogin = findViewById(R.id.btnLogin);
        etEmail =  findViewById(R.id.email);
        etPassword = findViewById(R.id.password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logIn();
            }
        });
    }
    public void logIn(){
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if(email.isEmpty()){
            etEmail.setError("Please enter email");
            return;
        }

        if(password.isEmpty()){
            etPassword.setError("Please enter password");
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent toHome = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(toHome);
                        }else{
                            Toast.makeText(LoginActivity.this, "Login Failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
   }
}
