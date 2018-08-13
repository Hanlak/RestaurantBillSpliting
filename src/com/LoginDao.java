package com;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class LoginDao {
JdbcTemplate template;
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public Login getUserById(String username){  
    String sql="select * from users where username=?";  
    return template.queryForObject(sql, new Object[]
    		{username},new BeanPropertyRowMapper<Login>(Login.class));  
} 
}
