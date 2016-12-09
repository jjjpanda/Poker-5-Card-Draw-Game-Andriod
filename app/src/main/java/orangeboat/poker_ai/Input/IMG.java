package orangeboat.poker_ai.Input;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;

import orangeboat.poker_ai.Panels.PausePanel;
import orangeboat.poker_ai.Panels.TablePanel;
import orangeboat.poker_ai.Panels.TitlePanel;
import orangeboat.poker_ai.R;


/**
 * Created by jawpa on 12/6/2016.
 */
public class IMG {
    Bitmap temp;
    Resources resources;
    DisplayMetrics displayMetrics;
    TablePanel tablePanel;
    TitlePanel titlePanel;
    PausePanel pausePanel;
    public IMG(Resources resources, DisplayMetrics m, TablePanel table, TitlePanel title, PausePanel pause){
        tablePanel = table;
        titlePanel = title;
        pausePanel = pause;
        this.resources = resources;
        displayMetrics = m;
        start();
    }
    public void start(){
        temp = scaledBitmap(R.drawable.playbutton, 0.75);
        titlePanel.imgLoad(temp);

        temp = scaledBitmap(R.drawable.resume, 0.75);
        pausePanel.imgLoad(temp);
        temp = scaledBitmap(R.drawable.quit, 0.75);
        pausePanel.imgLoad(temp);

        temp = scaledBitmap(R.drawable.pause, .5);
        tablePanel.imgLoad(temp);

        temp = scaledBitmap(R.drawable.ca, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.c2, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.c3, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.c4, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.c5, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.c6, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.c7, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.c8, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.c9, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.ct, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.cj, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.cq, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.ck, 0.3);
        tablePanel.cardLoad(temp);

        temp = scaledBitmap(R.drawable.ha, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.h2, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.h3, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.h4, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.h5, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.h6, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.h7, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.h8, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.h9, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.ht, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.hj, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.hq, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.hk, 0.3);
        tablePanel.cardLoad(temp);

        temp = scaledBitmap(R.drawable.sa, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.s2, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.s3, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.s4, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.s5, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.s6, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.s7, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.s8, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.s9, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.st, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.sj, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.sq, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.sk, 0.3);
        tablePanel.cardLoad(temp);

        temp = scaledBitmap(R.drawable.da, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.d2, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.d3, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.d4, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.d5, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.d6, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.d7, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.d8, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.d9, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.dt, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.dj, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.dq, 0.3);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.dk, 0.3);
        tablePanel.cardLoad(temp);
    }
    public Bitmap scaledBitmap(int img, double sizeChange){
        return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, img), (int) (BitmapFactory.decodeResource(resources, img).getWidth()*sizeChange), (int) (BitmapFactory.decodeResource(resources, img).getHeight()*sizeChange), true);

    }
}
