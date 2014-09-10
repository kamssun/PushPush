package com.ntd.pushpush;

import com.baidu.frontia.FrontiaApplication;

public class PushApplication extends FrontiaApplication {
	private static PushApplication instance = null;

	public static PushApplication getInstance() {
		return instance;
		// AppConfigManager.getInstance().loadConfig();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
	}
}
