package com.ntd.pushpush.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import com.ntd.pushpush.R;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

public class SlidingMenuActivity extends SlidingFragmentActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content_frame);
		
		setBehindContentView(R.layout.menu_frame);
		getSupportFragmentManager().beginTransaction()
									.replace(R.id.menu_frame, new LeftMenuFragment())
									.commit();
		
		getSupportFragmentManager().beginTransaction()
									.replace(R.id.content_frame, new MessageListFragment())
									.commit();
		
		
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		
		setSlidingActionBarEnabled(true);
//		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	public void switchContent(Fragment fragment) {
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.content_frame, fragment)
		.commit();
		getSlidingMenu().showContent();
	}
}
