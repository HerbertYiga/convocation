package com.convocation.bean;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;




public class StudentsForm {
	
	
	//password
	@NotEmpty(message="please insert password")
	 private String password1;
	
	@NotEmpty(message="No password to confirm")
	 private String password2;
	 
	
	
	
	
	//email attributes
    private String recepient;
	
	private String subject;
	private String message;
	
	
	//describing the details to be submitted
	 private int id;
	 @NotEmpty(message="Please insert user name")
	 private String username;
	 @NotEmpty(message="Please insert user password")
	 private String password;
	 @NotEmpty(message="please insert regNo")
	 private String regNo;
	 private int [] checkid;
	 @NotEmpty(message="Please insert full Name")
	 private  String fullName;
	 @NotEmpty(message="Please insert Email")
	 private String email;

     private  int phoneNumber;
	 @NotEmpty(message="Please insert course studied")
     private String courseStudied;
	  
	 private  String imageLink;

	 private List<MultipartFile>images;
     
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id =id;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName=fullName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber=phoneNumber;
	}
	public String getCourseStudied() {
		return courseStudied;
	}
	public void setCourseStudied(String courseStudied) {
		this.courseStudied = courseStudied;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}

	public int [] getCheckid() {
		return checkid;
	}

	public void setCheckid(int [] checkid) {
		this.checkid = checkid;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getRecepient() {
		return recepient;
	}

	public void setRecepient(String recepient) {
		this.recepient = recepient;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}


     
}
