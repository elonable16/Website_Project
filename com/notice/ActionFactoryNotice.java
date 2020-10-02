package com.notice;

public class ActionFactoryNotice {
	private static ActionFactoryNotice instance = null;
	private ActionFactoryNotice() {}
	
	public static ActionFactoryNotice getInstance() {
		if(instance == null) {
			instance = new ActionFactoryNotice();
		}
		return instance;
	}
	
	public ActionNotice getActionNotice(String cmd) {
		ActionNotice action = null;
		if(cmd.equals("notice_list")) {
			action = new NoticeListAction();
		}else if(cmd.equals("notice_view")) {
			action = new NoticeViewAction();
		}else if(cmd.equals("notice_update_form")) {
			action = new NoticeUpdateFormAction();
		}
		return action;
	}

}
