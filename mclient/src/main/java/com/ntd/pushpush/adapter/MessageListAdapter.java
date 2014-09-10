package com.ntd.pushpush.adapter;

import java.util.List;

import com.fortysevendeg.android.swipelistview.SwipeListView;
import com.ntd.pushpush.R;
import com.ntd.pushpush.data.ContactsInfo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MessageListAdapter extends BaseAdapter {
	private LayoutInflater inflater;
	private List<ContactsInfo> data;
	private OnItemSelectListener listener;
	private boolean isEditmode = false;
	private SwipeListView listView;
	
	public MessageListAdapter(Context context, List<ContactsInfo> data, SwipeListView listView, OnItemSelectListener listener) {
		this.inflater = LayoutInflater.from(context);
		this.data = data;
		this.listView = listView;
		this.listener = listener;
	}
	
	public static interface OnItemSelectListener {
	    void onSelectedCountChanged(int selectNum);
	}
	
	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int arg0) {
		return data.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		ViewHolder holder = null;
		
		if (convertView == null) {
			convertView = this.inflater.inflate(R.layout.list_item_msg_item, null);
			holder = new ViewHolder();
			
			holder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
			holder.name = (TextView) convertView.findViewById(R.id.name);
			holder.cb = (ImageView) convertView.findViewById(R.id.checkbox);
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		final ContactsInfo item = data.get(position);
		holder.name.setText(item.getUserName());
		
		return convertView;
	}

	static class ViewHolder {
		private ImageView avatar;
		private TextView name;
		private ImageView cb;
	}
	
	OnItemSelectListener onItemSelectListener = new OnItemSelectListener() {
		
		@Override
		public void onSelectedCountChanged(int selectNum) {
			// TODO Auto-generated method stub
			
		}
	};
}
