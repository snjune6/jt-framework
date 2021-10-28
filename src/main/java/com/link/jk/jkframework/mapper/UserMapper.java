package com.link.jk.jkframework.mapper;

import com.link.jk.jkframework.dto.UserDetailDto;
import com.link.jk.jkframework.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    Long joinUser(UserDetailDto userDetailDto);

    UserDto selectUserId(String userId);

}
