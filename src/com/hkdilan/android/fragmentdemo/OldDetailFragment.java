package com.hkdilan.android.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OldDetailFragment extends Fragment {
	private static final String TAG = OldDetailFragment.class.getSimpleName();
	
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
