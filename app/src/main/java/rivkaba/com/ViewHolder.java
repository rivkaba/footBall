package rivkaba.com;

import android.app.Application;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    View mView;
    SimpleExoPlayer exoPlayer ;
    private  PlayerView mExoplayerView;
    public ViewHolder(@NonNull View itemView) {

        super(itemView);
        mView=itemView;
    }
    public  void  setVideo(final Application ctx, String tite,final String url){
        TextView mtextView=mView.findViewById(R.id.Titletv);
        mExoplayerView=mView.findViewById(R.id.exoplayer_view);
        mtextView.setText(title);
        try {
            BandwidthMeter bandwidthMeter= new DefaultBandwidthMeter.Builder(ctx).build();
            TrackSelector trackSelector =new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
            exoPlayer=(SimpleExoplayer)ExoPlayerFactory.newSimpleInstance(ctx);
            Uri video=Uri.parse(url);
            DefaultHttpDataSourceFactory dataSourceFactory=new DefaultHttpDataSourceFactory(video)
            ExtractorsFactory extractorsFactory =new DefaultExtractorsFactory();
            MediaSource mediaSource=new ExtractorMediaSource(video,dataSourceFactory,extractorsFactory, null,null);
            mExoplayerView.setPlayer(exoPlayer);
            exoPlayer.prepare(mediaSource);
            exoPlayer.setPlayWhenReady(false);
        }catch (Exception e){
            Log.e("ViewHolder","exoplayer error"+e.toString());
        }
    }
}
