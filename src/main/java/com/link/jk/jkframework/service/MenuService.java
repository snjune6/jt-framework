package com.link.jk.jkframework.service;

import com.link.jk.jkframework.dto.MenuDto;
import com.link.jk.jkframework.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class MenuService {

    @Resource
    private MenuMapper menuMapper;

    public List<MenuDto> selectFullMenuList() {
        return menuMapper.selectFullMenuList();
    }

	public MenuDto selectMenuType(String servletPath) {
        return menuMapper.selectMenuType(servletPath);
	}

    public MenuDto selectMenuReturn(String menuId) {
        return menuMapper.selectMenuReturn(menuId);
    }
}
