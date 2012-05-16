package com.android.ListViewApplication;

import com.android.MyAdapters.MyHelper;
import com.android.MyClasses.InfoClass;

import android.R.bool;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayProfileActivity extends Activity {
	
	TextView textProfileName,textData;
	InfoClass info;
	String name;
	int age;
	Boolean flag=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);

		
		textProfileName=(TextView)findViewById(R.id.textHeadline);
		textData=(TextView)findViewById(R.id.textData);
		
		Intent intent=getIntent();
		name=(String)intent.getSerializableExtra("name");
		age=(Integer)intent.getSerializableExtra("age");
		
		 MyHelper helper=new MyHelper(DisplayProfileActivity.this);
			SQLiteDatabase db=helper.getReadableDatabase();
			
			Cursor cur=db.query("info", new String[]{"name","emailId","age","gender"}, null, null, null, null, null);

			if(cur.moveToFirst())
			{
				do
				{
					 info=new InfoClass();
					info.setiName(cur.getString(cur.getColumnIndex("name")));
					info.setiEmialId(cur.getString(cur.getColumnIndex("emailId")));
					info.setiAge(cur.getInt(cur.getColumnIndex("age")));
					info.setiGender(cur.getString(cur.getColumnIndex("gender")));
					if(info.getiName().equals(name) && info.getiAge()==age)
					{
						textData.setText(info.toString());
						flag=true;
					}
					Log.d("Data",info.toString());
				
				//	cur.moveToNext();
				}while(cur.moveToNext());
			
				if(flag==false)
				{
					Toast.makeText(getApplicationContext(), "Data is not present in database",Toast.LENGTH_SHORT).show();
				}
			}
			cur.close();
			

	}

}
