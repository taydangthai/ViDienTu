package com.itsol.qlct.Service.UserWallet;

import com.itsol.qlct.Dto.UserWalletDisplayDto;
import com.itsol.qlct.Dto.UserWalletDto;


import java.util.List;

public interface UserWalletService {
    String addUserWallet(UserWalletDto userWalletDto);

    List<UserWalletDisplayDto> getUserId(int userId);

    String checkRole(int walletId, int userId);
}
