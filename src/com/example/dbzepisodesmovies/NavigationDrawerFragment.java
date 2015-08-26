package com.example.dbzepisodesmovies;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class NavigationDrawerFragment extends Fragment {

	private VivzAdapter adapter;
	private static RecyclerView recyclerView;
	private View containerView;
	public static final String PREF_FILE_NAME = "testpref";
	public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";
	private ActionBarDrawerToggle mDrawerToggle;
	private DrawerLayout mDrawerLayout;
	private boolean mUserLearnedDrawer;
	private boolean mFromSavedInstanceState;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mUserLearnedDrawer = Boolean.valueOf(readFromPreference(getActivity(),
				KEY_USER_LEARNED_DRAWER, "false"));
		if (savedInstanceState == null) {
			mFromSavedInstanceState = true;
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View layout = inflater.inflate(R.layout.fragment_navigation_drawer,
				container, false);
		recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);
		adapter = new VivzAdapter(getActivity(), getData());
		recyclerView.setAdapter(adapter);
		recyclerView.addOnItemTouchListener(new RecyclerTouchListener(
				getActivity(), recyclerView, new ClickListener() {

					@Override
					public void onClick(View view, int position) {
						// TODO Auto-generated method stub
						Intent i;
						switch (position) {
						case 0:
							i = new Intent(getActivity(), MainActivity.class);
						    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);   
						    startActivity(i);
							break;
						case 1:
							i = new Intent("android.intent.action.DBINTRO");
							startActivity(i);
							break;
						case 2:
							i = new Intent("android.intent.action.DB");
							startActivity(i);
							break;
						case 3:
							i = new Intent("android.intent.action.DBZ");
							startActivity(i);
							break;
						case 4:
							i = new Intent("android.intent.action.DBGT");
							startActivity(i);
							break;
						case 5:
							i = new Intent("android.intent.action.DBMOVIES");
							startActivity(i);
							break;
						case 6:
							i = new Intent("android.intent.action.DBEND");
							startActivity(i);
							break;
						case 7:
							i = new Intent("android.intent.action.DBSTORY");
							startActivity(i);
							break;
						case 8:
							i = new Intent(android.content.Intent.ACTION_SEND);
							i.putExtra(
									android.content.Intent.EXTRA_EMAIL,
									new String[] { "aakashprakash74@gmail.com" });
							i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
							i.setType("plain/text");
							i.putExtra(Intent.EXTRA_TEXT, "body of email");
							startActivity(i);
							break;
						case 9:
							i = new Intent("android.intent.action.ABOUT");
							startActivity(i);
							break;
						}
					}

					@Override
					public void onLongClick(View view, int position) {
						// TODO Auto-generated method stub
					}

				}));
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		return layout;
	}

	public static List<Information> getData() {

		List<Information> data = new ArrayList<Information>();
		int icons[] = { R.drawable.ic_home, R.drawable.ic_dbintro,
				R.drawable.ic_db, R.drawable.ic_dbz, R.drawable.ic_dbgt,
				R.drawable.ic_dbmovies, R.drawable.ic_dbend,
				R.drawable.ic_dbstory, R.drawable.ic_email,
				R.drawable.ic_about};
		String[] titles = { "Home", "Intro Theme Song", "Dragon Ball",
				"Dragon Ball Z", "Dragon Ball GT", "Dragon Ball Movies",
				"Ending Theme Song", "Story", "Email Us",
				"About The Developer"};

		for (int i = 0; i < titles.length && i < icons.length; i++) {
			Information current = new Information();
			current.iconId = icons[i];
			current.title = titles[i];
			data.add(current);
		}
		return data;
	}

	public void setUp(int FragmentId, DrawerLayout drawerLayout,
			final Toolbar toolbar) {
		// TODO Auto-generated method stub
		containerView = getActivity().findViewById(FragmentId);
		mDrawerLayout = drawerLayout;
		mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout,
				toolbar, R.string.drawer_open, R.string.drawer_close) {

			@Override
			public void onDrawerOpened(View drawerView) {
				// TODO Auto-generated method stub
				super.onDrawerOpened(drawerView);
				if (!mUserLearnedDrawer) {
					mUserLearnedDrawer = true;
					saveToPreference(getActivity(), KEY_USER_LEARNED_DRAWER,
							mUserLearnedDrawer + "");
				}
				getActivity().invalidateOptionsMenu();
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				// TODO Auto-generated method stub
				super.onDrawerClosed(drawerView);
				getActivity().invalidateOptionsMenu();
			}

			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
				// TODO Auto-generated method stub
				if (slideOffset < 0.6) {
					toolbar.setAlpha(1 - slideOffset);

				}
			}
		};

		if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
			mDrawerLayout.openDrawer(containerView);
		}
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		mDrawerLayout.post(new Runnable() {
			@Override
			public void run() {
				mDrawerToggle.syncState();
			}
		});
	}

	public static void saveToPreference(Context context, String prefernceName,
			String prefernceValue) {

		SharedPreferences sharedPreferences = context.getSharedPreferences(
				PREF_FILE_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString(prefernceName, prefernceValue);
		editor.apply();
	}

	public static String readFromPreference(Context context,
			String prefernceName, String prefernceValue) {

		SharedPreferences sharedPreferences = context.getSharedPreferences(
				PREF_FILE_NAME, Context.MODE_PRIVATE);
		return sharedPreferences.getString(prefernceName, prefernceName);
	}

	static class RecyclerTouchListener implements
			RecyclerView.OnItemTouchListener {

		private GestureDetector gestureDetector;
		private ClickListener clickListener;

		public RecyclerTouchListener(Context context,
				RecyclerView recyclerview, final ClickListener clickListener) {
			this.clickListener = clickListener;
			gestureDetector = new GestureDetector(context,
					new GestureDetector.SimpleOnGestureListener() {

						@Override
						public void onLongPress(MotionEvent e) {
							// TODO Auto-generated method stub
							View child = recyclerView.findChildViewUnder(
									e.getX(), e.getY());
							if (child != null && clickListener != null) {
								clickListener.onLongClick(child,
										recyclerView.getChildPosition(child));
							}
						}

						@Override
						public boolean onSingleTapUp(MotionEvent e) {
							// TODO Auto-generated method stub
							return true;
						}

					});
		}

		@Override
		public boolean onInterceptTouchEvent(RecyclerView recyclerView,
				MotionEvent e) {
			// TODO Auto-generated method stub
			View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
			if (child != null && clickListener != null
					&& gestureDetector.onTouchEvent(e)) {
				clickListener.onClick(child,
						recyclerView.getChildPosition(child));
			}
			return false;
		}

		@Override
		public void onTouchEvent(RecyclerView arg0, MotionEvent arg1) {
			// TODO Auto-generated method stub
			gestureDetector.onTouchEvent(arg1);
		}

	}

	public static interface ClickListener {
		public void onClick(View view, int position);

		public void onLongClick(View view, int position);

	}
}
