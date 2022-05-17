package com.itsol.qlct.Dao.Transactions;

import com.itsol.qlct.Entity.Transactions;

import java.util.List;

public interface TransactionsDao {

    List<Transactions> findDateTime(String dateTimeStart, String dateTimeEnd);

    List<Transactions> listOrderByTimeName();

    List<Transactions> getListByUserId(int userId);

    void deleteTransactions(int transId);

    void deleteTransWalletId(int walletId);

    void addTransaction(Transactions transactions);

    void updateTransaction(Transactions transactions);

    Boolean addOneTrans(Transactions transactions);

}
