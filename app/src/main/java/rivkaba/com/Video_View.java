package rivkaba.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.VideoView;

public class Video_View extends AppCompatActivity {
    private VideoView videoView;
    private ImageButton ply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video__view);
        videoView=(VideoView)findViewById(R.id.videoView2);
        ply=(ImageButton)findViewById(R.id.ply);
    }
}
