package rivkaba.com;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.VideoView;

import java.util.HashMap;
import java.util.Map;

public class Video {
    String title,url;
    private  String name;
    private  String type;
    private  double duration;




    public Video(String name, String type, double duration) {
        this.name=name;
        this.type=type;
        this.duration=duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void clone(Map<String, Object> data){
        this.name = (String) data.get("name");
        this.type = (String) data.get("type");
        this.duration = (double) data.get("duration");


    }
    public HashMap<String, Object> toMap(){
        HashMap<String, Object> fm = new HashMap();
        fm.put("name", this.name);
        fm.put("type", this.type);
        fm.put("duration", this.duration);


        return fm;
    }
}
