package com.ntd.pushpush.activity;

import com.ntd.pushpush.listener.OnActivityBroadcastListener;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public abstract class BaseActivity extends Activity implements OnActivityBroadcastListener {
	private class MyBroadcastReceiver extends BroadcastReceiver {

		@Override
		public final void onReceive(Context context, Intent intent) {
			onBroadcastReceived(context, intent);
		}
	}

	/**
	 * Called when broadcast received.
	 */
	@Override
	public void onBroadcastReceived(Context context, Intent intent) {}

	private MyBroadcastReceiver myBroadcastReceiver = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		onInit(savedInstanceState);
	}

	protected abstract void onInit(Bundle savedInstanceState);
}
