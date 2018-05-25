package com.convocation.dao;

import java.sql.ResultSet;



import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;




import com.convocation.bean.EmailBean;
import com.convocation.bean.StudentsForm;







public class StudentsFormDao {
	// jdbc template  declaration
	
	
	JdbcTemplate template;
	//setter method for the jdbc template
	
	
	public void setTemplate(JdbcTemplate template){
		this.template=template;
	}
	
	//persistance of  the former student details
	public int  saveFormerStudentDetails(StudentsForm studentsForm){

		String sql="insert into studentdetails(fullName,email,courseStudied,imageLink,phoneNumber,regNo,username,password1) values('"+ studentsForm.getFullName() +"','"+ studentsForm.getEmail() +"','"+ studentsForm.getCourseStudied() + "','"+ studentsForm.getImageLink()+"','"+ studentsForm.getPhoneNumber()+"','"+ studentsForm.getRegNo()+"','"+ studentsForm.getUsername()+"','"+ studentsForm.getPassword1()+"')";

		return template.update(sql);
		
		
	}
	//selecting the former student details from the database 
	public List<StudentsForm> getStudentDetails(){
		
		return template.query("select * from studentdetails",new RowMapper<StudentsForm>(){

			public StudentsForm mapRow(ResultSet rs, int row)
					throws SQLException {
				
				
				
				StudentsForm studentsForm=new StudentsForm();
				studentsForm.setId(rs.getInt("id"));
				studentsForm.setFullName(rs.getString("fullName"));
			
				studentsForm.setEmail(rs.getString("email"));
				studentsForm.setUsername(rs.getString("username"));
				studentsForm.setPassword1(rs.getString("password1"));
				studentsForm.setCourseStudied(rs.getString("courseStudied"));
			
				studentsForm.setPhoneNumber(rs.getInt("phoneNumber"));
				
				studentsForm.setImageLink(rs.getString("imageLink"));
				studentsForm.setRegNo(rs.getString("regNo"));
				
				return studentsForm;
			}
			
		});
		
	}
	
	
	//method for updating the student
	

	
	//method for deleting from studentdetails table
	public int delete(int id){
		
		String sql="delete from studentdetails where id='" + id +"'";
		
		return template.update(sql);
	}
	
	
	
	
	
	
	//method for getting the former student by id
	
	
	public StudentsForm getStudentById(int id){
		
		
	String  sql="select * from studentdetails where id=?";
	return template.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<StudentsForm>(StudentsForm.class));
	}
	
	
	
	//searching student by regNo
	public StudentsForm getStudentByRegNo(String regNo){
	
		try{
	String  sql="select * from studentdetails where regNo=?";
	return template.queryForObject(sql,new Object[]{regNo},new BeanPropertyRowMapper<StudentsForm>(StudentsForm.class));
		}
		catch(Exception e){
			
			return null;
			
		}
		
		
		
		}
	
	
	
	
	
public List<StudentsForm> getStudentbyIdInAlist(int id){
	
		return template.query("select * from studentdetails where id='" + id +"'",new RowMapper<StudentsForm>(){

	    public StudentsForm mapRow(ResultSet rs, int row)
					throws SQLException {
	    	
				
				StudentsForm studentsForm=new StudentsForm();
				
				studentsForm.setId(rs.getInt("id"));
				
				studentsForm.setFullName(rs.getString("fullName"));
				
				studentsForm.setEmail(rs.getString("email"));
			
		
				return studentsForm;
			}
			
		});
		
	}
	
	
	//Notices 


public int updateNotices(EmailBean messages){
	
	
	String sql="update notices set message1='"+ messages.getMessage1()+ "',message2='"+ messages.getMessage2()+"',message3='" + messages.getMessage3() +"'";
	
	return template.update(sql);
	
}

public StudentsForm  getRegNoFromDataBase(String regNo){
	
	String sql="select regNo from studentdetails where regNo=?";
	try{
	StudentsForm studentsForm=(StudentsForm)template.queryForObject(sql,new Object[]{regNo},new BeanPropertyRowMapper<StudentsForm>(StudentsForm.class));
		
		return studentsForm;}
	catch(Exception e){
		return null;
		
		
	}
	}
	
	
	

}
