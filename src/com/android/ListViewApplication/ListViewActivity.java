package com.android.ListViewApplication;


import java.util.ArrayList;

import com.android.MyAdapters.MyAdapter;
import com.android.MyAdapters.MyHelper;
import com.android.MyClasses.InfoClass;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends Activity {
	
	ListView listNameAge;
	ArrayList<InfoClass> arrayInfo;
	InfoClass info;
	MyAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
        
        arrayInfo=new ArrayList<InfoClass>();
       
        
        MyHelper helper=new MyHelper(ListViewActivity.this);
		SQLiteDatabase db=helper.getReadableDatabase();
		
		Cursor cur=db.query("list", new String[]{"name","age"}, null, null, null, null, null);

		if(cur.moveToFirst())
		{
			do
			{
				 info=new InfoClass();
				info.setiName(cur.getString(cur.getColumnIndex("name")));
				info.setiAge(cur.getInt(cur.getColumnIndex("age")));
				Log.d("Data",info.toString());
				arrayInfo.add(info);
			
			}while(cur.moveToNext());
		}
		cur.close();
		
	
		adapter=new MyAdapter(this,arrayInfo);
		
       listNameAge=(ListView)findViewById(R.id.list);
       listNameAge.setAdapter(adapter);
     //  adapter.notifyDataSetChanged();           
  
       listNameAge.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			Log.d("****", "*********");

			InfoClass info=(InfoClass)listNameAge.getItemAtPosition(position);
			Intent intent=new Intent(ListViewActivity.this,DisplayProfileActivity.class);
			intent.putExtra("name", info.getiName());
			intent.putExtra("age", info.getiAge());
			startActivity(intent);
		}
	});
       
    }
 
}