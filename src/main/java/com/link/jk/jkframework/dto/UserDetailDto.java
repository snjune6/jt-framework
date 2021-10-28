package com.link.jk.jkframework.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDetailDto extends UserDto {

	private int userNo;
	private String userEmail;
	private String userName;
	private String userPhone;
	private String userAddr1;
	private String userAddr2;
	private String userAddr3;

}
