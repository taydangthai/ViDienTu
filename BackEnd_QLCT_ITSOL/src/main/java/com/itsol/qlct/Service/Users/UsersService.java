package com.itsol.qlct.Service.Users;


import com.itsol.qlct.Dto.UsersDto;
import com.itsol.qlct.Dto.UsersDto2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UsersService extends UserDetailsService {

    List<UsersDto2> showAllExceptPass();

    String addUser(UsersDto usersDto);

    String updateUser(UsersDto usersDto);

    String deleteId(int userId);

    UserDetails loadUserByUsername(String username);

    UsersDto findUserId(int userId);

    UsersDto findByUserNamePass(String userName, String passWord);

    //userName va passWord lay ra Id
    int getUserIdByUserNamePassWord(String userName, String passWord);

}
