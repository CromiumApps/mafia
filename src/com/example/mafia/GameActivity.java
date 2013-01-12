package com.example.mafia;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.WindowManager;

public class GameActivity extends Activity {	
    PhaseNight pNight = new PhaseNight();
    PhaseMorning pMorning = new PhaseMorning();
    PhaseAfternoon pAfternoon = new PhaseAfternoon();
    PhaseEvening pEvening = new PhaseEvening();

    DataPasser dataPasser = new DataPasser();
    ProgressDialog mProgressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mProgressDialog = ProgressDialog.show(this, "", "Waiting for opponent...", true, true,
    		new OnCancelListener()
			{
				@Override
				public void onCancel(DialogInterface dialog)
				{
					GameManager.getInstance().onBackKeyPress();
					finish();
				}
			}
	    );
	    
		GameManager.getInstance().setGameUI(this);
		
		//turn off sleep mode during the game play so that we could keep internet connection
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
        //mainGameLoop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_game, menu);
        return true;
    }
    
    public void initGame()
    {
    	if (mProgressDialog != null)
    		mProgressDialog.dismiss();
    }
    
	public synchronized void showFinalDialog(String title, String message)
	{
		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		alert.setTitle(title);
		alert.setMessage(message);
		alert.setNeutralButton("OK", new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int which)
			{
				finish();
			}
		});
		
		alert.show();
	}
    
	@Override 
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{   
		if (keyCode != KeyEvent.KEYCODE_BACK) 
			return false;
		
		GameManager.getInstance().onBackKeyPress();
		return true;	
	} 
	
	@Override
	public void onBackPressed() {
		GameManager.getInstance().onBackKeyPress();
		super.onBackPressed();
	}
	
    
    private Player getPlayer() {
    	Player p = new Player();
    	p = dataPasser.getMyPlayer();
    	return p;
    }
    
    private void mainGameLoop() {	
    	Player myPlayer = getPlayer();
    	while(true) {
    		pNight.startPhase(myPlayer);
    		pMorning.startPhase(myPlayer);
    		pAfternoon.startPhase();
    		pEvening.startPhase();
    	}
    }
}

