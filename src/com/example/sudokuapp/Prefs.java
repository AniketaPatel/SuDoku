package com.example.sudokuapp;

import com.example.sudokuapp.R;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.content.Context;
import android.view.Menu;

public class Prefs extends PreferenceActivity {

	// Options names and default values
		private static final String OPT_MUSIC = "music";
		private static final boolean OPT_MUSIC_DEF = true;
		private static final String OPT_HINTS = "hints";
		private static final boolean OPT_HINTS_DEF = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prefs);
		addPreferencesFromResource(R.xml.settings);

	}

	/** Get the current value of music option */
	public static boolean getMusic(Context context) {
		return PreferenceManager.getDefaultSharedPreferences(context)
				.getBoolean(OPT_MUSIC, OPT_MUSIC_DEF);
	}

	/** Get the current value of the hints option */
	public static boolean getHints(Context context) {
		return PreferenceManager.getDefaultSharedPreferences(context)
				.getBoolean(OPT_HINTS, OPT_HINTS_DEF);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.prefs, menu);
		return true;
	}

}
