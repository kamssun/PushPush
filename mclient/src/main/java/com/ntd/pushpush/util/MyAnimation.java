package com.ntd.pushpush.util;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public class MyAnimation {
	// 提示动画: 从View底部 由下至上
	public static Animation B_bottomToUp() {
		Animation anim = new TranslateAnimation(0, 0, 0, 0, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
		anim.setDuration(500);
		return anim;
	}
	
	// 提示动画: 从View底部 由下至上
	public static Animation B_upToBottom() {
		Animation anim = new TranslateAnimation(0, 0, 0, 0, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
		anim.setDuration(1000);
		return anim;
	}
	
	// 提示动画: 从View上部 由上至下
	public static Animation U_upToBottom() {
		Animation anim = new TranslateAnimation(0, 0, 0, 0, Animation.RELATIVE_TO_SELF, -1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
		anim.setDuration(500);
		return anim;
	}
	
	
}
