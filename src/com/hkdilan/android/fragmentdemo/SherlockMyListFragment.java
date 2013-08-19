package com.hkdilan.android.fragmentdemo;

import com.actionbarsherlock.app.SherlockFragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SherlockMyListFragment extends SherlockFragment {
	private static final String TAG = SherlockMyListFragment.class.getSimpleName();
	
	private OnItemSelectedListner mOnItemSelectedListner;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.v(TAG, "onCreateView()");
		
		final View view = inflater.inflate(R.layout.mylist_fragment, container, false);
		
		final Button btn = (Button) view.findViewById(R.id.button1);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.v(TAG, "onItemSelected()");
				updateDetail();
			}
		});
		return view;
	}
	
	@Override
	public void onAttach(Activity activity) {
		Log.v(TAG, "onAttach()");
		super.onAttach(activity);
		
		if(activity instanceof OnItemSelectedListner){
			mOnItemSelectedListner = (OnItemSelectedListner) activity;
		}else{
			throw new ClassCastException("implement OnItemSelectedListner in your activity.");
		}
	}
	
	private void updateDetail() {
		Log.v(TAG, "updateDetail()");
		final String time = String.valueOf(System.currentTimeMillis());
		mOnItemSelectedListner.onItemSelected( time);
	}
	
	public interface OnItemSelectedListner{
		public void onItemSelected(String time);
	}
}
