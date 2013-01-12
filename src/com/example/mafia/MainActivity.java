package com.example.mafia;

import com.skiller.api.listeners.SKListenerInterface;
import com.skiller.api.operations.SKApplication;
import com.skiller.api.operations.SKUIManager.eScreenType;
import com.skiller.api.responses.SKFeeChosenResponse;
import com.skiller.api.responses.SKStatusResponse;
import com.skiller.api.responses.SKTurnbasedGameChosenResponse;
import com.skiller.api.responses.SKStatusResponse.eResponseStatus;
import com.skiller.examples.tictactoe.BoardActivity;
import com.skiller.examples.tictactoe.GameManager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private int CAMERA_WIDTH;
    private int CAMERA_HEIGHT;
    MainActivity mContext = this;
	
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
        
        //Skiller SDK
        String applicationId = "508880754889"; //Insert your application id here
        String applicationKey = "29902c00327d40edb323dd3126edadf6"; //Insert your application key here
        String applicationSecret = "c9b377b1dc8f4713b2924866d8392791"; //Insert your application secret here
        String applicationVersion = "1"; //Insert your application version here
	int    distributorId = 7; //Insert your application distributor here (7 = Play - Android Market)
        
	// initialize the application
	SKApplication.getInstance().init(mContext, applicationId,
		applicationKey, applicationSecret, applicationVersion,
		distributorId);

	// sign in the user
	SKApplication.getInstance().login(mContext,
		new SKListenerInterface<SKStatusResponse>() {
		    @Override
		    public void onResponse(SKStatusResponse response) {
			// User signed in successfully
		    }

		    @Override
		    public void onError(SKStatusResponse response) {
			Toast toast = Toast.makeText(mContext,
				"You need to sign in to get social.",
				Toast.LENGTH_LONG);
			toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 0, 0);
			toast.show();
		    }
		});
    } 

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void NavigateNewGame(View view) {
	SKApplication.getInstance().getGameManager().showChooseFeeScreen(mContext, new SKListenerInterface<SKFeeChosenResponse>()
		{
			@Override
			public void onResponse(SKFeeChosenResponse response)
			{
				//Create new game with the chosen fee.
				String gameDescription = ""; //You may add game description that will be shown in the lobby
				String gameSettings = ""; //You may add game settings that will be passed to both users at the beginning of the game 
				GameManager.getInstance().createGame(response.getFee(), gameDescription, gameSettings);
				
				Intent intent = new Intent(mContext, BoardActivity.class);
				mContext.startActivity(intent);
			}

			@Override
			public void onError(SKStatusResponse response) 
			{
				if (response.getStatusCode() != eResponseStatus.USER_CANCELED.getCode())
				{
					//If the user did not cancel the operation you can handle the error here
				}
			}
		});     
	
	/*
	// Do something in response to button
    	Intent intent = new Intent(this, GameActivity.class);
    	startActivity(intent);
    	*/
    }
    
    public void NavigateJoinGame(View view) {
	SKApplication.getInstance().getGameManager().getTurnBasedTools().showGamesLobby(mContext, new SKListenerInterface<SKTurnbasedGameChosenResponse>()
	{
		@Override
		public void onResponse(SKTurnbasedGameChosenResponse response)
		{
			GameManager.getInstance().joinGame(response.getGameId());
			
			Intent intent = new Intent(mContext, BoardActivity.class);
			mContext.startActivity(intent);
		}

		@Override
		public void onError(SKStatusResponse response) 
		{
			if (response.getStatusCode() != eResponseStatus.USER_CANCELED.getCode())
			{
				//If the user did not cancel the operation you can handle the error here
			}
		}
	});
    }
    
    public void NavigateRanking(View view) {				
	SKApplication.getInstance().getGameManager().showRankings(mContext);
    }
    
    public void NavigateAchievements(View view) {
	SKApplication.getInstance().getGameManager().showAchievements(mContext);
    }
    
    public void NavigateGetCoins(View view) {
	SKApplication.getInstance().getUIManager().showScreen(mContext, eScreenType.COINS_STORE);
    }
    
    public void NavigateGoSocial(View view) {
	SKApplication.getInstance().getUIManager().showScreen(mContext, eScreenType.DASHBOARD);
    }
    
    public void NavigateOptions(View view) {
        // Do something in response to button
    	Intent intent = new Intent(this, OptionsActivity.class);
    	startActivity(intent);
    }
    
    public void NavigateExit(View view) {
    	finish();
    }
    
    
}
