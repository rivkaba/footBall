package rivkaba.com;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.VideoView;

import java.util.HashMap;
import java.util.Map;

public class Video {
    private  int start;

    public Video(int start) {
        this.start = start;
    }

    public void clone(Map<String, Object> data){
        this.start = (int) data.get("start");

    }
    public HashMap<String, Object> toMap(){
        HashMap<String, Object> fm = new HashMap();
        fm.put("start", this.start);
        return fm;
    }
}
