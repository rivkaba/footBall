package rivkaba.com;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.VideoView;

public class Video extends AppCompatActivity {
 private VideoView VideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        VideoView=(VideoView) findViewById(R.id.videoView1);
      //  MediaStore.Video.Media mm= MediaStore.Video.Media (this,R.raw.video);
     //   mm.start();
      //  VideoView="https://www.youtube.com/watch?v=2AWLqffzR9k";
        MediaPlayer m=MediaPlayer.create(this,R.raw.song1);
        m.start();
    }
}
