package com.example.dbzepisodesmovies;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubePlayer.Provider;

public class Youtube extends YouTubeBaseActivity implements
		YouTubePlayer.OnInitializedListener {
	private YouTubePlayer YPlayer;
	private static final String YoutubeDeveloperKey = "AIzaSyAxBpRfMGBEyGn34Z1ZJBWc4VljdDQBsAM";
	private static final int RECOVERY_DIALOG_REQUEST = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.youtubeview);

		YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
		youTubeView.initialize(YoutubeDeveloperKey, this);
	}

	@Override
	public void onInitializationFailure(YouTubePlayer.Provider provider,
			YouTubeInitializationResult errorReason) {
		if (errorReason.isUserRecoverableError()) {
			errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
		} else {
			String errorMessage = String.format(
					"There was an error initializing the YouTubePlayer",
					errorReason.toString());
			Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == RECOVERY_DIALOG_REQUEST) {
			// Retry initialization if user performed a recovery action
			getYouTubePlayerProvider().initialize(YoutubeDeveloperKey, this);
		}
	}

	protected YouTubePlayer.Provider getYouTubePlayerProvider() {
		return (YouTubePlayerView) findViewById(R.id.youtube_view);
	}

	@Override
	public void onInitializationSuccess(Provider provider,
			YouTubePlayer player, boolean wasRestored) {
		Intent intent = getIntent();
		String value = intent.getStringExtra("value");
		YPlayer = player;
		if (!wasRestored) {
			YPlayer.loadVideo(value);
		}
	}
}
