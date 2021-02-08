package rivkaba.com;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends Activity {

    private Switch switchU;
    private Button signIn;
    private EditText editEmaill;
    private TextView texMustEmail;
    private TextView texMustPassWord;
    private EditText edtPassWord;
    private Button forgetP;
    private Context context;
    private Button singUp;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = this;
        switchU = findViewById(R.id.switchUM);
        signIn = findViewById(R.id.signIn);
        editEmaill = findViewById(R.id.editEmaill);
        edtPassWord = findViewById(R.id.editPassWord);
        texMustPassWord = findViewById(R.id.mustFileP);
        texMustEmail = findViewById(R.id.mustFileE);
        singUp = findViewById(R.id.singUp);
        forgetP = (Button) findViewById(R.id.forgrtp);
        mAuth = FirebaseAuth.getInstance();

        switchU.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    switchU.setText("Management");
                    // R.string.user;
                } else
                    switchU.setText("User");

            }


        });

        forgetP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "אוללה מה אתה אומר????", Toast.LENGTH_LONG).show();
            }

        });
        singUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Profile.class);
                startActivity(intent);
                finish();
            }

        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editEmaill.getText().toString().equals("")) {
                    texMustEmail.setVisibility(View.VISIBLE);
                    editEmaill.setHintTextColor(getResources().getColor(R.color.colorEror));
                } else if (texMustEmail.getVisibility() == View.VISIBLE && !editEmaill.getText().toString().equals(""))
                    texMustEmail.setVisibility(View.INVISIBLE);
                if (edtPassWord.getText().toString().equals("")) {
                    texMustPassWord.setVisibility(View.VISIBLE);
                    edtPassWord.setHintTextColor(getResources().getColor(R.color.colorEror));
                } else if (texMustPassWord.getVisibility() == View.VISIBLE && !edtPassWord.getText().toString().equals(""))
                    texMustPassWord.setVisibility(View.INVISIBLE);
                if (!Patterns.EMAIL_ADDRESS.matcher(editEmaill.getText().toString()).matches())
                    editEmaill.setError("invalid email");
                else if (!editEmaill.getText().toString().equals("") && !edtPassWord.getText().toString().equals("")) {
                    Loginn();

                }

                // String myName = edtName.getText().toString();
                // SharedPreferences.Editor editorName = getSharedPreferences("name", MODE_PRIVATE).edit();
                // editorName.putString("name_key", myName);
                //  editorName.apply();


            }
        });
    }
    private void Loginn(){
        mAuth.signInWithEmailAndPassword(editEmaill.getText().toString(),edtPassWord.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(Login.this,"Successfully SingIn",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Login.this, Home.class);
                            startActivity(intent);
                            finish();
                            //   FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //  Log.w("emil", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Login.this, "SignIn failed.",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login.this, Login.class);
                            startActivity(intent);
                            // updateUI(null);
                        }


                    }
                });
    }
}











