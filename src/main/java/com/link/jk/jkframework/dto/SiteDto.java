package com.link.jk.jkframework.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class SiteDto {

	@NotEmpty(message = "사이트명은 필수 입력입니다.")
	private String siteName;

	@NotEmpty(message = "사이트상태값은 필수 선택입니다.")
	private String siteState;

	@NotEmpty(message = "사이트도메인은 필수 입력입니다.")
	@URL
	private String siteDomain;

	private String siteCdn;

}
