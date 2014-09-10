package com.ntd.pushpush.activity;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.ntd.pushpush.R;
import com.ntd.pushpush.api.RegistByIdRequest;
import com.ntd.pushpush.request.OnRequestResponseListener;
import com.ntd.pushpush.request.Request;
import com.ntd.pushpush.request.RequestManager;
import com.ntd.pushpush.request.result.ApiErrorResult;
import com.ntd.pushpush.request.result.NetErrorResult;
import com.ntd.pushpush.request.result.SuccessResult;
import com.ntd.pushpush.util.MyPreferenceManager;
import com.ntd.pushpush.util.StringUtils;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends BaseActivity {
	private EditText etAccount;
	private EditText etPassword;
	private Button btnLogIn;
	
	@Override
	protected void onInit(Bundle savedInstanceState) {
		setContentView(R.layout.log_in);
		PushManager.startWork(getApplicationContext(),PushConstants.LOGIN_TYPE_API_KEY, "VdBcML5QebIi95hRqf09LTOy");
		initView();
	}

	private void initView() {
		etAccount = (EditText) this.findViewById(R.id.account);
		etPassword = (EditText) this.findViewById(R.id.password);
		btnLogIn = (Button) this.findViewById(R.id.login_btn);
		
		btnLogIn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (StringUtils.isEmpty(etAccount.getText().toString()) || StringUtils.isEmpty(etPassword.getText().toString())) {
					Toast.makeText(getApplicationContext(), "请完成全部内容的填写", Toast.LENGTH_SHORT).show();
					return ;
				}
				
				String account = etAccount.getText().toString().trim();
				String password = etPassword.getText().toString();
				
				// TODO channelID
				String user_id;
				String channel_id;
				try {
					user_id = MyPreferenceManager.getString("user_id", "");
					channel_id = MyPreferenceManager.getString("channel_id", "");
				} catch (Exception e) {
					Toast.makeText(getApplicationContext(), "正在初始化。。。请稍候再试", Toast.LENGTH_SHORT).show();
					return ;
				}
					
				RegistByIdRequest request = new RegistByIdRequest(account, password,"Student",user_id,channel_id);
				performLogIn(request);
			}
		});
	}
	
	/**
	 * 提交登录
	 * @param request
	 */
	private void performLogIn(RegistByIdRequest request) {
		RequestManager.getInstance().startRequest(new OnRequestResponseListener() {
			
			@Override
			public void onRequestSuccess(long requestId, Request request,
					SuccessResult successResult) {
				Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onRequestApiError(long requestId, Request request,
					ApiErrorResult apiErrorResult) {
				super.onRequestApiError(requestId, request, apiErrorResult);
				Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onRequestNetError(long requestId, Request request,
					NetErrorResult netErrorResult) {
				super.onRequestNetError(requestId, request, netErrorResult);
				Toast.makeText(getApplicationContext(), "登录失败，请检查网络", Toast.LENGTH_SHORT).show();
			}
		}, request);
	}

}
