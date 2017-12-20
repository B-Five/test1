package com.wc.service;

import java.util.List;

import com.wc.bean.Message;
import com.wc.dao.MessageDao;

/**
 * 列表相关的业务功能
 *
 */
public class ListService {
	public List<Message> queryMessageList(String command,String description){
		MessageDao messagedao=new MessageDao();
		return messagedao.queryMessageList(command, description);
	}
}
