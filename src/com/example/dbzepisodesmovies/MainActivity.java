package com.example.dbzepisodesmovies;

import java.util.ArrayList;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private Toolbar toolbar;
	boolean doubleBackToExitPressedOnce;
	GridView myGrid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
		setContentView(R.layout.activity_main);

		toolbar = (Toolbar) findViewById(R.id.appBar);

		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setTitle("Home");

		NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.fragment_navigation_drawer);
		drawerFragment.setUp(R.id.fragment_navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

		myGrid = (GridView) findViewById(R.id.gridView);
		myGrid.setAdapter(new VivAdapter(this));

		myGrid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent i;
				switch (position) {
				case 0:
					i = new Intent("android.intent.action.DBINTRO");
					startActivity(i);
					break;
				case 1:
					i = new Intent("android.intent.action.DB");
					startActivity(i);
					break;
				case 2:
					i = new Intent("android.intent.action.DBZ");
					startActivity(i);
					break;
				case 3:
					i = new Intent("android.intent.action.DBGT");
					startActivity(i);
					break;
				case 4:
					i = new Intent("android.intent.action.DBMOVIES");
					startActivity(i);
					break;
				case 5:
					i = new Intent("android.intent.action.DBEND");
					startActivity(i);
					break;
				}
			}
		});

	}

	@Override
	public void onBackPressed() {
		if (doubleBackToExitPressedOnce) {
			super.onBackPressed();
			return;
		}

		this.doubleBackToExitPressedOnce = true;
		Toast.makeText(this, "Please BACK again to exit",
				Toast.LENGTH_SHORT).show();

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				doubleBackToExitPressedOnce = false;
			}
		}, 2000);
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
		return super.onOptionsItemSelected(item);
	}
}

class Country {
	int imageId;
	String countryName;

	Country(int imageId, String countryName) {
		this.imageId = imageId;
		this.countryName = countryName;
	}
}

class VivAdapter extends BaseAdapter {

	ArrayList<Country> list;
	Context context;

	VivAdapter(Context context) {
		this.context = context;
		list = new ArrayList<Country>();
		Resources res = context.getResources();
		String[] tempCountryNames = res.getStringArray(R.array.grid);
		int[] countryImages = { R.drawable.starting, R.drawable.db,
				R.drawable.dragonballz, R.drawable.dbgt, R.drawable.dbz_movies,
				R.drawable.ending };
		for (int i = 0; i < 6; i++) {
			Country tempCountry = new Country(countryImages[i],
					tempCountryNames[i]);
			list.add(tempCountry);
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	class ViewHolder {
		ImageView img;
		TextView txt;

		ViewHolder(View v) {
			img = (ImageView) v.findViewById(R.id.imageView1);
			txt = (TextView) v.findViewById(R.id.textView1);
			Typeface type = Typeface.createFromAsset(context.getAssets(),
					"fonts/black_jack.ttf");
			txt.setTypeface(type);
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View row = convertView;
		ViewHolder holder = null;
		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.single_item, parent, false);
			holder = new ViewHolder(row);
			row.setTag(holder);
		} else {
			holder = (ViewHolder) row.getTag();
		}
		Country temp = list.get(position);
		holder.img.setImageResource(temp.imageId);
		holder.txt.setText(temp.countryName);
		return row;
	}

}
