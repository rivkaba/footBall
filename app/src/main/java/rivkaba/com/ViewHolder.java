package rivkaba.com;

import android.annotation.SuppressLint;
import android.app.Application;
import android.net.Uri;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.media2.exoplayer.external.ExoPlayerFactory;
import androidx.media2.exoplayer.external.SimpleExoPlayer;
import androidx.media2.exoplayer.external.extractor.DefaultExtractorsFactory;
import androidx.media2.exoplayer.external.extractor.ExtractorsFactory;
import androidx.media2.exoplayer.external.source.ExtractorMediaSource;
import androidx.media2.exoplayer.external.source.MediaSource;
import androidx.media2.exoplayer.external.trackselection.AdaptiveTrackSelection;
import androidx.media2.exoplayer.external.trackselection.DefaultTrackSelector;
import androidx.media2.exoplayer.external.trackselection.TrackSelector;
import androidx.media2.exoplayer.external.upstream.BandwidthMeter;
import androidx.media2.exoplayer.external.upstream.DefaultBandwidthMeter;
import androidx.media2.exoplayer.external.upstream.DefaultHttpDataSourceFactory;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    View mView;
    SimpleExoPlayer exoPlayer ;
   // private PlayerView mExoplayerView;
    public ViewHolder(@NonNull View itemView) {

        super(itemView);
        mView=itemView;
    }
    @SuppressLint("RestrictedApi")
    public  void  setVideo(final Application ctx, String title, final String url){
      // TextView mtextView=mView.findViewById(R.id.Titletv);
      //  mExoplayerView=mView.findViewById(R.id.exoplayer_view);
     //   mtextView.setText(title);
        try {
            BandwidthMeter bandwidthMeter= new DefaultBandwidthMeter.Builder(ctx).build();
            TrackSelector trackSelector =new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
            exoPlayer=(SimpleExoPlayer) ExoPlayerFactory.newSimpleInstance(ctx);
            Uri video =Uri.parse(url);
            DefaultHttpDataSourceFactory dataSourceFactory=new DefaultHttpDataSourceFactory("video");
            ExtractorsFactory extractorsFactory =new DefaultExtractorsFactory();
            MediaSource mediaSource=new ExtractorMediaSource(video,dataSourceFactory,extractorsFactory, null,null);
           // mExoplayerView.setPlayer(exoPlayer);
            exoPlayer.prepare(mediaSource);
            exoPlayer.setPlayWhenReady(false);
        }catch (Exception e){
            Log.e("ViewHolder","exoplayer error"+e.toString());
        }
    }
}
