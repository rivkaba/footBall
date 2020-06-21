package rivkaba.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    private TextView texMustName;
    private TextView texMustEmail;
    private TextView texMustUserName;
    private TextView texMustPassWord;
    private Button save;
    private EditText name;
    private EditText email;
    private EditText userName;
    private EditText passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        save = (Button) findViewById(R.id.Save);
        texMustName = (TextView) findViewById(R.id.mustFileN);
        texMustEmail = (TextView) findViewById(R.id.mustFileE);
        texMustUserName = (TextView) findViewById(R.id.mustFileU);
        texMustPassWord = (TextView) findViewById(R.id.mustFileP);
        name = (EditText) findViewById(R.id.Name);
        email = (EditText) findViewById(R.id.Email);
        userName = (EditText) findViewById(R.id.UseName);
        passWord = (EditText) findViewById(R.id.PassWord);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("")) {
                    texMustName.setVisibility(View.VISIBLE);
                    //name.setOutlineSpotShadowColor(getResources().getColor(R.color.colorPrimaryDark));
                }
                else
                if(texMustName.getVisibility()== View.VISIBLE &&!name.getText().toString().equals(""))
                    texMustName.setVisibility(View.INVISIBLE);
                if(email.getText().toString().equals(""))
                    texMustEmail.setVisibility(View.VISIBLE);
                else
                if(texMustEmail.getVisibility()== View.VISIBLE &&!email.getText().toString().equals(""))
                    texMustEmail.setVisibility(View.INVISIBLE);
                if(userName.getText().toString().equals(""))
                    texMustUserName.setVisibility(View.VISIBLE);
                else
                if(texMustUserName.getVisibility()== View.VISIBLE &&!userName.getText().toString().equals(""))
                    texMustUserName.setVisibility(View.INVISIBLE);
                if(passWord.getText().toString().equals(""))
                    texMustPassWord.setVisibility(View.VISIBLE);
                else
                if(texMustPassWord.getVisibility()== View.VISIBLE &&!passWord.getText().toString().equals(""))
                    texMustPassWord.setVisibility(View.INVISIBLE);

            }

        });
    }
}