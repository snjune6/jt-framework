package com.link.jk.jkframework.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BaseDto {

	private Timestamp userUpdate;
	private Timestamp userCreate;
	private Timestamp userDelete;

}
