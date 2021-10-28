package com.link.jk.jkframework.mapper;

import com.link.jk.jkframework.dto.FileDto;
import com.link.jk.jkframework.dto.MenuDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface FileMapper {

    void multiUpload(FileDto fileDto);

}
