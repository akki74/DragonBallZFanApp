package com.example.dbzepisodesmovies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

public class DBGT extends ActionBarActivity{

	private Toolbar toolbar;
	HashMap<String, List<String>> episodes_category;
	List<String> episodes_list;
	ExpandableListView Exp_list;
	MoviesAdapterred adapter;
	String dbgt[] = {"n2_kLR0FD7k", "5Db84XyKNr0", "1T-5Fja9n-U", "G8mEqb20r5c",
			"0-cLHhf3lLk", "_2XTFEGKYe8", "w8hcxdQn0pg", "H1gsAM0RhEE",
			"TZ-7jLi9pDI", "zuj0HcjlceY", "LMkucpDI3q4", "yadkIkYv5qE",
			"VAWmopz1Wgs", "PkiAPbFbnLQ", "-bbTnodw074", "Eil7sHa7cDg",
			"1T1SFdWcmyI", "ftoiWHQUnP4", "V4gHdzt708E", "0KlfavGR71Y",
			"T2y87CbwCaI", "dvH_t47F_qc", "MqpAQt-fdEE", "_pzPGCFkxuk", 
			"NNFseijrE2A", "xqHajqVqXEg", "KHEuizmsgXE", "lh98tMh9m2M",
			"nbDkNYYOYYg", "4JL16ezb78Q", "zLmJmk0CcPE", "LajMOvZFdSs",
			"8Wu5XelRnks", "4Vo_p_-0-yU", "x4CxhRjZRcQ", "aT7g8zT3iHo",
			"ye-tzAlWhkM", "OAoRwiq_VOM", "nvT8LF1x_98", "Arr9-xQsIxU",
			"BjT6TKDa2D4", "SOMuVyffJBk", "fHZi7H7Wo6A", "BND-eWneFj0",
			"QrPp4rUgYfM", "CveH44mZHlY", "ZbKV3bymDB4", "kTtkrxwxn5E",
			"YGwH2vaSXso", "oJEoUPNjPQE", "DJpmxLgvz9g", "6T5B2P6_mO0",
			"L3H3xStmyc4", "f6lkNAi77GY", "0gV6BWtfZ_k", "OAWwnNIBSxM",
			"TZierU3aYGU", "P2Xqj9GN4hQ", "dwqkgG7o5Ko", "syP1AmItNgQ",
			"As3-Ase9Nr8", "xU9AARUZEM4", "h3pchVHRZSE", "RSv4FkWbKl8"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.db_gt);
		
		toolbar = (Toolbar) findViewById(R.id.appBar);

		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		Exp_list = (ExpandableListView) findViewById(R.id.expDBGT_list);
		episodes_category = DataProvider.getInfoDBGT();
		episodes_list = new ArrayList<String>(episodes_category.keySet());
		adapter = new MoviesAdapterred(this, episodes_category, episodes_list);
		Exp_list.setAdapter(adapter);

		Exp_list.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {
				// TODO Auto-generated method stub
			}
		});

		Exp_list.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int groupPosition) {
				// TODO Auto-generated method stub
			}

		});

		Exp_list.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
				switch(groupPosition)
				{
				case 0:
					childPosition+=47;
					break;
				case 1:
					childPosition+=40;
					break;
				case 2:
					childPosition+=15;
					break;
				}
				Intent i = new Intent(DBGT.this, Youtube.class);
				i.putExtra("value", dbgt[childPosition]);
				startActivity(i);
				return false;
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
		if(id == R.id.home){
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
