package rivkaba.com;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Home extends AppCompatActivity {

    private ImageButton calenderBtn;
    private ImageButton filterBtn;
    private ImageButton profileBtn;
    private ListView listView;
    private String user;
    private TextView textViewUser;
    private TextView textViewCale;
    private Spinner spinnerManegment;
    private String calender;
    private Button btnCheckTheHoers;
    private LinearLayout hour;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        user=getIntent().getExtras().getString("user");
        listView = findViewById(R.id.vidieoList);
        profileBtn= findViewById(R.id.profileBtn);
        filterBtn= findViewById(R.id.filterBtn);
        calenderBtn = findViewById(R.id.imageButtonCalendar);
        textViewUser=(TextView) findViewById(R.id.textViewUser);
        textViewUser.setText(user);
        textViewCale=(TextView) findViewById(R.id.textViewCale);
        btnCheckTheHoers=(Button)findViewById(R.id.btnCheckTheHoers);
        hour=(LinearLayout) findViewById(R.id.hour);
        if(getIntent().getExtras().getString("day")!=null) {
            calender =  getIntent().getExtras().getString("day");
            textViewCale.setText(calender);
            hour.setVisibility(View.VISIBLE);
        }
        spinnerManegment=(Spinner) findViewById(R.id.spinnerManegment);
        if(user.equals("Manegment"))
            spinnerManegment.setVisibility(View.VISIBLE);
        calenderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Calendar.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
        filterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Home.this, Filter.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Home.this, Profile.class);
                startActivity(intent);
            }
        });
        btnCheckTheHoers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Home.this, Profile.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuItem privateState = menu.add("profile");
        MenuItem exitMenu = menu.add("Exit");

        privateState.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                privateState();
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
                Toast.makeText(Home.this, "Bye Bye ...", Toast.LENGTH_LONG).show();
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

    private void privateState() {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

}

