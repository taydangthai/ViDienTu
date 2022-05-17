package com.itsol.qlct.Dao.UserWallet;
import com.itsol.qlct.Entity.UserWallet;
import java.util.List;

public interface UserWallerDao {

    List<UserWallet> showAll(UserWallet userWaller);

    List<UserWallet> findById(int userWalletId);

    String addUW(UserWallet userWaller);

    String deleteUW(int userWalletId);

    String deleteUWWalletId(int walletId);

    String updateUW(UserWallet userWaller);

    List<UserWallet> hienThiTheoUserId(int userId);

    UserWallet checkRole(int walletId, int userId);

}
