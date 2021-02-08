package rivkaba.com;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Profile extends AppCompatActivity {
    private TextView texMustName;
    private TextView texMustEmail;
    private TextView texMustConfirmPassWord;
    private TextView texMustPassWord;
    private TextView confirmPassWordL;
    private Button save;
    private EditText name;
    private EditText email;
    private EditText passWord;
    private EditText confirmPassWord;
    private Context context;
    private Button singIn;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        context=this;
        mAuth = FirebaseAuth.getInstance();
        save =  findViewById(R.id.Save);
        texMustName =  findViewById(R.id.mustFileN);
        texMustEmail =  findViewById(R.id.mustFileE);
        texMustConfirmPassWord =  findViewById(R.id.mustFileCP);
        texMustPassWord =  findViewById(R.id.mustFileP);
        name =  findViewById(R.id.Name);
        email =  findViewById(R.id.Email);
        confirmPassWordL= findViewById(R.id.confirmPassWordL);
        passWord =  findViewById(R.id.PassWord);
        singIn =  findViewById(R.id.singInn);
        confirmPassWord= findViewById(R.id.confirmPassWord);

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
                if(confirmPassWord.getText().toString().equals("")) {
                    texMustConfirmPassWord.setVisibility(View.VISIBLE);
                    confirmPassWord.setHintTextColor(getResources().getColor(R.color.colorEror));

                }
                else
                if(texMustConfirmPassWord.getVisibility()== View.VISIBLE &&!confirmPassWord.getText().toString().equals(""))
                    texMustConfirmPassWord.setVisibility(View.GONE);
                if(passWord.getText().toString().equals("")) {
                    texMustPassWord.setVisibility(View.VISIBLE);
                    passWord.setHintTextColor(getResources().getColor(R.color.colorEror));

                }
                else
                if(texMustPassWord.getVisibility()== View.VISIBLE &&!passWord.getText().toString().equals(""))
                    texMustPassWord.setVisibility(View.GONE);
                if(!name.getText().toString().equals("")&&!email.getText().toString().equals("")&&!confirmPassWord.getText().toString().equals("")&&!passWord.getText().toString().equals("")) {
                    Toast.makeText(Profile.this, name.getText().toString()+email.getText().toString()+passWord.getText().toString()+confirmPassWord.getText().toString(), Toast.LENGTH_LONG).show();
                    Register();

                }
            }

        });
        singIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, Login.class);
                startActivity(intent);
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
                FirebaseAuth.getInstance().signOut();
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
        singIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, Login.class);
                startActivity(intent);
                finish();
            }

        });


    }
    private void Register(){
        String emaill=email.getText().toString();
        String passWordd=passWord.getText().toString();
        String confirmPassWordd= confirmPassWord.getText().toString();
        if(!passWordd.equals(confirmPassWordd))
            confirmPassWord.setError("Different password");
       else if (passWordd.length()<4)
            passWord.setError("Length should be >4");
        else if(!Patterns.EMAIL_ADDRESS.matcher(emaill).matches())
            email.setError("invalid email");
        else  {
            mAuth.createUserWithEmailAndPassword(emaill, passWordd)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(Profile.this,"Successfully registered",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Profile.this, Login.class);
                                startActivity(intent);
                                finish();
                             //   FirebaseUser user = mAuth.getCurrentUser();
                                //updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                              //  Log.w("emil", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(Profile.this, "SignnUp failed.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Profile.this, Profile.class);
                                startActivity(intent);
                               // updateUI(null);
                            }


                        }
                    });
        }
       // Toast.makeText(context, "תודה", Toast.LENGTH_LONG).show();

}

   /*   @Override
  public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
       // singIn.callOnClick();?????????????????????????????????????????????????????????????????????????????????????

    }*/

}