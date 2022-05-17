package com.itsol.qlct.Service.Wallet;


import com.itsol.qlct.Dto.WalletDto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WalletService {

    List<WalletDto> showAll();

    List<WalletDto> showName(String walletName);

    String addWallet(WalletDto walletDto);

    String deleteId(int walletId);

    String updateWallet(WalletDto walletDto);
}
