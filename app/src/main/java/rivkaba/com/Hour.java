package rivkaba.com;

import android.provider.MediaStore;

public class Hour {
    private Double hour;
    private MediaStore.Video video;
    public Hour(Double h,MediaStore.Video v){
        hour=h;
        video=v;
    }
    protected void  setHour(Double h){
        hour=h;
    }
    protected void setVideo(MediaStore.Video v){
        video=v;

    }
    protected Double getHour(){
        return  hour;
    }
    protected MediaStore.Video video()
    {
        return  video;
    }
}
