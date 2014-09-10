package com.ntd.pushpush.activity;

import java.util.ArrayList;
import java.util.List;
import uk.co.senab.actionbarpulltorefresh.extras.actionbarsherlock.PullToRefreshAttacher;
import com.fortysevendeg.android.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.android.swipelistview.SwipeListView;
import com.ntd.pushpush.PushApplication;
import com.ntd.pushpush.R;
import com.ntd.pushpush.adapter.MessageListAdapter;
import com.ntd.pushpush.adapter.MessageListAdapter.OnItemSelectListener;
import com.ntd.pushpush.data.ContactsInfo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MessageListFragment extends Fragment implements PullToRefreshAttacher.OnRefreshListener, 
	OnItemSelectListener {
	private List<ContactsInfo> data;
	private SwipeListView swipeListView;
	private PullToRefreshAttacher pullToRefreshAttacher;
	private Context con;
	
//	public MessageListFragment() {
//	}
//	
//	public MessageListFragment(Context con) {
//		this.con = con;
//	}
	 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.message_list_fragment, null);
		initData();
		initView(view);
		return view;
	}
	
	private void initData() {
		data = new ArrayList<ContactsInfo>();
		
		// test data
		for (int i = 0; i < 10; i++) {
			ContactsInfo item = new ContactsInfo();
			item.setUserName("name" + i);
			data.add(item);
		}
	}

	private void initView(View view) {
		
		swipeListView = (SwipeListView) view.findViewById(R.id.listView);
		swipeListView.setAdapter(new MessageListAdapter(getActivity(), data, swipeListView, this));
		swipeListView.setSwipeOpenOnLongPress(true);
		swipeListView.setOffsetLeft(200);
		
		swipeListView.setSwipeListViewListener(new BaseSwipeListViewListener() {
			 @Override
	            public void onOpened(int position, boolean toRight) {
	            }

	            @Override
	            public void onClosed(int position, boolean fromRight) {
	            }

	            @Override
	            public void onListChanged() {
	            }

	            @Override
	            public void onMove(int position, float x) {
	            }

	            @Override
	            public void onStartOpen(int position, int action, boolean right) {
	                Log.d("swipe", String.format("onStartOpen %d - action %d", position, action));
	            }

	            @Override
	            public void onStartClose(int position, boolean right) {
	                Log.d("swipe", String.format("onStartClose %d", position));
	            }

	            @Override
	            public void onClickFrontView(int position) {
	                Log.d("swipe", String.format("onClickFrontView %d", position));
	            }

	            @Override
	            public void onClickBackView(int position) {
	                Log.d("swipe", String.format("onClickBackView %d", position));
	            }

	            @Override
	            public void onDismiss(int[] reverseSortedPositions) {
	            }
		});
		
//		pullToRefreshAttacher = new PullToRefreshAttacher((Activity) con.getApplicationContext());
//		pullToRefreshAttacher.setRefreshableView(listView, this);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onSelectedCountChanged(int selectNum) {
		
	}

	@Override 
	public void onRefreshStarted(View view) {
		// TODO Auto-generated method stub
		
	}
}
