package com.android.MyAdapters;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.ListViewApplication.R;
import com.android.MyClasses.InfoClass;

public class MyAdapter extends ArrayAdapter<InfoClass> 
{
	Activity context;
	ArrayList<InfoClass> arrayInfo;

	public MyAdapter(Activity context, ArrayList<InfoClass> arrayInfo) {
		super(context,R.layout.list_item,R.id.text,arrayInfo);
		this.context=context;
		this.arrayInfo=arrayInfo;
	}


	@Override
	public int getCount() {
		return arrayInfo.size();
	}

	@Override
	public InfoClass getItem(int position) {
		
		return arrayInfo.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout layout=null;
		TextView text;
		
		ViewHolder holder;
		InfoClass info=arrayInfo.get(position);
		if(convertView==null){
			LayoutInflater inflater=context.getLayoutInflater();
			convertView=inflater.inflate(R.layout.my_list_view,null);
			
			holder = new ViewHolder();
			holder.img= (ImageView) convertView.findViewById(R.id.imagFavLogo);
			holder.name = (TextView) convertView
					.findViewById(R.id.textName);
			holder.age = (TextView) convertView
					.findViewById(R.id.textAge);
			
			convertView.setTag(holder);
		}
		else {
			holder=(ViewHolder)convertView.getTag();
		}
	//	text=(TextView)layout.findViewById(R.id.text);
	//	text.setText(info.getiName()+"\t"+info.getiAge());
		
		holder.img.setImageResource(R.drawable.star2);
		holder.name.setText(info.getiName());
		holder.age.setText(String.format("%d",info.getiAge()));	
		
		
		return convertView;
	}
	
	static class ViewHolder {
		ImageView img;
		TextView name;
		TextView age;		
	}
	


}
