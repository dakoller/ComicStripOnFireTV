package com.datenprodukt.leitstandapp.v0.myapp2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.koushikdutta.urlimageviewhelper.UrlImageViewCallback;
import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;
import android.view.animation.ScaleAnimation;
import android.view.animation.OvershootInterpolator;

import android.graphics.Bitmap;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ImageView iv = (ImageView)this.findViewById(R.id.image);

        iv.setAnimation(null);
        // yep, that's it. it handles the downloading and showing an interstitial image automagically.

        // String pic_url = "http://assets.amuniversal.com/3310ad006b3d01331bca005056a9545d"
        //String pic_url = "https://upload.wikimedia.org/wikipedia/commons/archive/5/5a/20121110110705%21El_Descendimiento%2C_by_Rogier_van_der_Weyden%2C_from_Prado_in_Google_Earth.jpg";
        String pic_url = "https://upload.wikimedia.org/wikipedia/commons/5/5a/El_Descendimiento%2C_by_Rogier_van_der_Weyden%2C_from_Prado_in_Google_Earth.jpg";

        UrlImageViewHelper.setUrlDrawable(iv, pic_url, R.drawable.loading, new UrlImageViewCallback() {
            @Override
            public void onLoaded(ImageView imageView, Bitmap loadedBitmap, String url, boolean loadedFromCache) {
                if (!loadedFromCache) {
                    ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1, ScaleAnimation.RELATIVE_TO_SELF, .5f, ScaleAnimation.RELATIVE_TO_SELF, .5f);
                    scale.setDuration(300);
                    scale.setInterpolator(new OvershootInterpolator());
                    imageView.startAnimation(scale);
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.exit) {
            this.finishAffinity();
        }

        return super.onOptionsItemSelected(item);
    }
}
