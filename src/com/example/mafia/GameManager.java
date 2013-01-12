package com.example.mafia;

import com.skiller.api.listeners.SKListenerInterface;
import com.skiller.api.operations.SKApplication;
import com.skiller.api.operations.SKTurnBasedTools;
import com.skiller.api.operations.SKTurnBasedTools.eTBGameEvent;
import com.skiller.api.responses.SKGameMoveResponse;
import com.skiller.api.responses.SKGameStartedResponse;
import com.skiller.api.responses.SKStatusResponse;

public class GameManager {
    public enum ePlayer {
	NONE, OPPONENT, ME;
    }

    private GameActivity mGameUI;
    private String mGameId;
    private boolean mMyTurn;
    private boolean mIsGameOwner;
    private ePlayer[][] mGameMatrix = new ePlayer[3][3];

    private SKTurnBasedTools mTurnbasedTools;
    private SKListenerInterface<SKGameMoveResponse> mMoveListener;
    private boolean mIsBackPressed;

    private static GameManager mInstance = new GameManager();
    
	private GameManager()
	{

	}
	
	public static GameManager getInstance()
	{
		return mInstance;
	}
	
	public void createGame(final int fee, final String gameDescription, final String gameSettings)
	{
		mTurnbasedTools.createGame(fee, gameDescription, gameSettings, new SKListenerInterface<SKGameStartedResponse>() 
		{
			@Override
			public void onResponse(SKGameStartedResponse response)
			{
				handleStartResponse(response);
			}

			@Override
			public void onError(SKStatusResponse response) {
			    mGameUI.showFinalDialog("Oops", "Could not open the game. Please try again.");
			}
		}); 
	}
	
	public void joinGame(String gameId)
	{
		mTurnbasedTools.joinGame(gameId, new SKListenerInterface<SKGameStartedResponse>() 
		{
			@Override
			public void onResponse(SKGameStartedResponse response)
			{
				handleStartResponse(response);
			}

			@Override
			public void onError(SKStatusResponse response) {
			    mGameUI.showFinalDialog("Oops", "Could not join the game. Please try again.");
			}
		}); 
	}
	
	private void handleStartResponse(SKGameStartedResponse response)
	{
	    	mGameUI.initGame();
		mGameId = response.getGameId();
		mIsBackPressed = false;
		
		String ownerName = response.getOwner().getUserName();
		String currentUserName = SKApplication.getInstance().getUserManager().getCurrentUsername();
        /*
		//Choose who wants to make the first move:
		//The player that will not make the first move should send ready to play event and wait for opponents move
		if (ownerName.equals(currentUserName)) {
		    //In our case the owner of the game will wait for guests move, so we send ready to play event and wait for the move on the listener
		    String payload = ""; //nothing to send
		    String chatline = ""; //nothing to chat about
		    mTurnbasedTools.makeMove(response.getGameId(), eTBGameEvent.GAME_EVENT_READY_TO_PLAY, payload, chatline, mMoveListener);
        	        
		    mIsGameOwner = true;
		    mMyTurn = false;
		} else {//If you are the guest of the game, start playing
		    mIsGameOwner = false;
		    mMyTurn = true;
        	}
	*/
	}
	
	private void quitGame() 
	{
		String payload = ""; //no payload to send when exiting the game
		String chatline = ""; //nothing to chat about;
		mTurnbasedTools.makeMove(mGameId, eTBGameEvent.GAME_EVENT_QUIT_GAME, payload, chatline, null);
		mGameUI.showFinalDialog("Game over", "");
	}
	
	private void terminatePendingGame() 
	{
		mTurnbasedTools.terminatePendingGame(new SKListenerInterface<SKStatusResponse>()
		{
			@Override
			public void onResponse(SKStatusResponse response)
			{
				//Game was terminated successfully, show some message if you want to
			}

			@Override
			public void onError(SKStatusResponse response) {
			    mGameUI.showFinalDialog("Oops", "Could not terminate the game.");
			}
		});
	}
	
	public void onBackKeyPress()
	{
		mIsBackPressed = true;
		
		if (mGameId != null)
		{//If the game is in process, quit the game
			quitGame();
		}
		else
		{//If the game was not started yet, terminate it.
			terminatePendingGame();
		}
		
		mGameId = null;
	}
	
	public void setGameUI(GameActivity context)
	{
		this.mGameUI = context;
	}

}
