package orangeboat.poker_ai;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by jawpa on 12/6/2016.
 */
public class MainActivity extends AppCompatActivity {
    Display display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        int money = sharedPref.getInt("money",0);
        System.out.println(money);
        display = new Display(this, displayMetrics);
        display.tablePanel.setMoney(money);
        setContentView(display);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onPause()
    {
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        int newMoney = display.tablePanel.money; // you can have some getHighscore thing here
        editor.putInt("high score", newMoney);
        editor.commit();
        System.out.println("dead");
        System.out.println(newMoney);
        super.onPause();
    }
    @Override
    public void onResume()
    {
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        int money = sharedPref.getInt("high score",0);
        System.out.println(money);
        display.tablePanel.setMoney(money);
        super.onResume();
    }
    @Override
    public void onStop()
    {
        super.onStop();
        System.exit(0);
    }
}
