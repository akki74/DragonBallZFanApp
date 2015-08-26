package com.example.dbzepisodesmovies;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class MoviesAdapterred extends BaseExpandableListAdapter {

	private Context ctx;
	private HashMap<String, List<String>> Movies_Category;
	private List<String> Movies_List;

	public MoviesAdapterred(Context ctx,
			HashMap<String, List<String>> Movies_Category,
			List<String> Movies_List) {
		this.ctx = ctx;
		this.Movies_Category = Movies_Category;
		this.Movies_List = Movies_List;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return Movies_List.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return Movies_Category.get(Movies_List.get(groupPosition)).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return Movies_List.get(groupPosition);
	}

	@Override
	public Object getChild(int parent, int child) {
		// TODO Auto-generated method stub
		return Movies_Category.get(Movies_List.get(parent)).get(child);
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public long getChildId(int parent, int child) {
		// TODO Auto-generated method stub
		return child;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public View getGroupView(int parent, boolean isExpanded,
			View convertView, ViewGroup parentview) {
		// TODO Auto-generated method stub
		String group_title = (String) getGroup(parent);
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) ctx
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.parent_layoutred, parentview, false);
		}
		TextView parent_textview = (TextView) convertView.findViewById(R.id.parent_txt);
		parent_textview.setTypeface(null, Typeface.BOLD);
		parent_textview.setText(group_title);
		return convertView;
	}

	@Override
	public View getChildView(int parent, int child, boolean LastChild,
			View convertview, ViewGroup parentview) {
		// TODO Auto-generated method stub
		String child_title = (String) getChild(parent, child);
		if (convertview == null) {
			LayoutInflater inflater = (LayoutInflater) ctx
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertview = inflater.inflate(R.layout.child_layout, parentview,
					false);
		}

		TextView child_textview = (TextView) convertview
				.findViewById(R.id.child_txt);
		child_textview.setText(child_title);

		return convertview;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

}