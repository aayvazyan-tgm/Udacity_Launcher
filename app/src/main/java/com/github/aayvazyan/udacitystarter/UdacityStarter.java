package com.github.aayvazyan.udacitystarter;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.TintButton;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class UdacityStarter extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udacity_starter);
        //Get the Button container
        LinearLayout myLayout = (LinearLayout) findViewById(R.id.applications);
        //Create the Buttons
        myLayout.addView(createAppStarterButton(this,"SPOTIFY STREAMER"));
        myLayout.addView(createAppStarterButton(this,"SUPER DUO: FOOTBALL SCORES"));
        myLayout.addView(createAppStarterButton(this,"SUPER DUO: LIBRARY APP"));
        myLayout.addView(createAppStarterButton(this,"BUILD IT BIGGER"));
        myLayout.addView(createAppStarterButton(this, "XYZ READER"));
        final TintButton appStarterButton = createAppStarterButton(this, "CAPSTONE: MY OWN APP");
        appStarterButton.setBackgroundResource(R.color.ActionColor);
        myLayout.addView(appStarterButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_udacity_starter, menu);
        return false; //Disable the options
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

    public TintButton createAppStarterButton(final Context context, final String appname){
        TintButton myButton = new TintButton(this);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, 10);
        myButton.setLayoutParams(params);
        myButton.setTextSize(20);
        myButton.setBackgroundResource(R.color.LightColor);
        myButton.setText(appname);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"This button will launch my "+appname+" app!",Toast.LENGTH_SHORT).show();
            }
        });
        return myButton;
    }
}
