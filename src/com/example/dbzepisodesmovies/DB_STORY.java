package com.example.dbzepisodesmovies;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

@SuppressWarnings("deprecation")
public class DB_STORY extends FragmentActivity implements TabListener {

	ActionBar actionBar;
	ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.db_story);

		viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				actionBar.setSelectedNavigationItem(arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

		actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color
				.parseColor("#2196F3")));
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(true);
		actionBar.setIcon(new ColorDrawable(getResources().getColor(
				android.R.color.transparent)));
		actionBar.setStackedBackgroundDrawable(new ColorDrawable(Color
				.parseColor("#2196F3")));
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		ActionBar.Tab tab1 = actionBar.newTab();
		tab1.setText("Dragon Ball");
		tab1.setTabListener(this);

		ActionBar.Tab tab2 = actionBar.newTab();
		tab2.setText("Dragon Ball Z");
		tab2.setTabListener(this);

		ActionBar.Tab tab3 = actionBar.newTab();
		tab3.setText("Dragon Ball GT");
		tab3.setTabListener(this);

		actionBar.addTab(tab1);
		actionBar.addTab(tab2);
		actionBar.addTab(tab3);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            super.onBackPressed();
	            return true;
	    }
	    return super.onOptionsItemSelected(item);
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}
}

class MyAdapter extends FragmentPagerAdapter {

	public MyAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		Fragment fragment = null;
		switch (arg0) {
		case 0:
			fragment = new FragmentDB();
			break;
		case 1:
			fragment = new FragmentDBZ();
			break;
		case 2:
			fragment = new FragmentDBGT();
			break;
		}
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}

}