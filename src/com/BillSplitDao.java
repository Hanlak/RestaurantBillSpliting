package com;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

//JDBC template to execute Queries
public class BillSplitDao {
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	} 
	
	public int billInsert(BillSplit bs) throws DataAccessException{
	
			String sql = "update mastertable set tablename =?,billamount=? where tablename =?";
		return template.update(sql, new Object[]{bs.getTableno(),bs.getBillamount(),bs.getTableno()});
}
	public int billCheck(String tableno,String amount)throws DataAccessException{
		String sql = "update mastertable set tablename =?,billamount=? where tablename=?";
		return template.update(sql, new Object[]{tableno,amount,tableno});
	}
}
