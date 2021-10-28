package com.link.jk.jkframework.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CategoryDto {

    private int no;
    private int parentNo;
    private String categoryNm;
    private String categoryGb;
    private int categoryMain;
    private int categorySort;
    private int categoryStep;
    private Timestamp categoryUpdate;
    private Timestamp categoryCreate;
    private Timestamp categoryDelete;

}
