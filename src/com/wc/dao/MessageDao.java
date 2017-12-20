package com.wc.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.wc.bean.Message;
import com.wc.db.DBAccess;

/**
 * ��message����ص����ݿ����
 *
 */
public class MessageDao {

	/**
	 * �������ݿ���
	 */
	public List<Message> queryMessageList(String command, String description) {
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList=new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// ͨ��sqlSessionִ��SQL���
			messageList = sqlSession.selectList("Message.queryMessageList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}

	public static void main(String[] args) {
		MessageDao messageDao = new MessageDao();
		messageDao.queryMessageList("", "");
	}

	/**
	 * ���ݲ�ѯ������ѯ��Ϣ�б�
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	// public List<Message> queryMessageList(String command, String description)
	// {
	// List<Message> messageList = new ArrayList<Message>();
	// try {
	// Class.forName("com.mysql.jdbc.Driver");
	// Connection conn =
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/wechat", "root",
	// "1234");
	// StringBuilder sql = new StringBuilder("select
	// ID,COMMAND,DESCRIPTION,CONTENT from MESSAGE where 1=1");
	// List<String> paramList = new ArrayList<String>();
	// if (command != null && !"".equals(command.trim())) {
	// sql.append(" and COMMAND=?");
	// paramList.add(command);
	// }
	// if (description != null && !"".equals(description.trim())) {
	// sql.append(" and DESCRIPTION like '%' ? '%'");
	// paramList.add(description);
	// }
	// PreparedStatement statement = conn.prepareStatement(sql.toString());
	// for (int i = 0; i < paramList.size(); i++) {
	// statement.setString(i + 1, paramList.get(i));
	// }
	// ResultSet rs = statement.executeQuery();
	// while (rs.next()) {
	// Message message = new Message();
	// messageList.add(message);
	// message.setId(rs.getString("ID"));
	// message.setCommand(rs.getString("COMMAND"));
	// message.setDescription(rs.getString("DESCRIPTION"));
	// message.setContent(rs.getString("CONTENT"));
	// }
	// } catch (ClassNotFoundException | SQLException e) {
	// // TODO Auto-generated catchblock
	// e.printStackTrace();
	// }
	// return messageList;
	// }

}
