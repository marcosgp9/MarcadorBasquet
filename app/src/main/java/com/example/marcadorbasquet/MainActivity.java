package com.example.marcadorbasquet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView punt1;
    private TextView punt2;
    private String n1;
    private String n2;
    private int puntuacio1;
    private int puntuacio2;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        //Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Check if the correct item was clicked
        if (item.getItemId() == R.id.night_mode) {
            //Get the night mode state of the app
            int nightMode = AppCompatDelegate.getDefaultNightMode();
//Set the theme mode for the restarted activity
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }
        recreate();
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//Save the scores
        outState.putInt("n1", puntuacio1);
        outState.putInt("n2", puntuacio2);
        super.onSaveInstanceState(outState);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        punt1 = (TextView) findViewById(R.id.puntuacion1);
        punt2 = (TextView) findViewById(R.id.puntuacion2);
        n1 = punt1.getText().toString();
        n2 = punt2.getText().toString();
        puntuacio1 = Integer.parseInt(n1.toString());
        puntuacio2 = Integer.parseInt(n2.toString());

        if (savedInstanceState != null) {
            puntuacio1 = savedInstanceState.getInt("n1");
            puntuacio2 = savedInstanceState.getInt("n2");
//Set the score text views
            punt1.setText(String.valueOf(puntuacio1));
            punt2.setText(String.valueOf(puntuacio2));
        }

    }


    public void increaseScore(View view) {

        switch (view.getId()){
            case R.id.sumar1:
                puntuacio1 ++;
                n1 = puntuacio1 + "";
                punt1.setText(n1);
                break;
            case R.id.sumar2:
                puntuacio2 ++;
                n2 = puntuacio2 + "";
                punt2.setText(n2);
                break;
        }

    }

    public void decreaseScore(View view){

        switch (view.getId()){
            case R.id.restar1:
                if ( puntuacio1 == 0){
                    return;
                }
                puntuacio1 --;
                n1 = puntuacio1 + "";
                punt1.setText(n1);
                break;
            case R.id.restar2:
                if(puntuacio2 == 0){
                    return;
                }
                puntuacio2 --;
                n2 = puntuacio2 + "";
                punt2.setText(n2);
                break;
        }
    }

}
