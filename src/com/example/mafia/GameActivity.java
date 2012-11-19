package com.example.mafia;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GameActivity extends Activity {	
    PhaseNight pNight = new PhaseNight();
    PhaseMorning pMorning = new PhaseMorning();
    PhaseAfternoon pAfternoon = new PhaseAfternoon();
    PhaseEvening pEvening = new PhaseEvening();

    DataPasser dataPasser=new DataPasser();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mainGameLoop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_game, menu);
        return true;
    }
    
    private Player getPlayer() {
    	Player p = new Player();
    	p = dataPasser.getMyPlayer();
    	return p;
    }
    
    private void mainGameLoop() {	
    	Player MyPlayer = getPlayer();
    	while(true) {
    		pNight.startPhase(MyPlayer);
    		pMorning.startPhase(MyPlayer);
    		pAfternoon.startPhase();
    		pEvening.startPhase(MyPlayer);
    	}
    	// run end game
    }
}


