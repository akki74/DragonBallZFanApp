package com.example.dbzepisodesmovies;

import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class VivzAdapter extends RecyclerView.Adapter<VivzAdapter.MyViewHolder> {

	private LayoutInflater inflater;
	List<Information> data = Collections.emptyList();
	Context c;

	public VivzAdapter(Context context, List<Information> data) {
		inflater = LayoutInflater.from(context);
		this.data = data;
		this.c = context;
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.custom_row, arg0, false);
		MyViewHolder holder = new MyViewHolder(view);
		return holder;
	}
	
	@Override
	public void onBindViewHolder(MyViewHolder holder, int position) {
		// TODO Auto-generated method stub
		Information current = data.get(position);
		holder.title.setText(current.title);
		holder.icon.setImageResource(current.iconId);
	}
	
	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	class MyViewHolder extends RecyclerView.ViewHolder {

		TextView title;
		ImageView icon;

		public MyViewHolder(View itemView) {
			super(itemView);
			title = (TextView) itemView.findViewById(R.id.listText);
			icon = (ImageView) itemView.findViewById(R.id.listIcon);
			Typeface type = Typeface.createFromAsset(c.getAssets(),
					"fonts/Saiyan-Sans.ttf");
			title.setTypeface(type);
			// TODO Auto-generated constructor stub
		}
	}
}
