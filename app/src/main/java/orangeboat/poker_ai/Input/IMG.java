package orangeboat.poker_ai.Input;

import android.app.ActionBar;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;

import orangeboat.poker_ai.Display;
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
        temp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources,R.drawable.playbutton1), BitmapFactory.decodeResource(resources, R.drawable.playbutton1).getWidth()/2, BitmapFactory.decodeResource(resources, R.drawable.playbutton1).getHeight()/2, true);
        titlePanel.imgLoad(temp);
    }
}
