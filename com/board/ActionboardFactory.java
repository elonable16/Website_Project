package com.board;
import com.commons.Action;

public class ActionboardFactory {
	private static ActionboardFactory instance = null;
	private ActionboardFactory() {}; // 싱글톤 기법, 생성을 막음
	public static ActionboardFactory getInstance() {
		if(instance == null) {// 객체가 생성되어 있지 않다면 생성
			instance = new ActionboardFactory();
		}
		return instance;
	}
	public Action getAction(String cmd) {
		Action action = null;
		if(cmd.equals("board_list")) {
			action = new BoardListAction();
		}else if(cmd.equals("board_insert_form")) {
			action = new BoardInsertFormAction();
		}else if (cmd.equals("board_insert")) {
			action = new BoardInsertAction();
		}else if (cmd.equals("board_view")){
			action = new BoardViewAction();
		}else if (cmd.equals("board_check_form")){
			action = new BoardCheckFormAction();
		}else if (cmd.equals("board_check_ok")) {
			action = new BoardCheckAction();
		}else if (cmd.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
		}else if (cmd.equals("board_update")) {
			action = new BoardUpdateAction();
		}else if (cmd.equals("board_delete")) {
			action = new BoardDeleteAction();
		}
		return action;
	}
}
