package com.g6.georeminderv2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener {
	ImageButton add,settings,checkIn;
	ListView list;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		findviews();
		settings.setOnClickListener(this);
		add.setOnClickListener(this);
		checkIn.setOnClickListener(this);
		
		
	}

	private void findviews() {
		settings = (ImageButton) findViewById(R.id.settings);
		add = (ImageButton) findViewById(R.id.add_reminder);
		checkIn = (ImageButton) findViewById(R.id.check_in);
		
		list = (ListView) findViewById(R.id.listView1);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId())
		{
		case R.id.settings:
			startActivity(new Intent(MainActivity.this, SettingsActivity.class));
			break;
		case R.id.add_reminder:
			startActivity(new Intent(MainActivity.this, AddReminder.class));
			break;
		case R.id.check_in:
			startActivity(new Intent(MainActivity.this, CheckInActivity.class));
			break;
		}
	}

}
