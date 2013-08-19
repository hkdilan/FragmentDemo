package com.hkdilan.android.fragmentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;


public class OldFragment11Greater extends FragmentActivity implements OldMyListFragment.OnItemSelectedListner {
	private static final String TAG = OldFragment11Greater.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.v(TAG, "onCreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.old_fragment11greater_fragment);
	}

	@Override
	public void onItemSelected(String time) {
		Log.v(TAG, "onItemSelected()");
		
		//get detail fragment
		final OldDetailFragment detailFragment = (OldDetailFragment) getSupportFragmentManager().findFragmentById(R.id.oldDetailFragment);
		
		//check fragment is available and statically define in xml
		if(detailFragment != null && detailFragment.isInLayout()){
			Log.v(TAG, "fragment is available and statically define in xml");
			detailFragment.setText(time);
		}else{
			Log.v(TAG, "fragment is not available. start new activity");
			
			final Intent intent = new Intent(OldFragment11Greater.this, DetailActivity.class);
			intent.putExtra(DetailActivity.EXTRA_TEXT, time);
			startActivity(intent);
		}
	}
}
