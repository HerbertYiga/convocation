package com.convocation.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class MessagesBean {
	
	
	
	
	private int headingId;
	
	@NotEmpty(message="please insert the message Heading")
	private String  theHeading;
	
	
	private int messageBodyId;
	
	@NotEmpty(message="please insert body text")
	private String messageBody;
	
	private int noticeId;
	
	@NotEmpty(message="please insert heading text")
	private String noticeHeading;
	@NotEmpty(message="please insert body text")
	private String  noticeBody;
	
	

   //headingid
	public int getHeadingId() {
		return headingId;
	}


	public void setHeadingId(int headingId) {
		this.headingId = headingId;
	}
 
	 //heading

	public String getTheHeading() {
		return theHeading;
	}


	public void setTheHeading(String theHeading) {
		this.theHeading = theHeading;
	}
    //message bodyid

	public int getMessageBodyId() {
		return messageBodyId;
	}

    //message body
	public void setMessageBodyId(int messageBodyId) {
		this.messageBodyId = messageBodyId;
	}


	public String getMessageBody() {
		return messageBody;
	}


	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

 //notice board
	public int getNoticeId() {
		return noticeId;
	}


	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

 //notice headining
	public String getNoticeHeading() {
		return noticeHeading;
	}


	public void setNoticeHeading(String noticeHeading) {
		this.noticeHeading = noticeHeading;
	}
 //notice body

	public String getNoticeBody() {
		return noticeBody;
	}


	public void setNoticeBody(String noticeBody) {
		this.noticeBody = noticeBody;
	}
	
	

}
