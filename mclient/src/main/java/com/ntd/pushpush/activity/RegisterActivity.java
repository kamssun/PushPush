package com.ntd.pushpush.activity;

import com.ntd.pushpush.R;
import com.ntd.pushpush.api.RegisterByPhoneRequest;
import com.ntd.pushpush.request.OnRequestResponseListener;
import com.ntd.pushpush.request.Request;
import com.ntd.pushpush.request.RequestManager;
import com.ntd.pushpush.request.result.ApiErrorResult;
import com.ntd.pushpush.request.result.NetErrorResult;
import com.ntd.pushpush.request.result.SuccessResult;
import com.ntd.pushpush.util.StringUtils;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends BaseActivity {
	private EditText etPhoneNum;
	private EditText etRealName;
	private Button btnSubmit;

	@Override
	protected void onInit(Bundle savedInstanceState) {
		setContentView(R.layout.register);
		
		initView();
	}

	private void initView() {
		etPhoneNum = (EditText) this.findViewById(R.id.phone_num);
		etRealName = (EditText) this.findViewById(R.id.real_name);
		btnSubmit = (Button) this.findViewById(R.id.submit);
		
		btnSubmit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if (StringUtils.isEmpty(etPhoneNum.getText().toString()) || StringUtils.isEmpty(etRealName.getText().toString())) {
					if (etPhoneNum.getText().toString().length() > 13) {
						Toast.makeText(getApplicationContext(), "请输入真实电话号码", Toast.LENGTH_SHORT).show();
						return ;
					}
					Toast.makeText(getApplicationContext(), "请完成全部内容的填写，谢谢", Toast.LENGTH_SHORT).show();
					return ;
				}
				
				String phoneNum = etPhoneNum.getText().toString().trim();
				String realName = etRealName.getText().toString();
				performSubmit(new RegisterByPhoneRequest(phoneNum, realName));
			}
		});
	}

	/**
	 * 提交注册
	 */
	private void performSubmit(RegisterByPhoneRequest request) {
		RequestManager.getInstance().startRequest(new OnRequestResponseListener() {
			
			@Override
			public void onRequestSuccess(long requestId, Request request,
					SuccessResult successResult) {
				Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onRequestApiError(long requestId, Request request,
					ApiErrorResult apiErrorResult) {
				super.onRequestApiError(requestId, request, apiErrorResult);
				Toast.makeText(getApplicationContext(), "注册失败", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onRequestNetError(long requestId, Request request,
					NetErrorResult netErrorResult) {
				super.onRequestNetError(requestId, request, netErrorResult);
				Toast.makeText(getApplicationContext(), "注册失败，请检查网络", Toast.LENGTH_SHORT).show();
			}
		}, request);
	}
}
