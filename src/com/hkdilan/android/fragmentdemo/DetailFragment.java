package com.hkdilan.android.fragmentdemo;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("NewApi")
public class DetailFragment extends Fragment {
	private static final String TAG = DetailFragment.class.getSimpleName();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.v(TAG, "onCreateView()");
		
		final View view = inflater.inflate(R.layout.detail_fragment, container, false);
		
		final TextView tv = (TextView) view.findViewById(R.id.detailText);
		tv.setText("Detail Fragment");
		
		return view;
	}
	
	public void setText(String text){
		Log.v(TAG, "setText()");
		
		final TextView tv = (TextView) getView().findViewById(R.id.detailText);
		tv.setText(text);
	}
}
