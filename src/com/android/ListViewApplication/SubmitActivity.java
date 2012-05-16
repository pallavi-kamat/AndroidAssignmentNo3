package com.android.ListViewApplication;

import com.android.MyAdapters.MyHelper;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubmitActivity extends Activity{
	
	TextView textName,textAge;
	EditText editName,editAge;
	Button buttonShow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.main);
		 
		 textName=(TextView)findViewById(R.id.textName);
		 editName=(EditText)findViewById(R.id.editName);
		 textAge=(TextView)findViewById(R.id.textAge);
		 editAge=(EditText)findViewById(R.id.editAge);
		 
		 buttonShow=(Button)findViewById(R.id.buttonShow);
		 buttonShow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				MyHelper helper=new MyHelper(SubmitActivity.this);
				SQLiteDatabase db=helper.getWritableDatabase();
				
				
				 ContentValues cv = new ContentValues();
				 cv.put("name", editName.getText().toString());
				 cv.put("age", Integer.parseInt(editAge.getText().toString()));
				db.insert("list",null,cv);
			
				
			/*	ContentValues cv1 = new ContentValues();
				 cv.put("name", "Datta");
				 cv.put("emailId","Datta@yahoo.com");
				 cv.put("age",23);
				 cv.put("gender","Male");
				db.insert("info",null,cv);*/
				db.close();
				
				Intent intent=new Intent(SubmitActivity.this,ListViewActivity.class);
				startActivity(intent);		
				
				
				
			}
		});
		 
	}

}
