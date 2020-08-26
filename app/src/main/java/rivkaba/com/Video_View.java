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
        videoUri= Uri.parse("gs://football-b0d61.appspot.com/MVI_1085.MOV");
        videoView.setVideoURI(videoUri);
        videoView.requestFocus();
        videoView.start();

    }
}
