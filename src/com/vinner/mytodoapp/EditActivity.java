package com.vinner.mytodoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends Activity {

	EditText editText;
	int itemPos;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String toDoText = getIntent().getStringExtra("toDoText");
		itemPos = getIntent().getIntExtra("itemPos", -1);
		setContentView(R.layout.activity_edit);
		editText = (EditText) findViewById(R.id.editText1);
		editText.setText(toDoText);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit, menu);
		return true;
	}

	public void saveToDoItem(View v) {
		EditText etName = (EditText) findViewById(R.id.editText1);
		// Prepare data intent
		Intent data = new Intent();
		// Pass relevant data back as a result
		data.putExtra("name", etName.getText().toString());
		data.putExtra("pos", itemPos);
		// Activity finished ok, return the data
		setResult(RESULT_OK, data); // set result code and bundle data for
									// response
		finish(); // closes the activity, pass data to parent
	}
}
