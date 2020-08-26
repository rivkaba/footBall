package rivkaba.com;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.VideoView;

public class Video_View extends AppCompatActivity {
    private VideoView videoView;
    private ImageButton ply;
    private Uri videoUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video__view);
        videoView=(VideoView)findViewById(R.id.videoView2);
        ply=(ImageButton)findViewById(R.id.ply);
        videoUri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/football-b0d61.appspot.com/o/MVI_1085.MOV?alt=media&token=49923e04-c9e1-4c55-87b9-1dc5b8a3d651");
        videoView.setVideoURI(videoUri);
        videoView.requestFocus();
        videoView.start();

    }
}
