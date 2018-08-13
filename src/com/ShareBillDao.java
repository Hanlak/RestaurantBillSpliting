package com;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class ShareBillDao {
		JdbcTemplate template;
		public void setTemplate(JdbcTemplate template) {  
		    this.template = template;  
		}  
	
		public String getBill(String tableno)
		{
			List<Map<String, Object>> li=template.queryForList("select * from mastertable where tablename ='"+tableno+"'");
			String billamount="";
			 if(!li.isEmpty()){
				   
				   for(Map<String, Object> row : li){
				          
				          billamount = (String)row.get("billamount");
				     
				          break;
				        }
			 }
			return billamount;
			
		}
		public List<Map<String,Object>> selectAllTables(){
			List<Map<String, Object>> data=template.queryForList("select * from mastertable");
			
			return data;
		}
}
