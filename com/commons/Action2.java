package com.commons;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action2 {
	public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException;
	// controler의 인터페이스 구축 예외 발생시 호출한곳으로 예외의 처리를 던진다.
}
