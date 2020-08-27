package rivkaba.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

public class Video_View extends AppCompatActivity {
    private TextView durationTimer;
    private TextView currentTimer;
    private VideoView videoView;
    private ImageButton play;
    private Uri videoUri;
    private boolean isPlaying = false;
    private int current = 0;
    private int duration = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video__view);
        durationTimer = (TextView) findViewById(R.id.duration);
        currentTimer = (TextView) findViewById(R.id.current);
        videoView = (VideoView) findViewById(R.id.videoView2);
        play = (ImageButton) findViewById(R.id.ply);
        videoUri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/football-b0d61.appspot.com/o/video.mp4?alt=media&token=0b639468-c1b7-4622-b247-1f4816c8396e");
        videoView.setVideoURI(videoUri);
        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                duration = mediaPlayer.getDuration() / 1000;
                String durationString = String.format("%02d:%02d", duration / 60, duration % 60);
                durationTimer.setText(durationString);
            }

        });
        videoView.start();
        isPlaying = true;
        play.setImageResource(R.mipmap.pause_action);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    videoView.pause();
                    play.setImageResource(R.mipmap.play_action);
                } else {
                    videoView.start();
                    play.setImageResource(R.mipmap.pause_action);
                }
            }
        });

    }

    public class VideoProgress extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            do{
                current=videoView.getCurrentPosition()/1000;
                try{
                    int currentProgress=current*100/duration;
                }

            }
            return null;
        }
    }
}



