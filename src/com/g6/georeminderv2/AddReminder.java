package com.g6.georeminderv2;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.app.Activity;
import android.content.Intent;



public class AddReminder extends Activity implements OnClickListener{
	
	
	EditText title, msg, place, time, date;
	Button favs, setLocation, reset;
	ImageButton save, cancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_reminder);
		
		findviews();
		
		favs.setOnClickListener(this);
		setLocation.setOnClickListener(this);
		reset.setOnClickListener(this);
		save.setOnClickListener(this);
		cancel.setOnClickListener(this);
		time.setOnClickListener(this);
		date.setOnClickListener(this);
	}

	private void findviews() {
		title = (EditText) findViewById(R.id.title);
		msg = (EditText) findViewById(R.id.msg);
		place = (EditText) findViewById(R.id.place);
		time = (EditText) findViewById(R.id.time);
		date = (EditText) findViewById(R.id.date);
		
		favs = (Button) findViewById(R.id.fav);
		setLocation = (Button) findViewById(R.id.locate_on_map);
		reset = (Button) findViewById(R.id.clear_fields);
		
		save = (ImageButton) findViewById(R.id.save_button);
		cancel = (ImageButton) findViewById(R.id.cancel_button);
		}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
		case  R.id.fav:
			startActivity(new Intent(AddReminder.this, FavActivity.class));
			break;
		case R.id.locate_on_map:
			startActivity(new Intent(AddReminder.this, MapActivity.class));
			break;
		case R.id.clear_fields:
			// clear all the fields
			
			title.setText("");
			msg.setText("");
			place.setText("");
			time.setText("");
			date.setText("");
			break;
		case R.id.save_button:
			// upload data into sql table
			break;
		case R.id.cancel_button:
			startActivity(new Intent(AddReminder.this, MainActivity.class));
			finish();
			break;
		case R.id.time:
			startActivity(new Intent(AddReminder.this, TimeActivity.class));
			break;
		case R.id.date:
			startActivity(new Intent(AddReminder.this, TimeActivity.class));
			break;
			
			
		}
		
		
	}



}
