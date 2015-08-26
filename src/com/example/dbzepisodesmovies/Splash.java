package com.example.dbzepisodesmovies;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity{

	MediaPlayer ourSong;
	
	@Override
	protected void onCreate(Bundle Div) {
		
		// TODO Auto-generated method stub
		super.onCreate(Div);
		setContentView(R.layout.splash);
		
		ourSong = MediaPlayer.create(Splash.this, R.raw.splash);
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music = getPrefs.getBoolean("checkbox", true);
		if (music == true){
		ourSong.start();
		}
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(5000);
				}catch (InterruptedException e){
					e.printStackTrace(); 
				}finally{
					Intent openStartingPoint = new Intent(Splash.this, MainActivity.class);
					startActivity(openStartingPoint);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}

}
