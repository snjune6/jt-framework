package com.link.jk.jkframework.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuDto {

    private String menuId;
    private String menuNm;
    private String menuLink;
    private String menuAlt;
    private int menuSort;
    private int menuStep;
    private int menuType;
    private String menuReturn;

}

