package com.itsol.qlct.Controller;


import com.itsol.qlct.Dto.GetTransactionsDto;
import com.itsol.qlct.Dto.PostTransactions;
import com.itsol.qlct.Service.Transactions.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class TransactionsController {

    @Autowired
    private TransactionService transactionService;


    @GetMapping(path = "/transactions/showTransByUserId/{userId}")
    public List<GetTransactionsDto> listTrans(@PathVariable("userId") int userId)
    {
        return transactionService.findTransByUserId(userId);
    }

    @DeleteMapping(path = "/transactions/deleteId/{transId}")
    public void deleteId(@PathVariable("transId") int transId)
    {
        transactionService.deleteTransactions(transId);
    }

    @PostMapping(path = "/transactions/add")
    public void addTransaction(@RequestBody@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) PostTransactions postTransactions)
    {
        transactionService.addTransaction(postTransactions);
    }

    @PostMapping(path = "/transactions/addByRole")
    public void addTransByRole(@RequestBody@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) PostTransactions postTransactions)
    {
        transactionService.addTransByRole(postTransactions);
    }

}
