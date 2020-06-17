package rivkaba.com;

import androidx.appcompat.app.AppCompatActivity;

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

public class Login extends AppCompatActivity {

    private Switch switchU;
    private Button passNameBtn;
    private EditText edtName;
    private TextView texMustName;
    private TextView texMustPassWord;
    private EditText edtPassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        switchU = (Switch) findViewById(R.id.switchUM);
        passNameBtn = (Button) findViewById(R.id.passName);
        edtName = (EditText) findViewById(R.id.editUserName);
        edtPassWord= (EditText) findViewById(R.id.editPassWord);
        texMustPassWord = (TextView) findViewById(R.id.mustFileP);
        texMustName = (TextView) findViewById(R.id.mustFileU);
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
                if(edtName.getText().toString().equals(""))
                    texMustName.setVisibility(View.VISIBLE);
                else
                if(texMustName.getVisibility()== View.VISIBLE &&!edtName.getText().toString().equals(""))
                    texMustName.setVisibility(View.INVISIBLE);
               if(edtPassWord.getText().toString().equals(""))
                   texMustPassWord.setVisibility(View.VISIBLE);
               else
               if(texMustPassWord.getVisibility()== View.VISIBLE &&!edtPassWord.getText().toString().equals(""))
                   texMustPassWord.setVisibility(View.INVISIBLE);
               if(!edtName.getText().toString().equals("")&&!edtPassWord.getText().toString().equals("")) {
                        String myName = edtName.getText().toString();
                        SharedPreferences.Editor editorName = getSharedPreferences("name", MODE_PRIVATE).edit();
                        editorName.putString("name_key", myName);
                        editorName.apply();
                        Intent intent = new Intent(Login.this, Home.class);
                        startActivity(intent);
                   }
        }

        });
    }



    }


