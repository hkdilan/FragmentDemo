package com.hkdilan.android.fragmentdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


@SuppressLint("NewApi")
public class Fragment11Greater extends Activity implements MyListFragment.OnItemSelectedListner {
	private static final String TAG = Fragment11Greater.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.v(TAG, "onCreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment11greater_fragment);
	}

	@Override
	public void onItemSelected(String time) {
		Log.v(TAG, "onItemSelected()");
		
		//get detail fragment
		final DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detailFragment);
		
		//check fragment is available and statically define in xml
		if(detailFragment != null && detailFragment.isInLayout()){
			Log.v(TAG, "fragment is available and statically define in xml");
			detailFragment.setText(time);
		}else{
			Log.v(TAG, "fragment is not available. start new activity");
			
			final Intent intent = new Intent(Fragment11Greater.this, DetailActivity.class);
			intent.putExtra(DetailActivity.EXTRA_TEXT, time);
			startActivity(intent);
		}
	}
}
