package rivkaba.com;

import java.util.HashMap;
import java.util.Map;

public class Video {
    String title,url;
    private  String name;
    private  String type;
    private  double duration;




    public Video(String name, String type, double duration,String url) {
        this.name=name;
        this.type=type;
        this.duration=duration;
        this.url=url;
    }

    public String getTitle() {
        return title;
    }
    public String getUrl() {
        return url;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public void clone(Map<String, Object> data){
        this.name = (String) data.get("name");
        this.type = (String) data.get("type");
        this.duration = (double) data.get("duration");
        this.url = (String) data.get("url");



    }
    public HashMap<String, Object> toMap(){
        HashMap<String, Object> fm = new HashMap();
        fm.put("name", this.name);
        fm.put("type", this.type);
        fm.put("duration", this.duration);
        fm.put("url", this.url);


        return fm;
    }
}
