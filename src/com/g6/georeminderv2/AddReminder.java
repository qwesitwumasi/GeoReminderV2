package com.g6.georeminderv2;

import java.util.Date;

import com.androidhive.androidsqlite.Contact;
import com.androidhive.androidsqlite.DatabaseHandler;

import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class AddReminder extends Activity implements OnClickListener {

	EditText title, msg, place, time, date;
	Button favs, setLocation, reset;
	ImageButton save, cancel;
	String titleString;
	String msgString;
	String placeString;
	Time timeTime;
	Date dateDate;

	String errorMsg = "";

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
		switch (v.getId()) {
		case R.id.fav:
			startActivity(new Intent(AddReminder.this, FavActivity.class));
			// add code to return a place longitude a place latitude due to d
			// place shocse
			// dis is gotten form a query run against the place table in the
			// database
			break;
		case R.id.locate_on_map:
			startActivity(new Intent(AddReminder.this, MapActivity.class));
			// ad code to return a long and lat after the map has been gotteng
			// and position set
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

			CheckFieldBounds();
			while (CheckFieldBounds()) {
				// execuse save comand hear
				SaveItems();

			}

			// CheckFieldBounds();
			// if (CheckFieldBounds()){
			// //execute comands to insert into sql table
			// }

			break;
		case R.id.cancel_button:
			startActivity(new Intent(AddReminder.this, MainActivity.class));
			finish();
			break;
		case R.id.time:
			startActivity(new Intent(AddReminder.this, TimeActivity.class));
			// add code to return time variable
			// code to set the edittext date to a time
			break;
		case R.id.date:
			startActivity(new Intent(AddReminder.this, TimeActivity.class));
			// add code to return a date varialbe
			// code to set the edittext date to string
			break;

		}

	}

	private void SaveItems() {
		  DatabaseHandler db = new DatabaseHandler(this);
	        /**
	         * CRUD Operations
	         * */
	        // Inserting Action
		  db.addRemAction(new RemActions(titleString, msgString, placeString, dateDate, timeTime ));
	}

	private boolean CheckFieldBounds() {
		// setting the edit text fields to strings
		titleString = title.getText().toString();
		msgString = msg.getText().toString();
		placeString = place.getText().toString();
		dateDate = date.getText().toString();
		timeTime = time.getText().toString();

		if (titleString.equals("")) {
			// message.setText("Your first Name can not be empty");
			errorMsg = "Title cant be empty \n ";
		}
		if (placeString.equals("")) {
			errorMsg += "Place cant be empty\n";
		}
		if (dateDate.equals("")) {
			errorMsg += "Date cant be empty\n";

		}
		if (timeTime.equals("")) {
			errorMsg += "Time cant be empty\n";
		}
		if (errorMsg.equals("")) {
			return true;
		} else {
			// toast error message here
			Toast.makeText(AddReminder.this, errorMsg, Toast.LENGTH_SHORT).show();
			return false;
		}

	}

}
