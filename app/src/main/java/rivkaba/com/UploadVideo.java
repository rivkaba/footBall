package rivkaba.com;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import javax.annotation.Nullable;

public class UploadVideo extends AppCompatActivity {
    private  static  final int PICK_VIDEO_REQUEST=1;
private Button buttonChoose;
private Button buttonUpload;
private VideoView videoView;
private Uri videoUri;
private EditText videoName;
private  EditText videoType;
private ProgressBar progressBar;
MediaController mediaController;
private StorageReference storageReference;
private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_video);
        buttonChoose=findViewById(R.id.buttonChoose);
        buttonUpload=findViewById(R.id.buttonUpload);
        videoView=findViewById(R.id.videoView);
        progressBar=findViewById(R.id.progressBar);
        videoName=findViewById(R.id.videoName);
        videoType=findViewById(R.id.videoType);
        mediaController=new MediaController(this);
        storageReference= FirebaseStorage.getInstance().getReference("videos");
        databaseReference= FirebaseDatabase.getInstance().getReference("videos");
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
        buttonChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseVideo();
            }
        });

        buttonUpload .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadvideo();
            }
        });
            }
            private void  ChooseVideo() {
                Intent intent = new Intent();
                intent.setType("video/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, PICK_VIDEO_REQUEST);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){

        super.onActivityResult(requestCode, resultCode,data);
          if(requestCode==PICK_VIDEO_REQUEST && resultCode==RESULT_OK && data !=null && data.getData()!=null);
            videoUri=data.getData();
            videoView.setVideoURI(videoUri);
}
private  String getfileExt(Uri videoUri){
    ContentResolver contentResolver= getContentResolver();
    MimeTypeMap mimeTypeMap =MimeTypeMap.getSingleton();
    return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(videoUri));
}
private void Uploadvideo(){
    if(videoUri!=null){
        StorageReference reference=storageReference.child(System.currentTimeMillis()+"."+getfileExt(videoUri));
    reference.putFile(videoUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
        @Override
        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
          //  progressBar.setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(),"Upload successuful",Toast.LENGTH_SHORT).show();
            Video video=new Video (videoName.getText().toString().trim(),videoType.getText().toString().trim(),videoView.getDuration() / 1000,taskSnapshot.getUploadSessionUri().toString());
         String upload = databaseReference.push().getKey();
         databaseReference.child(upload).setValue(video);
        }
    }).addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

        }
    });


    }else {
        Toast.makeText(getApplicationContext(),"No file seleccted",Toast.LENGTH_SHORT).show();
    }
}
}