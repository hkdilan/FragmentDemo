package com.hkdilan.android.fragmentdemo;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailActivity extends Activity {
	private static final String TAG = DetailActivity.class.getSimpleName();
	public static final String EXTRA_TEXT = "EXTRA_TEXT";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.v(TAG, "onCreate()");
		super.onCreate(savedInstanceState);
		
		//need to check if activity has been switched to landscape mode
		//if yes, finish and go back to the start activity
		if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
			finish();
			return;
		}
		
		setContentView(R.layout.activity_detail);
		final Bundle extras = getIntent().getExtras();
		if(extras != null){
			final String text = extras.getString(EXTRA_TEXT);
			final TextView tv = (TextView) findViewById(R.id.detailText);
			tv.setText(text);
		}
	}
}
