package rivkaba.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;

public class Calendar extends AppCompatActivity {

private RadioButton showCalender;
private ScrollView calender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        showCalender=(RadioButton) findViewById(R.id.radioButtonShowCalender);
        calender=(ScrollView) findViewById(R.id.ScrollViewCalender);
      //  showCalender.setOnClickListener(View.OnClickListener
       // );


    }
}
