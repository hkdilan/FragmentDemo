package com.hkdilan.android.fragmentdemo;

import com.actionbarsherlock.app.SherlockFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SherlockDetailFragment extends SherlockFragment {
	private static final String TAG = SherlockDetailFragment.class.getSimpleName();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.v(TAG, "onCreateView()");
		
		final View view = inflater.inflate(R.layout.detail_fragment, container, false);
		
		final TextView tv = (TextView) view.findViewById(R.id.detailText);
		tv.setText("Sherlock Detail Fragment");
		
		return view;
	}
	
	public void setText(String text){
		Log.v(TAG, "setText()");
		
		final TextView tv = (TextView) getView().findViewById(R.id.detailText);
		tv.setText(text);
	}
}
