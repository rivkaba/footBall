package rivkaba.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;

public class Calendar extends AppCompatActivity {
    private String user;
    private RadioButton showCalender;
    private ScrollView calender;
    private Button su;
    private Button mo;
    private Button tu;
    private Button w;
    private Button th;
    private Button fr;
    private Button sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        user=getIntent().getExtras().getString("user");
        showCalender = (RadioButton) findViewById(R.id.radioButtonShowCalender);
        calender = (ScrollView) findViewById(R.id.ScrollViewCalender);
        su = (Button) findViewById(R.id.btnSu);
        mo = (Button) findViewById(R.id.btnMo);
        tu = (Button) findViewById(R.id.btnTu);
        w = (Button) findViewById(R.id.btnW);
        th = (Button) findViewById(R.id.btnTh);
        fr = (Button) findViewById(R.id.btnFr);
        sa = (Button) findViewById(R.id.btnSa);

        //  showCalender.setOnClickListener(View.OnClickListener
        // );
       su.setOnClickListener(new Listener());
        mo.setOnClickListener(new Listener());
        tu.setOnClickListener(new Listener());
        w.setOnClickListener(new Listener());
        th.setOnClickListener(new Listener());
        fr.setOnClickListener(new Listener());
        sa.setOnClickListener(new Listener());
    }
    private class Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent i=new Intent(Calendar.this,Home.class);
            if(v.getId()==R.id.btnSu)
                i.putExtra("day","su");
            else
            if(v.getId()==R.id.btnMo)
                i.putExtra("day","mo");
            else
            if(v.getId()==R.id.btnTu)
                i.putExtra("day","tu");
            else
            if(v.getId()==R.id.btnW)
                i.putExtra("day","w");
            else
            if(v.getId()==R.id.btnTh)
                i.putExtra("day","th");
            else
            if(v.getId()==R.id.btnFr)
                i.putExtra("day","fr");
            else
            if(v.getId() == R.id.btnSa)
                i.putExtra("day","sa");
            i.putExtra("user",user);

            startActivity(i);
        }
        }
    }