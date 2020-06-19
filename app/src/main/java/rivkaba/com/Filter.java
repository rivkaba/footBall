package rivkaba.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Filter extends AppCompatActivity {
 private List <CheckBox> trainingType;
 private TableLayout TableLayoutCh;
 private CheckBox checkBoxAll;
 private Switch switchUser;
 private TextView textViewTrainingType;
 private String user;
 private TextView textViewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        user=getIntent().getExtras().getString("user");
        textViewTrainingType=(TextView)findViewById(R.id.textViewTrainingType);
        switchUser=(Switch) findViewById(R.id.switchUM);
        checkBoxAll=(CheckBox) findViewById(R.id.checkBoxAll);
        TableLayoutCh = (TableLayout) findViewById(R.id.tableLayoutCh);
        textViewUser=(TextView) findViewById(R.id.textViewUser);
        textViewUser.setText(user);
      //  switchUser.setText("yyyyy");
       // if(switchUser.isChecked())
        //    textViewTrainingType.setText("ples press on the type of the add vidio");
        trainingType=new ArrayList ();
        trainingType.add((CheckBox) findViewById(R.id.checkBoxFootWork));
        trainingType.add((CheckBox) findViewById(R.id.checkBoxFirstTocth));
        trainingType.add((CheckBox) findViewById(R.id.checkBoxDriblling));
        trainingType.add((CheckBox) findViewById(R.id.checkBoxDeffending));
        trainingType.add((CheckBox) findViewById(R.id.checkBoxShooting));
        trainingType.add((CheckBox) findViewById(R.id.checkBox1on1));
        trainingType.add((CheckBox) findViewById(R.id.checkBoxPassing));

       // checkBoxAll.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener(new View.O));

        checkBoxAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBoxAll.isChecked()==true)
                   for(int i=0; i<trainingType.size() ;i++)
                         trainingType.get(i).setChecked(true);
                   else
                    for(int i=0; i<trainingType.size() ;i++)
                        trainingType.get(i).setChecked(false);

            }
    });
        }
    }

