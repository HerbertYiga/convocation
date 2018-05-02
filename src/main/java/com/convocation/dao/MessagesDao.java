package com.convocation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.convocation.bean.MessagesBean;
import com.convocation.bean.StudentsForm;
import com.convocation.bean.User;

public class MessagesDao {
	

	// jdbc template  declaration
	
	
	JdbcTemplate template;
	//setter method for the jdbc template
	
	
	public void setTemplate(JdbcTemplate template){
		this.template=template;
	}
	
	
	
	//inserting the user details to the users and user_roles  database at once
	

	public void  saveMessageAndHeading(final MessagesBean messagedetails){
		 //Getting the last generated id using  Genrated Key Holder
		     GeneratedKeyHolder holder = new GeneratedKeyHolder();
		     
		     template.update(new PreparedStatementCreator() {
		    	    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		    	        PreparedStatement statement = con.prepareStatement("insert into messagesheading (theHeading) values(?) ", Statement.RETURN_GENERATED_KEYS);
		    	        statement.setString(1, messagedetails.getTheHeading());

		    	        
		    	        return statement;
		    	    }
		    	}, holder);
		     
		  
			  //storing the last generated id to int
			  final long generateuserid=holder.getKey().longValue();
			  messagedetails.setHeadingId((int) generateuserid);
			  String sql2="insert into messagesbody (headingId,messageBody) values( '"+ messagedetails.getHeadingId() +"', '"+ messagedetails.getMessageBody() +"')";
			   
		
		       template.update(sql2);
		
		
		
		
	}
	
	
	
	
	
	
	//getiting the Message to headings the list
	 
public List<MessagesBean> getMessageHeadingDetails(){
		
		return template.query("select messagesheading.headingId,messagesheading.theHeading from messagesheading ORDER by headingId DESC",new RowMapper<MessagesBean>(){

			public MessagesBean mapRow(ResultSet rs, int row)
					throws SQLException {
				
				
				
				MessagesBean messagedetails=new MessagesBean();
				messagedetails.setHeadingId(rs.getInt("headingId"));
				
				messagedetails.setTheHeading(rs.getString("theHeading"));
			
				
				
	
				return messagedetails;
			}
			
		});
		
	}


 //getting the messages and and messages heading from the databases

public MessagesBean getMessagesAndMessageHeadings(int headingId){
	
	
	String sql=" select messagesheading.headingId,messagesheading.theHeading,messagesbody.messageBody,messagesbody.messageBodyId from messagesheading INNER JOIN messagesbody ON messagesheading.headingId=messagesbody.headingId where messagesheading.headingId=?";

	return template.queryForObject(sql,new Object[]{headingId},new BeanPropertyRowMapper<MessagesBean>(MessagesBean.class));
	}



public int saveNotices(MessagesBean messagesbean) {
	
	
	String sql="insert into notices(noticeHeading,noticeBody) values('"+ messagesbean.getNoticeHeading() +"','"+ messagesbean.getNoticeBody() +"')";

	return template.update(sql);
	
	
}
	
//viewing the stored notice

public List<MessagesBean> getNotices(){
	
	return template.query("select * from notices ORDER by noticeId DESC",new RowMapper<MessagesBean>(){

		public MessagesBean mapRow(ResultSet rs, int row)
				throws SQLException {
			
			
			
			MessagesBean messagedetails=new MessagesBean();
			
			messagedetails.setNoticeHeading(rs.getString("noticeHeading"));
			
			messagedetails.setNoticeBody(rs.getString("noticeBody"));
		
			
			

			return messagedetails;
		}
		
	});
	
}






	
	/*
	
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
    
    




	
	
	*/
	
}
