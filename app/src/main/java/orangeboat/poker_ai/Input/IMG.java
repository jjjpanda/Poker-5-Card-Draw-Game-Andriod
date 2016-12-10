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
        temp = scaledBitmap(R.drawable.playbutton, 3.5);
        titlePanel.imgLoad(temp);

        temp = scaledBitmap(R.drawable.resume, 3.5);
        pausePanel.imgLoad(temp);
        temp = scaledBitmap(R.drawable.quit, 3.5);
        pausePanel.imgLoad(temp);

        temp = scaledBitmap(R.drawable.pause, .5);
        tablePanel.imgLoad(temp);
        temp = scaledBitmap(R.drawable.white, .5);
        tablePanel.imgLoad(temp);
        temp = scaledBitmap(R.drawable.red, .5);
        tablePanel.imgLoad(temp);
        temp = scaledBitmap(R.drawable.blue, .5);
        tablePanel.imgLoad(temp);
        temp = scaledBitmap(R.drawable.green, .5);
        tablePanel.imgLoad(temp);
        temp = scaledBitmap(R.drawable.black, .5);
        tablePanel.imgLoad(temp);
        temp = scaledBitmap(R.drawable.check, 1.95);
        tablePanel.imgLoad(temp);
        temp = scaledBitmap(R.drawable.call, 1.95);
        tablePanel.imgLoad(temp);
        temp = scaledBitmap(R.drawable.bet, 1.95);
        tablePanel.imgLoad(temp);
        temp = scaledBitmap(R.drawable.raise, 1.95);
        tablePanel.imgLoad(temp);
        temp = scaledBitmap(R.drawable.fold, 1.95);
        tablePanel.imgLoad(temp);
        temp = scaledBitmap(R.drawable.checkmark, .5);
        tablePanel.imgLoad(temp);
        temp = scaledBitmap(R.drawable.x, .5);
        tablePanel.imgLoad(temp);

        temp = scaledBitmap(R.drawable.ca, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.c2, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.c3, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.c4, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.c5, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.c6, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.c7, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.c8, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.c9, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.ct, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.cj, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.cq, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.ck, 1.1);
        tablePanel.cardLoad(temp);

        temp = scaledBitmap(R.drawable.ha, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.h2, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.h3, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.h4, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.h5, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.h6, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.h7, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.h8, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.h9, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.ht, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.hj, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.hq, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.hk, 1.1);
        tablePanel.cardLoad(temp);

        temp = scaledBitmap(R.drawable.sa, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.s2, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.s3, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.s4, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.s5, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.s6, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.s7, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.s8, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.s9, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.st, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.sj, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.sq, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.sk, 1.1);
        tablePanel.cardLoad(temp);

        temp = scaledBitmap(R.drawable.da, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.d2, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.d3, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.d4, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.d5, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.d6, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.d7, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.d8, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.d9, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.dt, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.dj, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.dq, 1.1);
        tablePanel.cardLoad(temp);
        temp = scaledBitmap(R.drawable.dk, 1.1);
        tablePanel.cardLoad(temp);
    }
    public Bitmap scaledBitmap(int img, double sizeChange){
        return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, img), (int) (BitmapFactory.decodeResource(resources, img).getWidth()*sizeChange), (int) (BitmapFactory.decodeResource(resources, img).getHeight()*sizeChange), true);

    }
}
