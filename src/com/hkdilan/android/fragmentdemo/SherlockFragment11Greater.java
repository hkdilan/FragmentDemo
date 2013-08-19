package com.hkdilan.android.fragmentdemo;

import com.actionbarsherlock.app.SherlockFragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


public class SherlockFragment11Greater extends SherlockFragmentActivity implements SherlockMyListFragment.OnItemSelectedListner {
	private static final String TAG = SherlockFragment11Greater.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.v(TAG, "onCreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sherlock_fragment11greater_fragment);
	}

	@Override
	public void onItemSelected(String time) {
		Log.v(TAG, "onItemSelected()");
		
		//get detail fragment
		final SherlockDetailFragment detailFragment = (SherlockDetailFragment) getSupportFragmentManager().findFragmentById(R.id.sherlockDetailFragment);
		
		//check fragment is available and statically define in xml
		if(detailFragment != null && detailFragment.isInLayout()){
			Log.v(TAG, "fragment is available and statically define in xml");
			detailFragment.setText(time);
		}else{
			Log.v(TAG, "fragment is not available. start new activity");
			
			final Intent intent = new Intent(SherlockFragment11Greater.this, DetailActivity.class);
			intent.putExtra(DetailActivity.EXTRA_TEXT, time);
			startActivity(intent);
		}
	}
}
