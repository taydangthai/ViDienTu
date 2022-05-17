package com.itsol.qlct.Service.Transactions;

import com.itsol.qlct.Dto.PostTransactions;
import com.itsol.qlct.Dto.GetTransactionsDto;

import java.util.List;

public interface TransactionService {

    List<GetTransactionsDto> findTransByUserId(int userId);

    void deleteTransactions(int transId);

    void addTransaction(PostTransactions postTransactions);

    Boolean addTransByRole(PostTransactions postTransactions);

    void updateTransaction(PostTransactions postTransactions);
}
