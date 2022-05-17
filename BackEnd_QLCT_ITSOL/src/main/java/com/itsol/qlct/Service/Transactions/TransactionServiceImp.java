package com.itsol.qlct.Service.Transactions;

import com.itsol.qlct.Dao.Category.CategoryDao;
import com.itsol.qlct.Dao.Transactions.TransactionsDao;
import com.itsol.qlct.Dao.Users.UsersDao;
import com.itsol.qlct.Dao.Wallet.WalletDao;
import com.itsol.qlct.Dto.GetTransactionsDto;
import com.itsol.qlct.Dto.PostTransactions;
import com.itsol.qlct.Entity.Category;
import com.itsol.qlct.Entity.Transactions;
import com.itsol.qlct.Entity.Users;
import com.itsol.qlct.Entity.Wallet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImp implements TransactionService {

    @Autowired
    private TransactionsDao transactionsDao;
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private WalletDao walletDao;
    @Autowired
    private CategoryDao categoryDao;

    /*@Transactional
    @Override
    public List<PostTransactions> findByDateTime(String dateTimeStart, String dateTimeEnd) {
        List<Transactions> transactionsList = transactionsDao.findDateTime(dateTimeStart,dateTimeEnd);
        List<PostTransactions> transactionsDtoList = new ArrayList<>();

        for(Transactions t : transactionsList)
        {
            PostTransactions PostTransactions = new PostTransactions();

            PostTransactions.setTransId(t.getTransId());
            PostTransactions.setAmount(t.getAmount());
            PostTransactions.setDateTime(t.getDateTime());
            PostTransactions.setNote(t.getNote());
            PostTransactions.setTransType(t.getTransType());


            PostTransactions.setCategoryId(t.getCategory().getCategoryId());
            PostTransactions.setWalletId(t.getWallet().getWalletId());
            PostTransactions.setUserId(t.getUsers().getUserId());

            transactionsDtoList.add(PostTransactions);
        }

        return transactionsDtoList;
    }*/


    @Transactional
    public List<GetTransactionsDto> listOrderByTimeName() {
        List<Transactions> transactions = transactionsDao.listOrderByTimeName();
        List<GetTransactionsDto> getTransactionsDtos = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        for(Transactions t : transactions)
        {
            getTransactionsDtos.add(modelMapper.map(t, GetTransactionsDto.class));
        }
        for(Transactions t : transactions)
        {
            GetTransactionsDto GetTransactionsDto = new GetTransactionsDto();

            GetTransactionsDto.setTransId(t.getTransId());
            GetTransactionsDto.setAmount(t.getAmount());
            GetTransactionsDto.setDateTime(t.getDateTime());
            GetTransactionsDto.setNote(t.getNote());
            GetTransactionsDto.setTransType(t.getTransType());
            GetTransactionsDto.setCategoryId(t.getCategory().getCategoryId());
            GetTransactionsDto.setWalletId(t.getWallet().getWalletId());
            GetTransactionsDto.setUserId(t.getUsers().getUserId());

            GetTransactionsDto.setName(usersDao.findByIdReturnName(t.getUsers().getUserId()));
            GetTransactionsDto.setWalletName(walletDao.findByWalletIdReturnWalletName(t.getWallet().getWalletId()));
            GetTransactionsDto.setCategoryName(categoryDao.findByCategoryIdReturnCategoryName(t.getCategory().getCategoryId()));

            getTransactionsDtos.add(GetTransactionsDto);
        }

        return getTransactionsDtos;
    }

    @Transactional
    @Override
    public List<GetTransactionsDto> findTransByUserId(int userId) {
        List<Transactions> transactions = transactionsDao.getListByUserId(userId);
        List<GetTransactionsDto> GetTransactionsDtos = new ArrayList<>();
        for(Transactions t : transactions)
        {
            GetTransactionsDto getTransactionsDto = new GetTransactionsDto();

            Users users = usersDao.findUserId((int) t.getUsers().getUserId());
            Category category = categoryDao.findIdCate((int) t.getCategory().getCategoryId());
            Wallet wallet = walletDao.findWalletId((int) t.getWallet().getWalletId());

            getTransactionsDto.setTransId(t.getTransId());
            getTransactionsDto.setAmount(t.getAmount());
            getTransactionsDto.setDateTime(t.getDateTime());
            getTransactionsDto.setNote(t.getNote());
            getTransactionsDto.setTransType(t.getTransType());

            getTransactionsDto.setUserId(users.getUserId());
            getTransactionsDto.setName(users.getName());

            getTransactionsDto.setWalletId(wallet.getWalletId());
            getTransactionsDto.setWalletName(wallet.getWalletName());

            getTransactionsDto.setCategoryId(category.getCategoryId());
            getTransactionsDto.setCategoryName(category.getCategoryName());

            GetTransactionsDtos.add(getTransactionsDto);
        }

        return GetTransactionsDtos;
    }

    @Transactional
    @Override
    public void deleteTransactions(int transId) {
        transactionsDao.deleteTransactions(transId);
    }

    @Transactional
    @Override
    public void addTransaction(PostTransactions postTransactions) {
        Transactions transactions = new Transactions();

        Users users = new Users();
        users.setUserId(postTransactions.getUserId());

        Category category = new Category();
        category.setCategoryId(postTransactions.getCategoryId());

        Wallet wallet = new Wallet();
        wallet.setWalletId(postTransactions.getWalletId());

        transactions.setTransId(postTransactions.getTransId());
        transactions.setAmount(postTransactions.getAmount());
        transactions.setTransType(postTransactions.getTransType());
        transactions.setNote(postTransactions.getNote());
        transactions.setDateTime(postTransactions.getDateTime());
        transactions.setUsers(users);
        transactions.setWallet(wallet);
        transactions.setCategory(category);


        transactionsDao.addTransaction(transactions);
    }

    @Transactional
    @Override
    public Boolean addTransByRole(PostTransactions postTransactions) {
        Transactions transactions = new Transactions();

        Users users = new Users();
        users.setUserId(postTransactions.getUserId());

        Category category = new Category();
        category.setCategoryId(postTransactions.getCategoryId());

        Wallet wallet = new Wallet();
        wallet.setWalletId(postTransactions.getWalletId());

        transactions.setTransId(postTransactions.getTransId());
        transactions.setAmount(postTransactions.getAmount());
        transactions.setTransType(postTransactions.getTransType());
        transactions.setNote(postTransactions.getNote());
        transactions.setDateTime(postTransactions.getDateTime());
        transactions.setUsers(users);
        transactions.setWallet(wallet);
        transactions.setCategory(category);

        return transactionsDao.addOneTrans(transactions);
    }

    @Transactional
    @Override
    public void updateTransaction(PostTransactions postTransactions) {
        Transactions transactions = new Transactions();
//        transactions.setUsers(usersDao.findIdUser(transactionsDto.getUserId()));
//        transactions.setCategory(categoryDao.findIdCate(transactionsDto.getCategoryId()));
//        transactions.setWallet(walletDao.findIdWal(transactionsDto.getWalletId()));
        Users users = new Users();
        users.setUserId(postTransactions.getUserId());

        Category category = new Category();
        category.setCategoryId(postTransactions.getCategoryId());

        Wallet wallet = new Wallet();
        wallet.setWalletId(postTransactions.getWalletId());


        transactions.setUsers(users);
        transactions.setCategory(category);
        transactions.setWallet(wallet);

        transactions.setTransId(postTransactions.getTransId());
        transactions.setAmount(postTransactions.getAmount());
        transactions.setTransType(postTransactions.getTransType());
        transactions.setNote(postTransactions.getNote());
        transactions.setDateTime(postTransactions.getDateTime());

        transactionsDao.updateTransaction(transactions);
    }
}
