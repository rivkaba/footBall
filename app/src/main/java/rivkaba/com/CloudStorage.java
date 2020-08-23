package rivkaba.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class CloudStorage extends AppCompatActivity {
    private FirebaseFirestore ff;
    private static final  int REQUEST_CODE=101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloud_storage);
        ff= FirebaseFirestore.getInstance();
        if(ff.getCurrentUser()!=null)
        {
            startActivity(new Intent(this,UploadVideo.class));
            finish();
        }else {
            authenticateUser();
        }
        }
       private void authenticateUser(){
        List<AuthUI.IdpConfig> providers=new ArrayList<>();
           providers.add(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build());

    }
    }

