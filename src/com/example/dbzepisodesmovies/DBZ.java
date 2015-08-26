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

public class DBZ extends ActionBarActivity{

	private Toolbar toolbar;
	HashMap<String, List<String>> episodes_category;
	List<String> episodes_list;
	ExpandableListView Exp_list;
	MoviesAdaptergreen adapter;
	String dbz[] = {"zkEJsFv3OVA", "F78q52q8FEk", "-hXyQgFDTGA", "J1lyR2Uo3Rs",
			"BRwYnCjzZ1I", "0B0IEFTDFq4", "vT9l2jAm4ng", "RdkaAG90Pcc",
			"ltiuHDsUST0", "DML2UcxqfNY", "Vf0dGqzEG5Q", "DZT7008nkVE",
			"HThqWcGzF8A", "6lCqfBCNVLE", "06k26yEY4Oc", "CYGjsGAC4AU",
			"J8lwMmayyTg", "dKGeqjw0fZA", "rtZ-6PGLQmc", "exI3Hoq8SdU",
			"eWx-BEasrtA", "S9Z0fY8QI4I", "Znig9rid8yk", "Og5Gp4NFles",
			"Gr1SqUjDpOI", "NjzIwoYoD-k", "z1foHuXkzfs", "PjkbrshUHQo",
			"sFk0lYvmMCE", "8PgWbWpCiK4", "mQ_BBmuZRPc", "kMRfmmYUDRw",
			"_wKswX_dHnY", "z2OXtwDhnQ8", "T1agMLIiIpc", "RqLjkilIzpk",
			"DfoH-pw5iVY", "7aFDSmJTHYw", "KDWySQy6U0U", "i1pxeXQM0xo",
			"w7rATEOWVL0", "330MLpMKVhA", "TlH9trU7el4", "4Xkgak7f2_k",
			"Fr0IJGdy3kc", "87H3aCq7QuY", "irNoZSdqvvk", "kul2k1itRb0",
			"eMOX8yd1xck", "CkbcrFXB0tM", "XH-FmbLMwFY", "xSUE2QNZqrU",
			"pP84QhQF9-E", "t72y0XWi-HI", "ywgZwWDB0oI", "xMGomK1uvqk",
			"mLOXDH1xeMU", "xFjC6sod8hQ", "QNBf3WSGAxw", "a70db0mj6eo",
			"_erME1bjlh8", "LdKXi5yjCTs", "buWsRfbt2gw", "hU1CXJSYfYk",
			"5JaThezIfqo", "nG7-9mHHEC4", "SnFfUFnFUBQ", "HT-fwdywilk",
			"u1jjBH9U7WU", "u1jjBH9U7WU", "wnCl2mthmlI", "YFzy6QhJ8Ew",
			"Xi2RS99pn4s", "T7bJkRvhggw", "o8tfV-9Cd5I", "G_v0B0D1enc",
			"XKaqBV_vP2w", "reRGzMJCq3g", "E7ZbiGRoNN8", "rWZdIdG5iiE",
			"oCzjfLXHovc", "FMg8qna_YmU", "7BJfETbslrk", "BtiAUxc9b44",
			"zEmHZjkn1nA", "q2Yy-OY8AAE", "rn206kGKRtY", "2tpJej5GMFc",
			"Z_opnVXN0oE", "1PkSbB7Jpa0", "29NIpxNFPj8", "UdhM0vQOgfk",
			"ejf82eBr64c", "32CtqXIzP5k", "UQrAMtp7cDs", "UjJ9xCIkYEg",
			"ruvslCpdmew", "aWtxbswX9UU", "JI--r3ig2v8", "s4aJ7rP0qsI",
			"_1JYYYIr1UU", "ueAQVedbc-M", "UI5xddFkv1o", "wIBRWo0PvIM",
			"Nf7uZcXBaP8", "iWT_h6BW6vI", "eI92HtGwSdI", "zVMQcBoy6ic",
			"LPFq51qOrrU", "USoatzDTEss", "t6DlW8ojuv8", "fufV8Sn9zbw",
			"tGajBnYvF6A", "KEf8r8CrHoU", "j6G4Ee00BIs", "wI0-k5sX_Qw",
			"xWb_iiCZziM", "rJgByCRzeCg", "WSISBIQzq50", "nIoAxWEzsUE",
			"AdR0vR-8--M", "6NWdfYAm598", "ZJccxBTP2IQ", "Ry3QP5KqegA",
			"H8-knmpzAXs", "zhYvsMcdKFw", "3rkZCRpOKHc", "iRIZPnBucZ0",
			"CLDucFGpMT4", "xeRBeUvXvSI", "RXM1EIg6uno", "XfOE7iBbScI",
			"qZt6H-fjQMs", "6ezKvURI9W4", "PlVM6R1pXxU", "KcfRyi3MPro",
			"VT1-ef93mV0", "A93ZXb2z_6c", "TRhebd7mrsY", "vibvXYZmWAI",
			"rI_gfqUfgFs", "4WbehvLzVP4", "QyonSvq9Wg4", "steoo9e6wTk",
			"gCDG195mNPk", "oOayP0_aqks", "Utxn7ie7Za4", "mwOZWBg0aNE",
			"Ocvwc_4_n7M", "-Gi6BWFb9rY", "_B8tvNWxpec", "DbrxspbaFfc",
			"zvo36-uS4Jc", "GyUoZtJboaI", "gPHfjI-MI3E", "x6vySPAWH9M",
			"sSv76gn5eQ4", "ucOSmkWtHjA", "E0O0Wl13mgw", "BratsdQHZS4",
			"TLw-LRObuog", "cOGHRZSb0Go", "Utf3I_zt6GE", "XhpeUHKTAfg",
			"Xi6cKRHhJjQ", "NzOMBeRvtWQ", "oOVX_o3chtE", "LYSBYAre_LA",
			"H2u8m5kU1Bw", "ZVliEstRXdg", "jsA7Cho5Wkc", "tS5E72oSQE0",
			"lSk3oP60n2U", "WPaqvvFRtf4", "njbL_huXl3U", "DT0vwzXyAaI",
			"Fu5vbC4vv5M", "o77EknVsvRg", "BeiPDCWF6To", "JoXypFYGww8",
			"LSRIpDcy0h0", "ECrFOTXYF98", "CF4Uly4_kUU", "BST8ToxCzyc",
			"06jggGbQKSk", "qJY3f7tsfa8", "6hwtlzalWUk", "J2vuziIgMbY",
			"M6o-AT3HtUs", "_MlW9rcfDnw", "_sRlq-GjDxc", "FZXFWJuBLoo",
			"ap01_0fqKZ0", "w3YjrFjPc0k", "G68xhsDID1U", "TNoxYLp637s",
			"27Nl2IR2e2s", "GiCMVfw0-j8", "FiQS3zf6FG8", "QrpF8SFvZ8c",
			"W8OL5WxO9JU", "Ri4lSFJ6j9I", "YlqwN0aCl6A", "_cEYjyyA8r0",
			"7NCKicf8O9M", "YGExW3Osvik", "ajv9HoVQwO8", "N_OMdWP59tc",
			"zLJ0-xKfO1o", "eZwPyxWhyp4", "TYa3MtbzTAU", "ek7_knuRl70",
			"VbWUvKx6Bd0", "Yaq7PZXZzok", "Dv636ck90Yo", "3GAIXY5DIME",
			"0tC8JbFEDNo", "pfspgzUUOck", "FMT7OPDNYak", "61dIlkbqryM",
			"ginrAbqxV1Q", "17XuVLmOlG0", "GherkKliRBk", "p-PKpRbNYTU",
			"5tmfGAMHEe0", "3o9505wLgio", "wYAn7vAS9as", "fjqifX6GCRM",
			"qZ6lbAoh92U", "TXUZ9enP4hE", "b8yFYXXFKYE", "ojKUUE1RtNs",
			"Mq7InN3fhA4", "FEzNAjo36Ww", "rtMZ2_iNW-Q", "s0w8iyjZXrk", 
			"2Buk3AIigeU", "SOG-Dx_vY2E", "hqm-_6m-qqU", "1QBkJnBaYP8",
			"j1T-hN8N4hE", "9laAc7Pk2c8", "WgG06miUV8Q", "K2l5U5LYDOQ",
			"dMGJxFEVxJk", "HLWRNk89X8s", "bvIAfJdXkXI", "CmcegSeX-kY",
			"RZUNvzHCrak", "dNHNGYpMG_4", "Yi_H7QPmG6I", "uoKtrsdPxdA",
			"CGX07xhqFdo", "aIVYp6Ao4Z4", "ARcEAI9v3lk", "_YLy19td_LU",
			"DQl6VIMk7vU", "vMQmD5NEaGg", "7kUW2F42VRo", "YGsVrouLBI4",
			"P_u4PPMfhmk", "7ad3SMKOz9U", "c--Qv0zC4_E", "PFnFcycbTWY",
			"30GivW1ZqVs", "o-_MAv4hNFA", "WXqauYCq3jY", "fo9oSGucz2c",
			"LD1_nb53y9c", "XXSQ3OqIoVQ", "Xg-ICHz4vVg", "mawdrYuthus", 
			"YVvJF-t4vqQ", "Jl0vlsgcfk0", "Ngd_qXOcrMU", "tY37sX-XTTE",
			"vKvQ3Xncp70", "xiPnW4_Pxa4", "mOdohDzV3U8", "AyvmU-Iv6ZI",
			"n43RsnNNxTM", "MsK8N3RhSvk", "WfpI349mtc8", "wNcOrzfm4kE", 
			"s2YXKEW-FJE", "7KHCHMhHVu4", "nBCrg-HTjNg", "zqynYaN8vu0",
			"-0plRUhAtV8", "ilTfYyt5qdE", "POycQa14ye0"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dbz);
		
		toolbar = (Toolbar) findViewById(R.id.appBar);

		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		Exp_list = (ExpandableListView) findViewById(R.id.expDBZ_list);
		episodes_category = DataProvider.getInfoDBZ();
		episodes_list = new ArrayList<String>(episodes_category.keySet());
		adapter = new MoviesAdaptergreen(this, episodes_category, episodes_list);
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
					childPosition+=253;
					break;
				case 1:
					childPosition+=39;
					break;
				case 2:
					childPosition+=74;
					break;
				case 3:
					childPosition+=219;
					break;
				case 4:
					childPosition+=194;
					break;
				case 5:
					childPosition+=165;
					break;
				case 6:
					childPosition+=107;
					break;
				case 7:
					childPosition+=139;
					break;
				}
				Intent i = new Intent(DBZ.this, Youtube.class);
				i.putExtra("value", dbz[childPosition]);
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
