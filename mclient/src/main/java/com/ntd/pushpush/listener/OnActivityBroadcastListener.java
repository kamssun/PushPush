package com.ntd.pushpush.listener;

import android.content.Context;
import android.content.Intent;

/**
 * @author wlei 2012-10-22
 */
public interface OnActivityBroadcastListener {

  void onBroadcastReceived(Context context, Intent intent);
}
