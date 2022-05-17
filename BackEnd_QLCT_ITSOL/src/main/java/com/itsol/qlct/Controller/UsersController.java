package com.itsol.qlct.Controller;

import com.itsol.qlct.Dto.UsersDto;
import com.itsol.qlct.Dto.UsersDto2;
import com.itsol.qlct.Service.Users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping
public class UsersController {


    @Autowired
    private UsersService usersService;

    @GetMapping(path = "/users/showAllExceptPass")
    public List<UsersDto2> showAllExceptPass()
    {
        return usersService.showAllExceptPass();
    }
    //ok
    @PostMapping(path = "/users/add")
    public String addUser(@RequestBody UsersDto usersDto)
    {
        return usersService.addUser(usersDto);
    }

    @GetMapping(path = "/users/findByUserNamePass")
    public UsersDto getUserNamePass(@RequestParam(name ="username") String userName, @RequestParam(name = "password") String passWord )
    {
        return usersService.findByUserNamePass(userName, passWord);
    }

    @GetMapping(path = "/users/findById/{userId}")
    public UsersDto findById(@PathVariable("userId") int userId)
    {
        return usersService.findUserId(userId);
    }

    @DeleteMapping(path = "/users/deleteId/{userId}")
    public String deleteUsers(@PathVariable int userId)
    {
        usersService.deleteId(userId);
        return "ok";
    }

    // tk lay ra id
    @GetMapping(path = "/user/id")
    public int userId(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord)
    {
        return usersService.getUserIdByUserNamePassWord(userName, passWord);
    }
}
