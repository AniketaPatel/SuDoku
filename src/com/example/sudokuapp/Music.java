package com.example.sudokuapp;

import com.example.sudokuapp.Prefs;

import android.media.MediaPlayer;
import android.content.Context;

public class Music {

private static MediaPlayer mp = null;
	
	/** Stop old song and start new one */
	public static void play(Context context, int resource) {
		stop(context);
		// Start music only if not disabled in preferences
		if (Prefs.getMusic(context)) {
			mp = MediaPlayer.create(context, resource);
			mp.setLooping(true);
			mp.start();
		}
	}
	
	/** Stop the music */
	public static void stop(Context context) {
		if (mp != null) {
			mp.stop();
			mp.release();
			mp = null;
		}
	}

}
