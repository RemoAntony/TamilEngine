package com.antony.remo.tamilengine;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase mydatabase = openOrCreateDatabase("tamilvoice",MODE_PRIVATE,null);
        /*InputMethodManager mgr =
                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (mgr != null) {
            mgr.showInputMethodPicker();
        }
*/
        Resources res = getApplicationContext().getResources();
// Change locale settings in the app.

        DisplayMetrics dm = res.getDisplayMetrics();

        SharedPreferences sp=getSharedPreferences("voice",MODE_PRIVATE);
        String ft=sp.getString("firsttime",null);
        if(ft==null||ft.equals(""))
        {
            getSharedPreferences("voice",MODE_PRIVATE).edit().putString("firsttime","0").commit();

            mydatabase.execSQL("CREATE TABLE IF NOT EXISTS tamil(tamilkey VARCHAR,englishkey VARCHAR);");
            mydatabase.execSQL("insert into tamil values ('?' , 'a');");
        }
        android.content.res.Configuration conf = res.getConfiguration();

        conf.locale = new Locale("ta");
        res.updateConfiguration(conf, dm);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarmain);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }

    public void stt(View view)
    {
        Intent intent=new Intent(MainActivity.this,SpeechToText.class);
        startActivity(intent);
    }
    public void ttcheck(View view)
    {
        Intent i=new Intent(MainActivity.this,TamilCheck.class);
        startActivity(i);
    }
    public void tts(View view)
    {
        Intent intent=new Intent(MainActivity.this,AndroidTextToSpeechActivity.class);
        startActivity(intent);
    }
}
