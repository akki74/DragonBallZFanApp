package com.example.dbzepisodesmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class DB_INTRO extends ActionBarActivity {

	private Toolbar toolbar;
	String menu[] = { "1. Dragon Ball (Mystical Adventure)",
			"2. Dragon Ball Z (Rock The Dragon)",
			"3. Dragon Ball GT (Bit By Bit)" };
	String intro[] = { "jNWoAWYAXE8", "S9kN0pct-Q8", "m0xvYlZM49Q" };
	ListView myList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.db_intro);

		toolbar = (Toolbar) findViewById(R.id.appBar);

		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		myList = (ListView) findViewById(R.id.listView2);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.custom_textviewblue, menu);

		myList.setAdapter(adapter);

		myList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent i = new Intent(DB_INTRO.this, Youtube.class);
				i.putExtra("value", intro[position]);
				startActivity(i);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			this.finish();
		}
		if (id == R.id.home) {
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
