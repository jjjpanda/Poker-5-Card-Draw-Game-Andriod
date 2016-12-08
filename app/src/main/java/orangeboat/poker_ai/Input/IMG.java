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
        temp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources,R.drawable.playbutton), BitmapFactory.decodeResource(resources, R.drawable.playbutton).getWidth()*2/5, BitmapFactory.decodeResource(resources, R.drawable.playbutton).getHeight()*2/5, true);
        titlePanel.imgLoad(temp);
        pausePanel.imgLoad(temp);
        temp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources,R.drawable.quitbutton), BitmapFactory.decodeResource(resources, R.drawable.quitbutton).getWidth()*2/3, BitmapFactory.decodeResource(resources, R.drawable.quitbutton).getHeight()*2/3, true);
        pausePanel.imgLoad(temp);

        temp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources,R.drawable.pause), BitmapFactory.decodeResource(resources, R.drawable.pause).getWidth()/2, BitmapFactory.decodeResource(resources, R.drawable.pause).getHeight()/2, true);
        tablePanel.imgLoad(temp);
        temp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources,R.drawable.s2), BitmapFactory.decodeResource(resources, R.drawable.s2).getWidth(), BitmapFactory.decodeResource(resources, R.drawable.s2).getHeight(), true);
        tablePanel.cardLoad(temp);
    }
}
