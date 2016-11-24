package com.chinasei.struts1.db.utils;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.text.DateFormat;
import java.util.*;
import java.util.Date;

//import org.apache.log4j.Logger;

/**
 * ���ݿ����������
 */
public class DbUtils {
	
	//private static Logger logger = Logger.getLogger("DbUtils");
	
	/**
	 * ����������һ�� SQL INSERT��UPDATE �� DELETE ���
	 * @param sql
	 * @param paramList����������SQL����е�ռλ��һһ��Ӧ
	 * @return
	 * @throws Exception
	 */
	public static int execute(String sql, List<Object> paramList) throws Exception {
		if(sql == null || sql.trim().equals("")) {
			//logger.info("parameter is valid!");
		}

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DbUtils.getConnection();
			pstmt = DbUtils.getPreparedStatement(conn, sql);
			setPreparedStatementParam(pstmt, paramList);
			if(pstmt == null) {
				return -1;
			}
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			//logger.info(e.getMessage());
			throw new Exception(e);
		} finally {
			closeStatement(pstmt);
			closeConn(conn);
		}

		return result;
	}
	
	/**
	 * ����ѯ���ݿ��õĽ����ת��ΪMap����
	 * @param sql����ѯ���
	 * @param paramList������
	 * @return
	 */
	public static List<Map<String, String>> getQueryList(String sql, List<Object> paramList) throws Exception {
		if(sql == null || sql.trim().equals("")) {
			//logger.info("parameter is valid!");
			return null;
		}

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Map<String, String>> queryList = null;
		try {
			conn = DbUtils.getConnection();
			pstmt = DbUtils.getPreparedStatement(conn, sql);
			setPreparedStatementParam(pstmt, paramList);
			if(pstmt == null) {
				return null;
			}
			rs = DbUtils.getResultSet(pstmt);
			queryList = DbUtils.getQueryList(rs);
		} catch (RuntimeException e) {
			//logger.info(e.getMessage());
			System.out.println("parameter is valid!");
			throw new Exception(e);
		} finally {
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConn(conn);
		}
		return queryList;
	}
	
	private static void setPreparedStatementParam(PreparedStatement pstmt, List<Object> paramList) throws Exception {
		if(pstmt == null || paramList == null || paramList.isEmpty()) {
			return;
		}
		DateFormat df = DateFormat.getDateTimeInstance();
		for (int i = 0; i < paramList.size(); i++) {
			if(paramList.get(i) instanceof Integer) {
				int paramValue = ((Integer)paramList.get(i)).intValue();
				pstmt.setInt(i+1, paramValue);
			} else if(paramList.get(i) instanceof Float) {
				float paramValue = ((Float)paramList.get(i)).floatValue();
				pstmt.setFloat(i+1, paramValue);
			} else if(paramList.get(i) instanceof Double) {
				double paramValue = ((Double)paramList.get(i)).doubleValue();
				pstmt.setDouble(i+1, paramValue);
			} else if(paramList.get(i) instanceof Date) {
				pstmt.setString(i+1, df.format((Date)paramList.get(i)));
			} else if(paramList.get(i) instanceof Long) {
				long paramValue = ((Long)paramList.get(i)).longValue();
				pstmt.setLong(i+1, paramValue);
			} else if(paramList.get(i) instanceof String) {
				pstmt.setString(i+1, (String)paramList.get(i));
			}
		}
		return;
	}
	
	/**
	 * ������ݿ�����
	 * @return
	 * @throws Exception
	 */
	private static Connection getConnection() throws Exception {
		InitialContext cxt = new InitialContext();
		if ( cxt == null ) {
			throw new Exception("no context!");
		}

		DataSource ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/chinaseiDB" );
		if ( ds == null ) {
		   throw new Exception("Data source not found!");
		}
		
		return ds.getConnection();
	}
	
	private static PreparedStatement getPreparedStatement(Connection conn, String sql) throws Exception {
		if(conn == null || sql == null || sql.trim().equals("")) {
			return null;
		}
		PreparedStatement pstmt = conn.prepareStatement(sql.trim());
		return pstmt;
	}
	
	/**
	 * ������ݿ��ѯ�����
	 * @param pstmt
	 * @return
	 * @throws Exception
	 */
	private static ResultSet getResultSet(PreparedStatement pstmt) throws Exception {
		if(pstmt == null) {
			return null;
		}
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	
	/**
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	private static List<Map<String, String>> getQueryList(ResultSet rs) throws Exception {
		if(rs == null) {
			return null;
		}
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int columnCount = rsMetaData.getColumnCount();
		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		while (rs.next()) {
			Map<String, String> dataMap = new HashMap<String, String>();
			for (int i = 0; i < columnCount; i++) {
				dataMap.put(rsMetaData.getColumnName(i+1), rs.getString(i+1));
			}
			dataList.add(dataMap);
		}
		return dataList;
	}
	
	/**
	 * �ر����ݿ�����
	 * @param conn
	 */
	private static void closeConn(Connection conn) {
		if(conn == null) {
			return;
		}
		try {
			conn.close();
		} catch (SQLException e) {
			//logger.info(e.getMessage());
		}
	}
	
	/**
	 * �ر�
	 * @param stmt
	 */
	private static void closeStatement(Statement stmt) {
		if(stmt == null) {
			return;
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			//logger.info(e.getMessage());
		}
	}
	
	/**
	 * �ر�
	 * @param rs
	 */
	private static void closeResultSet(ResultSet rs) {
		if(rs == null) {
			return;
		}
		try {
			rs.close();
		} catch (SQLException e) {
			//logger.info(e.getMessage());
		}
	}
}
