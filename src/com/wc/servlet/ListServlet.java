package com.wc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wc.service.ListService;

/**
 * 列表初始化控制
 *
 */
public class ListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("UTF-8");
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		//向页面传值
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		ListService listService = new ListService();
		//查询消息列表并传给页面
		req.setAttribute("messageList", listService.queryMessageList(command, description));
		//向页面跳转
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
