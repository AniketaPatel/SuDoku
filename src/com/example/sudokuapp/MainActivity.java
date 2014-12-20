package com.example.sudokuapp;

import com.example.sudokuapp.Prefs;
import com.example.sudokuapp.R;
import com.example.sudokuapp.GameActivity;
import com.example.sudokuapp.Music;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{

	private static final String TAG = "Sudoku";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Set up click listeners for all the buttons
	//	View continueButton = findViewById(R.id.continue_btn);
		//continueButton.setOnClickListener(this);
		View newButton = findViewById(R.id.newgame_btn);
		newButton.setOnClickListener(this);
		View aboutButton = findViewById(R.id.about_btn);
		aboutButton.setOnClickListener(this);
		View exitButton = findViewById(R.id.exit_btn);
		exitButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	public void onClick(View v) {
		
		Intent i=null;
		
		switch (v.getId()) {
		
		case R.id.about_btn:
		i = new Intent(this, About.class);
		startActivity(i);
		break;
		/*
		case R.id.continue_btn:
			openNewGameDialog();
			
			i = new Intent(this, GameActivity.class);
			startActivity(i);
			
			break;
		*/
		case R.id.newgame_btn:
			openNewGameDialog();
	         /*	
	        i = new Intent(this, GameActivity.class);
			startActivity(i);
		     */
			break;
		
		case R.id.exit_btn:
			//(0);
			break;
		}
		}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.settings:
			startActivity(new Intent(this, Prefs.class));
			return true;
		}
		return false;
	}
	
	
	private void openNewGameDialog() {
		new AlertDialog.Builder(this)
				.setTitle(R.string.new_game_title)
				.setItems(R.array.difficulty,
						new DialogInterface.OnClickListener() {
							public void onClick(
									DialogInterface dialoginterface, int i) {
								startGame(i);
							}
						}).show();
	}

	private void startGame(int i) {
		Log.d(TAG, "clicked on " + i);
		Intent intent = new Intent(this, GameActivity.class);
		intent.putExtra(GameActivity.KEY_DIFFICULTY, i);
		startActivity(intent);
	}

	@Override
	protected void onPause() {
		super.onPause();
		Music.stop(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		Music.play(this, R.raw.main);
	}
}
