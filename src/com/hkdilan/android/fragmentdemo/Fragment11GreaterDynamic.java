package com.hkdilan.android.fragmentdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


@SuppressLint("NewApi")
public class Fragment11GreaterDynamic extends Activity implements MyListFragment.OnItemSelectedListner {
	private static final String TAG = Fragment11GreaterDynamic.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.v(TAG, "onCreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment11greater_dynamic_fragment);
		
		final FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.details, new MyListFragment());
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		ft.commit();
	}

	@Override
	public void onItemSelected(String time) {
		Log.v(TAG, "onItemSelected()");
		
		final View detailView = findViewById(R.id.details);
		if(detailView != null && detailView.getVisibility() == View.VISIBLE){
			final DetailFragment detailFragment = new DetailFragment();
			
			final FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.details, detailFragment);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			//add to back stack
			ft.addToBackStack(null);
			ft.commit();
		}
	}
}
