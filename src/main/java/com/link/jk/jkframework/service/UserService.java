package com.link.jk.jkframework.service;

import com.link.jk.jkframework.comm.Util;
import com.link.jk.jkframework.config.Role;
import com.link.jk.jkframework.dto.UserDetailDto;
import com.link.jk.jkframework.dto.UserDto;
import com.link.jk.jkframework.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private UserMapper userMapper;

    public Long joinUser(UserDetailDto userDetailDto) {

        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userDetailDto.setUserPw(passwordEncoder.encode(userDetailDto.getUserPw()));
        userDetailDto.setUserRole(Role.USER.getValue());

        return userMapper.joinUser(userDetailDto);
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        UserDto userDto = userMapper.selectUserId(userId);
        List<GrantedAuthority> authorities = new ArrayList<>();

        if(userDto != null) {

            authorities.add(new SimpleGrantedAuthority(userDto.getUserRole()));
        }


        return new User(userDto.getUserId(), userDto.getUserPw(), authorities);
    }
}
