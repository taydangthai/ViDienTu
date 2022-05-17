package com.itsol.qlct.Controller;

import com.itsol.qlct.Dto.UserWalletDisplayDto;
import com.itsol.qlct.Service.UserWallet.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class UserWalletController {

    @Autowired
    private UserWalletService userWalletService;

    @GetMapping(path = "/UserWallet/find/{userId}")
    public List<UserWalletDisplayDto> findByUserId(@PathVariable int userId)
    {
        return userWalletService.getUserId(userId);
    }

    @GetMapping(path = "/UserWallet/checkRole")
    public String checkRole(@RequestParam("walletId") int walletId, @RequestParam("userId") int userId )
    {
        return userWalletService.checkRole(walletId, userId);
    }
}
