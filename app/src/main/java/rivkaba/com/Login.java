package rivkaba.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;


import static android.widget.Toast.*;

public class Login extends AppCompatActivity {

    private Switch switchU;
    private Button passNameBtn;
    private EditText edtName;
    private TextView texMustName;
    private TextView texMustPassWord;
    private EditText edtPassWord;
    private Button forgetN;
    private Button forgetP;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context=this;
        switchU = (Switch) findViewById(R.id.switchUM);
        passNameBtn = (Button) findViewById(R.id.passName);
        edtName = (EditText) findViewById(R.id.editUserName);
        edtPassWord= (EditText) findViewById(R.id.editPassWord);
        texMustPassWord = (TextView) findViewById(R.id.mustFileP);
        texMustName = (TextView) findViewById(R.id.mustFileU);
        forgetN=(Button) findViewById(R.id.forgetn);
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
        passNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtName.getText().toString().equals("")) {
                    texMustName.setVisibility(View.VISIBLE);
                    edtName.setHintTextColor(getResources().getColor(R.color.colorEror));
                }
                else
                if(texMustName.getVisibility()== View.VISIBLE &&!edtName.getText().toString().equals(""))
                    texMustName.setVisibility(View.INVISIBLE);
               if(edtPassWord.getText().toString().equals("")) {
                   texMustPassWord.setVisibility(View.VISIBLE);
                   edtPassWord.setHintTextColor(getResources().getColor(R.color.colorEror));
               }
               else
               if(texMustPassWord.getVisibility()== View.VISIBLE &&!edtPassWord.getText().toString().equals(""))
                   texMustPassWord.setVisibility(View.INVISIBLE);
               if(!edtName.getText().toString().equals("")&&!edtPassWord.getText().toString().equals("")) {
                       // String myName = edtName.getText().toString();
                       // SharedPreferences.Editor editorName = getSharedPreferences("name", MODE_PRIVATE).edit();
                       // editorName.putString("name_key", myName);
                      //  editorName.apply();

                        /*    Intent intent = new Intent(Login.this, Home.class);
                            intent.putExtra("user",switchU.getText());
                            startActivity(intent);*/
                   Intent intent = new Intent(Login.this, Video_View.class);
                   startActivity(intent);
                   }
        }

        });
        forgetN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"ברצינות????", Toast.LENGTH_LONG).show();

            }

        });

                forgetP.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"אוללה מה אתה אומר????", Toast.LENGTH_LONG).show();
                    }

                });
                    }
            }



