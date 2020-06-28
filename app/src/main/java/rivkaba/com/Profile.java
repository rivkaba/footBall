package rivkaba.com;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        context=this;
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
                    name.setHintTextColor(getResources().getColor(R.color.colorEror));
                }
                else
                if(texMustName.getVisibility()== View.VISIBLE &&!name.getText().toString().equals(""))
                    texMustName.setVisibility(View.GONE);
                if(email.getText().toString().equals("")) {
                    texMustEmail.setVisibility(View.VISIBLE);
                    email.setHintTextColor(getResources().getColor(R.color.colorEror));
                }
                else
                if(texMustEmail.getVisibility()== View.VISIBLE &&!email.getText().toString().equals(""))
                    texMustEmail.setVisibility(View.GONE);
                if(userName.getText().toString().equals("")) {
                    texMustUserName.setVisibility(View.VISIBLE);
                    userName.setHintTextColor(getResources().getColor(R.color.colorEror));

                }
                else
                if(texMustUserName.getVisibility()== View.VISIBLE &&!userName.getText().toString().equals(""))
                    texMustUserName.setVisibility(View.GONE);
                if(passWord.getText().toString().equals("")) {
                    texMustPassWord.setVisibility(View.VISIBLE);
                    passWord.setHintTextColor(getResources().getColor(R.color.colorEror));

                }
                else
                if(texMustPassWord.getVisibility()== View.VISIBLE &&!passWord.getText().toString().equals(""))
                    texMustPassWord.setVisibility(View.GONE);
                if(!name.getText().toString().equals("")&&!email.getText().toString().equals("")&&!userName.getText().toString().equals("")&&!passWord.getText().toString().equals(""))
                    Toast.makeText(context,"תודה", Toast.LENGTH_LONG).show();
            }

        });
    }
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuItem privateState = menu.add("Call to manegment");
        MenuItem exitMenu = menu.add("Exit");

        privateState.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                CallToManegment();
                return false;
            }
        });

        exitMenu.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                exitApp();
                return false;
            }
        });

        return true;
    }
    private void exitApp() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Exit ");
        alertDialog.setMessage("Do you want to exit ?");
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Profile.this, "Bye Bye ...", Toast.LENGTH_LONG).show();
                finish();  // destroy this activity
                //System.exit(0);
                //  android.os.Process.killProcess(android.os.Process.myPid());
                moveTaskToBack(true);



            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // close the dialog
            }
        });
        alertDialog.show();
    }

    private void CallToManegment() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Exit ");
        alertDialog.setMessage("Do you want to Call to manegment ?");
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Profile.this, Home.class);
                startActivity(intent);
                //  android.os.Process.killProcess(android.os.Process.myPid());
                //moveTaskToBack(true);

            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // close the dialog
            }
        });
        alertDialog.show();

    }
}