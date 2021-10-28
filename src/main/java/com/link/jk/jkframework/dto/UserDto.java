package com.link.jk.jkframework.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class UserDto extends BaseDto {

	private int companyNo;
	private String userId;
	private String userPw;
	private int EmailAgree;
	private int userEmailApproval;
	private int userPrivacyApproval;
	private String userRole;
	private Timestamp userLastConnect;
	private int userDel;

}
