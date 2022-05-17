package com.itsol.qlct.Controller;



import com.itsol.qlct.Dto.UserWalletDisplayDto;
import com.itsol.qlct.Dto.WalletDto;
import com.itsol.qlct.Service.Wallet.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping(path = "/wallet/showAll")
    public List<WalletDto> showAll()
    {
        return walletService.showAll();
    }


    @GetMapping(path = "/wallet/findName/{walletName}")
    public List<WalletDto> findName(@PathVariable String walletName)
    {
       return walletService.showName(walletName);
    }

    //ok, date time dd-mm-yyyy
    @PostMapping(path = "/wallet/add")
    public void addWallet(@RequestBody WalletDto walletDto)
    {
      walletService.addWallet(walletDto);
    }

    @DeleteMapping(path = "/wallet/deleteId/{walletId}")
    public String deleteId(@PathVariable("walletId") int walletId)
    {
        walletService.deleteId(walletId);
        return "ok";
    }

    //ok, date time dd-mm-yyyy
    @PutMapping(path = "/wallet/update")
    public void updateId(@RequestBody WalletDto walletDto)
    {
        walletService.updateWallet(walletDto);
    }
}
