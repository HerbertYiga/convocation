 package com.convocation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.convocation.bean.StudentsForm;
import com.convocation.bean.User;

public class UserDao {

	
	//constants for generating a random number
		public static final String DATA="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		public static Random random=new Random();
	
	
	// jdbc template  declaration
	
	
	JdbcTemplate template;
	//setter method for the jdbc template
	
	
	
	
	
	
	public void setTemplate(JdbcTemplate template){
		this.template=template;
	}
	
	
	//enabling the users
	public int enableUser(int userId){
			
	String sql=	"update users set enable=1 WHERE userId=" + userId +"";
	
	return template.update(sql);
		
	}
    //disabling the users
	public int disableUser(int userId){
		
	String sql=	"update users set enable=0 WHERE userId=" + userId +"";
	
	return template.update(sql);
		
	}
	
	
	
	
	
	
	
	//random method for generating the password
	public  String randomString(int len){
		StringBuilder built=new StringBuilder(len);
		for(int i=0;i<len;i++){
			
	   built.append(DATA.charAt(random.nextInt(DATA.length())));
			
			
			
		}
		//returning a string 
		return built.toString();
		
		
		
	}
	
	
	
	
	
	//inserting the user details to the users and user_roles  database at once
	

	public void  saveFormerStudentDetails(final User userdetails){
		 //Getting the last generated id using  Genrated Key Holder
		     GeneratedKeyHolder holder = new GeneratedKeyHolder();
		     
		     template.update(new PreparedStatementCreator() {
		    	    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		    	        PreparedStatement statement = con.prepareStatement("insert into users (username,password,enable,phoneNumber) values(?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
		    	        statement.setString(1, userdetails.getUsername());
		    	        statement.setString(2, userdetails.getPassword());
		    	        statement.setString(3, userdetails.getEnable());
		    	        statement.setInt(4,userdetails.getPhoneNumber());
		    	        
		    	        return statement;
		    	    }
		    	}, holder);
		     
		  
			  //storing the last generated id to int
			  final long generateuserid=holder.getKey().longValue();
			  userdetails.setUserId((int) generateuserid);
			  String sql2="insert into users_roles (userId,authority) values( '"+ userdetails.getUserId() +"', '"+ userdetails.getAuthority() +"')";
			   
		
		       template.update(sql2);
		
		
		
		
	}
	
	
	
	//viewing the user details in the users and users_roles table using inner join
public List<User> getUserDetails(){
		
		return template.query("select users.userId,users.username,users.password,users.phoneNumber,users_roles.authority from users INNER JOIN users_roles ON users.userId=users_roles.userId",new RowMapper<User>(){

			public User mapRow(ResultSet rs, int row)
					throws SQLException {
				
				
				
				User userdetails=new User();
				userdetails.setUserId(rs.getInt("userId"));
				
				userdetails.setUsername(rs.getString("username"));
			
				userdetails.setPassword(rs.getString("password"));

				userdetails.setAuthority(rs.getString("authority"));
			
				userdetails.setPhoneNumber(rs.getInt("phoneNumber"));
				
	
				return userdetails;
			}
			
		});
		
	}
	
	
	
	//dedleting and editing the users within the users and roles data bases


    //delete from the users and users_roles database
    public int delete(int id){
	
	String sql="delete users,users_roles from users INNER JOIN users_roles ON users.userId=users_roles.userId where users.userId='" + id +"'";

	return template.update(sql);
   }

    
    //editing and deleting the user details 
    
    //method for getting the user details by id from the users and users_roles database

	
	public User getUserById(int id){
		
		
	String  sql="select * from users where userId=?";
	return template.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<User>(User.class));
	}
	
	



 		//Method for updating the details 
 		public int update(User userdetails){
 			
 				String sql=	"update users INNER JOIN users_roles on users.userId=users_roles.userId set users.username='" + userdetails.getUsername() +"',users_roles.authority='" + userdetails.getAuthority() +"',users.phoneNumber='" + userdetails.getPhoneNumber() +"' WHERE users.userId=" + userdetails.getUserId() +" ";
 		
 		return template.update(sql);
 			
 		}
 	
    

      //update user password
 		
 		public int updatePassword(User userdetails){
 			
 			String sql="update users set password='"+ userdetails.getPassword()+"' where userId="+ userdetails.getUserId()+" "; 
 			
 			return template.update(sql);
 			
 			
 			
 			
 			
 		}
    
    




	
	
	
	
}
