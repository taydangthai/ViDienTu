package com.itsol.qlct.Service.Users;




import com.itsol.qlct.Dao.Users.UsersDao;

import com.itsol.qlct.Dto.UsersDto;
import com.itsol.qlct.Dto.UsersDto2;
import com.itsol.qlct.Entity.Users;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImp implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public List<UsersDto2> showAllExceptPass() {
        List<Users> users = usersDao.showAllExceptPass();
        List<UsersDto2> usersDto2s = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        for(Users u: users){
            usersDto2s.add(modelMapper.map(u, UsersDto2.class));
        }
        return usersDto2s;
    }

    @Transactional
    @Override
    public String addUser(UsersDto usersDto) {
        Users users = new Users();

        users.setName(usersDto.getName());
        users.setUserName(usersDto.getUserName());
        users.setPassWord(passwordEncoder.encode(usersDto.getPassWord()));
        users.setPhoneNumber(usersDto.getPhoneNumber());
        users.setGender(usersDto.getGender());
        users.setPathAva(usersDto.getPathAva());

        usersDao.saveUser(users);
        return "ok";
    }

    @Transactional
    @Override
    public String updateUser(UsersDto usersDto) {
        Users users = new Users();
        users.setUserName(users.getUserName());
        users.setName(users.getName());
        users.setGender(users.getGender());
        users.setPassWord(passwordEncoder.encode(users.getPassWord()));
        users.setPhoneNumber(users.getPhoneNumber());
        users.setPathAva(users.getPathAva());
        usersDao.updateUser(users);
        return "ok chu?";
    }

    @Transactional
    @Override
    public String deleteId(int userId) {
        usersDao.deleteUser(userId);
        return "ok";
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Users users = usersDao.findByUserName(username);
        if (users == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(users.getUserName(), users.getPassWord(), new ArrayList<>());
    }

    @Transactional
    @Override
    public UsersDto findUserId(int userId) {
        Users users = usersDao.findUserId(userId);
        UsersDto usersDto = new UsersDto();

        usersDto.setUserId(users.getUserId());
        usersDto.setName(users.getName());
        usersDto.setUserName(users.getUserName());
        usersDto.setGender(users.getGender());
        usersDto.setPassWord(users.getPassWord());
        usersDto.setPathAva(users.getPathAva());
        usersDto.setPhoneNumber(users.getPhoneNumber());

        return usersDto;
    }

    @Transactional
    @Override
    public UsersDto findByUserNamePass(String userName, String passWord) {
        Users users = usersDao.findByUserNamePass(userName, passWord);
        UsersDto usersDto = new UsersDto();

        usersDto.setUserId(users.getUserId());
        usersDto.setUserName(users.getUserName());
        usersDto.setPassWord(users.getPassWord());
        usersDto.setPhoneNumber(users.getPhoneNumber());
        usersDto.setGender(users.getGender());
        usersDto.setPathAva(users.getPathAva());
        return usersDto;
    }

    @Override
    public int getUserIdByUserNamePassWord(String userName, String passWord) {
        Users users = usersDao.findByUserName(userName);
        return users.getUserId();
    }


}
