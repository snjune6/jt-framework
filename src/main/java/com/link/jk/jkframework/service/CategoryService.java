package com.link.jk.jkframework.service;

import com.link.jk.jkframework.dto.CategoryDto;
import com.link.jk.jkframework.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    public List<CategoryDto> selectFullCategoryList() {
        return categoryMapper.selectFullCategoryList();
    }

}
