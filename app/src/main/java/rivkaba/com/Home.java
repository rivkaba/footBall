package rivkaba.com;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class Home extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;
    private ImageButton calenderBtn;
    private ImageButton filterBtn;
    private ImageButton profileBtn;
    private ListView vidieoList;
    private String user;
    private TextView textViewUser;
    private TextView textViewCale;
    private Spinner spinnerManegment;
    private String calender;
    private Button btnCheckTheHoers;
    private LinearLayout hour;
    private CheckBox moveUser;
    RecyclerView Mrecyclerview;
    FirebaseDatabase database;
    DatabaseReference reference;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Mrecyclerview=findViewById(R.id.recyeleview_video);
        Mrecyclerview.setHasFixedSize(true);
        Mrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("video");
        user=getIntent().getExtras().getString("user");

        profileBtn= findViewById(R.id.profileBtn);
        filterBtn= findViewById(R.id.filterBtn);
        calenderBtn = findViewById(R.id.imageButtonCalendar);
        textViewUser=(TextView) findViewById(R.id.textViewUser);
        textViewUser.setText(user);
        textViewCale=(TextView) findViewById(R.id.textViewCale);
        btnCheckTheHoers=(Button)findViewById(R.id.btnCheckTheHoers);
        hour=(LinearLayout) findViewById(R.id.hour);
        moveUser=(CheckBox)findViewById(R.id.checkBoxMoveUser);
       // for(int i=0; i<)
      //  vidieoList
        if(getIntent().getExtras().getString("day")!=null) {
            calender =  getIntent().getExtras().getString("day");
            textViewCale.setText(calender);
            hour.setVisibility(View.VISIBLE);
        }
        spinnerManegment=(Spinner) findViewById(R.id.spinnerManegment);
        if(user.equals("Manegment")) {
            spinnerManegment.setVisibility(View.VISIBLE);
            moveUser.setVisibility(View.VISIBLE);
        }
        moveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user="user";
                if(moveUser.isChecked()==true) {
                    Intent intent = new Intent(Home.this, Home.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                }


            }
        });
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
        firebaseFirestore = FirebaseFirestore.getInstance();
        Video video = new Video("2","1 on 1",2.5,   "https://firebasestorage.googleapis.com/v0/b/football-b0d61.appspot.com/o/video.mp4?alt=media&token=0b639468-c1b7-4622-b247-1f4816c8396e");
        writeToDB(video);
    }

    protected void onStart() {
        super.onStart();
 FirebaseRecyclerAdapter<Video,ViewHolder> firebaseRecyclerlerAdapter=
         new FirebaseRecyclerAdapter<Video,ViewHolder>(
         Video.class,
        R.layout.row,
        ViewHolder.class,
        reference
                ){
     protected  void populateViewHolder(ViewHolder viewHolder,Video video,int i){
         viewHolder.setVideo(getApplication(),video.getTitle(),video.getUrl());
     }
         };
        Mrecyclerview.setAdapter(firebaseRecyclerlerAdapter);
    }
    public void writeToDB(Video video){
        Map<String, Object> map =  video.toMap();

        firebaseFirestore.collection("video").document()
                .set(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("", "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("", "Error writing document", e);
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

