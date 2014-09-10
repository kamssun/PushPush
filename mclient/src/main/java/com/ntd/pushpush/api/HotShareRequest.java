package com.ntd.pushpush.api;



public class HotShareRequest extends ApiRequest {
	private static final long serialVersionUID = 1L;

	@ApiField(paramName = "listcnt")
	int listcnt;
	@ApiField(paramName = "page")
	int page;
	@ApiField(paramName = "local_version")
	String local_version;

	public HotShareRequest(int listcnt, int page) {
		this.listcnt = listcnt;
		this.page = page;
		this.local_version = "2.18";
	}
}
