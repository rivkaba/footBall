package rivkaba.com;

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

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private Switch switchU;
    private Button signIn;
    private EditText editEmaill;
    private TextView texMustEmail;
    private TextView texMustPassWord;
    private EditText edtPassWord;
    private Button forgetP;
    private Context context;
    private Button singUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context=this;
        switchU = (Switch) findViewById(R.id.switchUM);
        signIn = (Button) findViewById(R.id.signIn);
        editEmaill = (EditText) findViewById(R.id.editEmaill);
        edtPassWord= (EditText) findViewById(R.id.editPassWord);
        texMustPassWord = (TextView) findViewById(R.id.mustFileP);
        texMustEmail = (TextView) findViewById(R.id.mustFileE);
        singUp= (Button) findViewById(R.id.singUp);

        forgetP=(Button) findViewById(R.id.forgrtp);
        switchU.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    switchU.setText("Manegment");
                  // R.string.user;
                }

                else
                    switchU.setText("User");

            }


        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(editEmaill.getText().toString().equals("")) {
                    texMustEmail.setVisibility(View.VISIBLE);
                    editEmaill.setHintTextColor(getResources().getColor(R.color.colorEror));
                }
                 else
                if(texMustEmail.getVisibility()== View.VISIBLE &&!editEmaill.getText().toString().equals(""))
                    texMustEmail.setVisibility(View.INVISIBLE);
               if(edtPassWord.getText().toString().equals("")) {
                   texMustPassWord.setVisibility(View.VISIBLE);
                   edtPassWord.setHintTextColor(getResources().getColor(R.color.colorEror));
               }
               else
               if(texMustPassWord.getVisibility()== View.VISIBLE &&!edtPassWord.getText().toString().equals(""))
                   texMustPassWord.setVisibility(View.INVISIBLE);
                if(!Patterns.EMAIL_ADDRESS.matcher(editEmaill.getText().toString()).matches())
                    editEmaill.setError("invalid email");
               else if(!editEmaill.getText().toString().equals("")&&!edtPassWord.getText().toString().equals("")) {






                       // String myName = edtName.getText().toString();
                       // SharedPreferences.Editor editorName = getSharedPreferences("name", MODE_PRIVATE).edit();
                       // editorName.putString("name_key", myName);
                      //  editorName.apply();

                   Intent intent = new Intent(Login.this, Home.class);
                   intent.putExtra("user",switchU.getText());
                   startActivity(intent);

                 }

        }

        });

                forgetP.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"אוללה מה אתה אומר????", Toast.LENGTH_LONG).show();
                    }

                });
        singUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Profile.class);
                startActivity(intent);
            }

        });
                    }
            }



