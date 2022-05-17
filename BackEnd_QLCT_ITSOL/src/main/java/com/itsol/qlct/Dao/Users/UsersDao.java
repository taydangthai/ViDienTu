package com.itsol.qlct.Dao.Users;


import com.itsol.qlct.Entity.Users;

import java.util.List;

public interface UsersDao {

    List<Users> showAllExceptPass();

    Users findByUserName(String username);

    String saveUser(Users users);

    String updateUser(Users users);

    String deleteUser(int userId);

    Users findUserId(int userId);

    Users findByUserNamePass(String userName, String passWord);

    //them
    String findByIdReturnName(int userId);

}
