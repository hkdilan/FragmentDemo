package com.hkdilan.android.fragmentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//11 or higher
		//static dual pane fragments example
		final Button btn1 = (Button) findViewById(R.id.button1);
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.HONEYCOMB){
					startActivity(new Intent(MainActivity.this, Fragment11Greater.class));
				}else{
					Toast.makeText(MainActivity.this, "android version level is less than 11. need support library v4 or sherlock library.", Toast.LENGTH_LONG).show();
				}
			}
		});
		
		//11 or higher
		//simple single pane dynamic example
		final Button btn2 = (Button) findViewById(R.id.button2);
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.HONEYCOMB){
					startActivity(new Intent(MainActivity.this, Fragment11GreaterDynamic.class));
				}else{
					Toast.makeText(MainActivity.this, "android version level is less than 11. need support library v4 or sherlock library.", Toast.LENGTH_LONG).show();
				}
			}
		});
		
		//less than 11 with support library v4
		//static dual pane fragments example
		final Button btn3 = (Button) findViewById(R.id.button3);
		btn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, OldFragment11Greater.class));
			}
		});
		
		//less than 11 with sherlock library
		//static dual pane fragments example
		final Button btn4 = (Button) findViewById(R.id.button4);
		btn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, SherlockFragment11Greater.class));
			}
		});
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
