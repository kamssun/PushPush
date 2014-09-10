package com.ntd.pushpush.activity;

import com.ntd.pushpush.R;
import android.os.Bundle;
import android.widget.EditText;

/**
 * 填写消息内容
 * 
 * @author _sush
 */
public class WriteMsgContentActivity extends BaseActivity {
	private EditText etContent;
	
	@Override
	protected void onInit(Bundle savedInstanceState) {
		setContentView(R.layout.write_msg_content);
		
		initView();
	}

	private void initView() {
		etContent = (EditText) this.findViewById(R.id.content);
	}

}
