package com.notice;

import com.commons.Action;

public class ActionNoticeFactory {
	private static ActionNoticeFactory instance = null;
	private ActionNoticeFactory() {}
	
	public static ActionNoticeFactory getInstance() {
		if(instance == null) {
			instance = new ActionNoticeFactory();
		}
		return instance;
	}
	
	public Action getAction(String cmd) {
		Action action = null;
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
