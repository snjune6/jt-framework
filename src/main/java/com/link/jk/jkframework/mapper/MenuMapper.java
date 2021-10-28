package com.link.jk.jkframework.mapper;

import com.link.jk.jkframework.dto.MenuDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface MenuMapper {


    List<MenuDto> selectFullMenuList();

	MenuDto selectMenuType(String menuLink);

	MenuDto selectMenuReturn(String menuId);
}
