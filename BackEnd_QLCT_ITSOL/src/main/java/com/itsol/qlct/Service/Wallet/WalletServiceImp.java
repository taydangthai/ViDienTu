package com.itsol.qlct.Service.Wallet;



import com.itsol.qlct.Dao.Category.CategoryDao;
import com.itsol.qlct.Dao.Transactions.TransactionsDao;
import com.itsol.qlct.Dao.UserWallet.UserWallerDao;
import com.itsol.qlct.Dao.Users.UsersDao;
import com.itsol.qlct.Dao.Wallet.WalletDao;
import com.itsol.qlct.Dto.WalletDto;
import com.itsol.qlct.Entity.UserWallet;
import com.itsol.qlct.Entity.Users;
import com.itsol.qlct.Entity.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class WalletServiceImp implements WalletService {

    @Autowired
    private WalletDao walletDao;
    @Autowired
    private UserWallerDao userWallerDao;
    @Autowired
    private UsersDao usersDao;
    @Autowired
    public TransactionsDao transactionsDao;
    @Autowired
    public CategoryDao categoryDao;

    @Transactional
    @Override
    public List<WalletDto> showAll() {
        //call dao
        List<Wallet> wallets = walletDao.listWallet();
        //conect DTO vs DAO
        List<WalletDto> walletDtos = new ArrayList<WalletDto>();
        //modelmapper
        /*ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        for(Wallet w: wallets)
        {
            walletDtos.add(modelMapper.map(w, WalletDto.class));
        }*/
        //set tung phan tu
        for (Wallet w: wallets)
        {
            WalletDto walletDto = new WalletDto();
                walletDto.setWalletId(w.getWalletId());
                walletDto.setWalletName(w.getWalletName());
                walletDto.setBalance(w.getBalance());
                walletDto.setCurrency(w.getCurrency());
                walletDto.setCreateDate(w.getCreateDate());
            walletDtos.add(walletDto);
        }
        return walletDtos;
    }

    @Transactional
    @Override
    public List<WalletDto> showName(String walletName) {

        List<Wallet> wallets = walletDao.searchByName(walletName);

        List<WalletDto> walletDtos = new ArrayList<WalletDto>();
        for (Wallet w: wallets)
        {
            WalletDto walletDto = new WalletDto();
                walletDto.setWalletId(w.getWalletId());
                walletDto.setWalletName(w.getWalletName());
                walletDto.setBalance(w.getBalance());
                walletDto.setCurrency(w.getCurrency());
                walletDto.setCreateDate(w.getCreateDate());
            walletDtos.add(walletDto);
        }
        return walletDtos;
    }


    @Transactional
    @Override
    public String addWallet(WalletDto walletDto) {
        Wallet wallet1 = new Wallet();
        if(walletDto != null && walletDto.toString() != "" ) {
            Wallet walletCheck = walletDao.checkWalletName(walletDto.getWalletName());
            if(walletCheck.getWalletName() == null){

                wallet1.setWalletName(walletDto.getWalletName());
                wallet1.setBalance(walletDto.getBalance());
                wallet1.setCurrency(walletDto.getCurrency());
                wallet1.setCreateDate(walletDto.getCreateDate());
                walletDao.addWallet(wallet1);

                UserWallet userWallet = new UserWallet();
                Users users = new Users();
                users.setUserId(walletDto.getUserId());

                userWallet.setRole(0);
                userWallet.setUsers(users);
                userWallet.setWallet(walletDao.checkWalletName(wallet1.getWalletName()));

                userWallerDao.addUW(userWallet);
                return "ok";
            }else {
                return walletCheck.getWalletName();
            }
        }
        return "false";
    }

    @Transactional
    @Override
    public String deleteId(int walletId) {
        transactionsDao.deleteTransWalletId(walletId);
        userWallerDao.deleteUWWalletId(walletId);
        walletDao.deleteWallet(walletId);
        return "ok";
    }

    @Transactional
    @Override
    public String updateWallet(WalletDto walletDto) {
        /*ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        Wallet wallet = modelMapper.map(walletDto, Wallet.class);*/

        Wallet wallet = new Wallet();
        wallet.setWalletName(walletDto.getWalletName());
        wallet.setBalance(walletDto.getBalance());

        return "ok";
    }

}
