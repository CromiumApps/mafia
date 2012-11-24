package com.example.mafia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private int CAMERA_WIDTH;
    private int CAMERA_HEIGHT;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {

        if(Integer.valueOf(android.os.Build.VERSION.SDK_INT) < 13 ) {
            Display display = getWindowManager().getDefaultDisplay(); 
            CAMERA_WIDTH = display.getWidth();
            CAMERA_HEIGHT = display.getHeight();
        }
        else {
       	    Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            CAMERA_WIDTH = size.x;
    	    CAMERA_HEIGHT = size.y;
    	}
    	
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_main);

    	TranslateAnimation anim = new TranslateAnimation(CAMERA_WIDTH, 0, 0, 0);
    	anim.setRepeatCount(0);
	    anim.setDuration(700);

    	// Start animating the image
   	    final ImageView title = (ImageView) findViewById(R.id.titleimage);
        title.startAnimation(anim);

        // Later... stop the animation
    } 

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    /** Called when the user clicks the Send button */
    public void NavigateNewGame(View view) {
        // Do something in response to button
    	Intent intent = new Intent(this, GameActivity.class);
    	startActivity(intent);
    }
    
    public void NavigateOptions(View view) {
        // Do something in response to button
    	Intent intent = new Intent(this, OptionsActivity.class);
    	startActivity(intent);
    }
    
    public void NavigateExit(View view) {
    		
    }
}
