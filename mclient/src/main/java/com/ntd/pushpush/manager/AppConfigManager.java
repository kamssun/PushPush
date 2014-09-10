package com.ntd.pushpush.manager;

/**
 * Manager for {@link AppConfig}.
 * 
 */
public class AppConfigManager {

	public static enum AppConfig {
		/**
		 * enable share
		 */
		ENABLE_SHARE("APPCONFIG_BOOL_ENABLE_SHATE");

		private String configName;

		AppConfig(String configName) {
			this.configName = configName;
		}

		public String getConfigName() {
			return configName;
		}
	}

	private static class AppConfigManagerContainer {
		private static AppConfigManager instance = new AppConfigManager();
	}

	public static AppConfigManager getInstance() {
		return AppConfigManagerContainer.instance;
	}

	private AppConfigManager() {
	}

	/**
	 * Loads all application configuration.
	 */
	public void loadConfig() {
//		final SharedPreferences sharedPreferences = SharedPreferencesManager.getSharedPreferences();
//		isEnableShare = sharedPreferences.getBoolean(AppConfig.ENABLE_SHARE.getConfigName(), false);
	}

	/**
	 * Just s demo
	 */
	// private boolean isEnableShare = false;
	//
	// public boolean isEnableShare() {
	// return isEnableShare;
	// }
	//
	// /**
	// * Sets enable share and save the value in the {@link SharedPreferences}.
	// *
	// * @see SharedPreferencesName#APPCONFIG_BOOL_ENABLE_SHARE
	// */
	// public void saveEnableShare(boolean isEnableShare) {
	// final Editor editor =
	// SharedPreferencesManager.getSharedPreferences().edit();
	// editor.putBoolean(AppConfig.ENABLE_SHARE.getConfigName(), isEnableShare);
	// editor.commit();
	// this.isEnableShare = isEnableShare;
	// }
}
