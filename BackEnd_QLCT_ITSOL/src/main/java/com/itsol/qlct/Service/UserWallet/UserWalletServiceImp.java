package com.itsol.qlct.Service.UserWallet;

import com.itsol.qlct.Dao.UserWallet.UserWallerDao;
import com.itsol.qlct.Dao.Users.UsersDao;
import com.itsol.qlct.Dao.Wallet.WalletDao;
import com.itsol.qlct.Dto.UserWalletDisplayDto;
import com.itsol.qlct.Dto.UserWalletDto;
import com.itsol.qlct.Entity.UserWallet;
import com.itsol.qlct.Entity.Users;
import com.itsol.qlct.Entity.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserWalletServiceImp implements UserWalletService {

    @Autowired
    private UserWallerDao userWallerDao;
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private WalletDao walletDao;


    @Transactional
    @Override
    public String addUserWallet(UserWalletDto userWalletDto) {
        UserWallet userWallet = new UserWallet();

        Users users = new Users();
        users.setUserId(userWalletDto.getUserId());

        Wallet wallet = new Wallet();
        wallet.setWalletId(userWalletDto.getWalletId());

        userWallet.setUserWalletId(userWalletDto.getUserWalletId());
        userWallet.setRole(userWalletDto.getRole());

        userWallet.setUsers(users);
        userWallet.setWallet(wallet);

        return userWallerDao.addUW(userWallet);
    }

    @Transactional
    @Override
    public List<UserWalletDisplayDto> getUserId(int userId) {
        // userId -> table: list userwallet
        List<UserWallet> userWallets = userWallerDao.hienThiTheoUserId(userId);
        //userWalletId,userId,walletId,role
        List<UserWalletDisplayDto> userWalletDisplayDtos = new ArrayList<>();
        for(UserWallet uw: userWallets)
        {
            UserWalletDisplayDto userWalletShow = new UserWalletDisplayDto();
           // userId -> table: users ??? usersDao.(4tt)
            Users users = usersDao.findUserId((int) uw.getUsers().getUserId());
           // walletId -> table: wallet   ??? wallet()
            Wallet wallet = walletDao.findWalletId((int) uw.getWallet().getWalletId());

            userWalletShow.setUserId(users.getUserId());
            userWalletShow.setName(users.getName());

            userWalletShow.setWalletId(wallet.getWalletId());
            userWalletShow.setWalletName(wallet.getWalletName());
            userWalletShow.setBalance(wallet.getBalance());
            userWalletShow.setCurrency(wallet.getCurrency());
            userWalletShow.setCreateDate(wallet.getCreateDate());

            userWalletShow.setUserWalletId(uw.getUserWalletId());
            userWalletShow.setRole(uw.getRole());

            userWalletDisplayDtos.add(userWalletShow);
        }

        return userWalletDisplayDtos;
    }

    @Transactional
    @Override
    public String checkRole(int walletId, int userId) {
        UserWallet userWallet = userWallerDao.checkRole(walletId, userId);
        /*UserWalletDto userWalletDto = new UserWalletDto();
        userWalletDto.setUserWalletId(userWallet.getUserWalletId());
        userWalletDto.setRole(userWallet.getRole());
        userWalletDto.setUserId(userWallet.getUsers().getUserId());
        userWalletDto.setWalletId(userWallet.getWallet().getWalletId());*/

        if (userWallet.getRole() == 0 ) {
            return "admin";
        }
            return "user";
    }
}
