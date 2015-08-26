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

public class DB extends ActionBarActivity {

	private Toolbar toolbar;
	HashMap<String, List<String>> episodes_category;
	List<String> episodes_list;
	ExpandableListView Exp_list;
	MoviesAdapterblue adapter;
	String db[] = { "MP8QDBBQNHg", "uFjneBYPDdY", "5gYRZVRh5F8", "uYYVA7FS8o8",
			"gR_f3x11gaE", "KaXfUqRuynA", "ePvNMJth20k", "83mYcMEue9o",
			"M9xcoJikI0Y", "_izwuVq14p4", "eZARwmEz6Ps", "yK2uB9ymxY8",
			"wvd6EVC-8S4", "p8D6Da8egUc", "R0vpEJoxdIk", "RF2-mR-0Qwo",
			"T_hUp7FyHNA", "bfmwM9NX_uo", "b-OeV8csx9Y", "FIep6oI3inI",
			"ameXKPN0nLY", "1o8OZYZs054", "3apBBIlCrYo", "Ht_TqAGXZ9U",
			"kcAKaoVPsdw", "REgtrpVWA7w", "1g5fMYontYs", "NMwBdK547QQ",
			"1bCqNo0IQBA", "ZevgtdzY3Ys", "lrX0Xn_mgOI", "QbjOLR8C5p0",
			"gdmd3YMwMMM", "8gbbDn_BIKU", "MTlOA-HJ5fo", "2z9r8eJukxI",
			"eprOPWQ41Ms", "t18iuDmA0yk", "ZOeRD4tq1FA", "SMHthd23aBI",
			"6FncNmWb5fk", "9RjMf9wIpVA", "BBv_dnBGreY", "uuUSqZD215c",
			"Ufe-iePgILk", "0E3n9incjiQ", "z0LsMF2eiE0", "aGWzIIXLPDM",
			"WTUEqtpIUss", "USbEpA1kpok", "MAVELYKzX4o", "nZqIBhlXzw0",
			"1y9hDVK3EXw", "vcrEZn0zwxU", "WZ7QnJPnJaI", "t5tC9YNcbJQ",
			"ubZ17G4-j9Q", "JYsO0PMUt7E", "t7P7nMCvviY", "x7TXJwm-yUk",
			"GGwkH0v8O64", "F08PMw8pHaY", "N9Loq35zKTU", "GfmhTdaB36c",
			"NpmqMK0oXXs", "wz4sGm8aEFY", "d5D6kV57E7c", "W9RUEdySq5c",
			"bixAcKsiTOg", "JY6dm43dDjI", "W6ulS_9el20", "hasRSReY70I",
			"RwjI1qedB-M", "1i8h5_k0E34", "t5exYh4Q4Ps", "td90dQRLKcM",
			"_LDoUm5ExmI", "2KvZkJ5dA4s", "CWb1WNWBLrE", "c8UCpu-3QHs",
			"A_y06WiOcYE", "P5SAWGwjR_I", "kRaaZ5vOZnc", "QczXrK5ZfDw",
			"rAqwyDdboJY", "Bf4k_13o0yA", "QD8aFomEeEw", "UHzSRmGhygk",
			"i5LQN5c2M4w", "K7J2SCCuGDQ", "b4u3NBi2-1g", "M0QI6F2AvlQ",
			"yCDOKqIarxw", "DBopY7VMCR0", "dXVvlT4WStg", "MxuQDq8_h5o",
			"okISZylDMKE", "nrPVQKN1Zhw", "p5JlqqKkrYg", "3EPSVH5lmWo",
			"-kAxFVokLW4", "YUXVe3tevIc", "xU3w25cD3y4", "f39jp7BZ5zo",
			"46OA8Cn2AOA", "bYwsXTpG454", "9usOcWKN06A", "aVvyCKSNI_w",
			"RalZuvnU0a8", "DcDHVC4fKMw", "NZyP4KkeQhM", "nV2ABELF8_U",
			"R5grRaXdYyk", "4P57EMCOtq8", "Y0myQ7YjYBQ", "n42F2MXzq_E",
			"PYtV6sa-YGY", "yxvf9YyERO0", "CrPlAsu0KqQ", "uO99JdyrN2A",
			"N1qwrXGb8X4", "l7px_9aO5Jc", "rR-U2HHrFt4", "3J4lJqdowgk",
			"_GmKWhdfMpI", "SrBSQBsBNSo", "6QPFbckFo50", "g2Y1f037-CU",
			"7QTM80AcZ9k", "-76fBXEKq84", "yq_Zv9VAZqU", "fMVUR8DxbII",
			"QptOmMGYajs", "KR8G0j_wCGo", "GiVrR5z4Tns", "jocKdq_4Cho",
			"ljbL23W4RMU", "uXQkUMMEGgE", "lMRYHZEk1WU", "FbcFS8MfECs",
			"X0LmeiMIMsw", "iL1xoJTErDw", "JgdU1E_pD4c", "E-CcUq5_tvk", 
			"_o969ydnLw0", "kcnNAkpVH40", "xroyJQNvwPE", "5LY5X90oGso",
			"ybuTa23VAuo", "VKyzqb-Amo8", "PC_XymbCR7k", "eAmzS5SgBKw",
			"2i6ttV6L2s4"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.db);

		toolbar = (Toolbar) findViewById(R.id.appBar);

		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		Exp_list = (ExpandableListView) findViewById(R.id.expDB_list);
		episodes_category = DataProvider.getInfoDB();
		episodes_list = new ArrayList<String>(episodes_category.keySet());
		adapter = new MoviesAdapterblue(this, episodes_category, episodes_list);
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
				case 1:
					childPosition+=101;
					break;
				case 2:
					childPosition+=68;
					break;
				case 3:
					childPosition+=122;
					break;
				case 4:
					childPosition+=45;
					break;
				case 5:
					childPosition+=28;
					break;
				case 6:
					childPosition+=82;
					break;
				case 7:
					childPosition+=57;
					break;
				case 8:
					childPosition+=13;
					break;
				}
				Intent i = new Intent(DB.this, Youtube.class);
				i.putExtra("value", db[childPosition]);
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
		if (id == R.id.home) {
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}