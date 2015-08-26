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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DB_MOVIES extends ActionBarActivity {

	private Toolbar toolbar;
	ListView myList;
	String menu[] = { "1. Curse Of The Blood Rubies",
			"2. Sleeping Princess In Devil's Castle", "3. Mystical Adventure",
			"4. The Path To Power", "5. Dead Zone", "6. The World's Strongest",
			"7. The Tree Of Might", "8. Lord Slug", "9. Cooler's Revenge",
			"10. Cooler Returns", "11. Super Android 13!",
			"12. Broly-The Legendary Super Saiyan", "13. Bojack Unbound",
			"14. Broly-Second Coming", "15. Bio-Broly", "16. Fusion Reborn",
			"17. Wrath of The Dragon", "18. Battle Of Gods",
			"19. Bardock-The Father Of Goku", "20. A Hero's Legacy",
			"21. The History Of Trunks" };

	String movies[] = { "0ZtzZj3mgX4", "RPUj2e32nxM", "SKfrhHOYTZw",
			"gxECmc6txJ8", "G0mSDuUj4e0", "ugY0VAXM2s4", "Ccqm24-6Pyc",
			"xB6Id_MzbPw", "p4KCnU2svrQ", "PvY6mqFysUo", "kUxEnPd4aWU",
			"xEQri8vaN7s", "GmYqI3C2HF8", "HCVdm_AUN4o", "U6fTu6J7V0I",
			"A67nX2XR6Kw", "bUFBrkWygHE", "G9Vk9KM1zj0", "-XgfdB5B6AE",
			"8odT3DPbHS8", "APtE5ofXdfQ" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.db_movies);

		toolbar = (Toolbar) findViewById(R.id.appBar);

		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		myList = (ListView) findViewById(R.id.listView1);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.custom_textviewyellow, menu);

		myList.setAdapter(adapter);

		myList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent i = new Intent(DB_MOVIES.this, Youtube.class);
				i.putExtra("value", movies[position]);
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
