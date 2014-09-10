package com.ntd.pushpush.activity;

import com.ntd.pushpush.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LeftMenuFragment extends ListFragment {
	public LeftMenuFragment() {
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return  inflater.inflate(R.layout.left_menu_fragment, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getActivity(), 
			R.layout.list_item_left_menu, R.id.title, getResources().getStringArray(R.array.left_menu_list));
		setListAdapter(colorAdapter);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Fragment newContent = null;
		switch (position) {
		case 0:
			newContent = new MessageListFragment();
			break;
		case 1:
			newContent = new ToDoFragment();
			break;
		default:
			break;
		}
		if (newContent != null) {
			switchFragment(newContent);
		}
	}
	
	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;
		
		if (getActivity() instanceof SlidingMenuActivity) {
			SlidingMenuActivity fca = (SlidingMenuActivity) getActivity();
			fca.switchContent(fragment);
		}
	}
}
