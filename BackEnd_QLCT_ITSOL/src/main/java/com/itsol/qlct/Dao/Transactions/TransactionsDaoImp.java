package com.itsol.qlct.Dao.Transactions;

import com.itsol.qlct.Entity.Transactions;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TransactionsDaoImp implements TransactionsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Transactions> findDateTime(String dateTimeStart, String dateTimeEnd) {
        Session session = entityManager.unwrap(Session.class);
        //SELECT * FROM transactions WHERE date_time BETWEEN str_to_date('01,08,2020', '%d,%m,%Y') and str_to_date('02,05,2022', '%d,%m,%Y') order by date_time desc;
        String hql = "select t from Transactions t where t.dateTime between str_to_date(\'"+ dateTimeStart +"\', \'%d-%m-%Y\') and str_to_date(\'"+ dateTimeEnd +"\', \'%d-%m-%Y\') order by  t.dateTime desc ";
        Query<Transactions> query = session.createQuery(hql);
        List<Transactions> list = query.getResultList();
        return list;
    }

    @Override
    public List<Transactions> listOrderByTimeName() {
        Session session = entityManager.unwrap(Session.class);
        /*select t.trans_id, t.amount, t.date_time, t.note, t.trans_type, u.username, w.wallet_name,
         c.category_name from transactions t inner join users u on t.users_user_id = u.user_id
         inner join wallet w on t.wallet_wallet_id = w.wallet_id inner join category c
         on t.category_category_id = c.category_id order by t.date_time desc, t.note asc ;*/
        String hql = "select t  from Transactions t inner join Users u " +
                "on t.users.userId = u.userId inner join Wallet w on t.wallet.walletId = w.walletId " +
                "inner join Category c on t.category.categoryId = c.categoryId " +
                "order by t.dateTime desc, t.note asc";
        Query<Transactions> query = session.createQuery(hql);
        List<Transactions> list = query.getResultList();
        return list;

    }

    @Override
    public List<Transactions> getListByUserId(int userId) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "select t from Transactions t where t.users.userId = "+ userId +" ";
        Query<Transactions> query = session.createQuery(hql);
        List<Transactions> list = query.getResultList();
        return list;
    }

    @Override
    public void deleteTransactions(int transId) {
        Session session = entityManager.unwrap(Session.class);
        //delete from transactions where trans_id = 6;
        String hql = "delete from Transactions t where t.transId = :id";
        Query<Transactions> query = session.createQuery(hql);
        query.setParameter("id", transId);
        query.executeUpdate();
    }

    @Override
    public void deleteTransWalletId(int walletId) {
        Session session = entityManager.unwrap(Session.class);
        //delete from transactions where trans_id = 6;
        String hql = "delete from Transactions t where t.wallet.walletId = "+ walletId +"";
        Query<Transactions> query = session.createQuery(hql);
        query.executeUpdate();
    }

    @Override
    public void addTransaction(Transactions transactions) {
//        entityManager.persist(transactions);
        //insert into transactions(amount, date_time, note, trans_type, category_category_id, users_user_id, wallet_wallet_id) value (856321,str_to_date('25-08-2020', '%d-%m-%Y'), 'em co buon', 1, 2, 3, 4);
        Session session = entityManager.unwrap(Session.class);
        String sql = "insert into transactions(amount, date_time, note, trans_type, category_category_id, " +
                "users_user_id, wallet_wallet_id) value " +
                "("+ transactions.getAmount() +",str_to_date(\'"+ transactions.getDateTime() +"\', \'%Y-%m-%d\')," +
                " \'"+ transactions.getNote() +"\'," +
                " "+ transactions.getTransType() +", "+ transactions.getUsers().getUserId() +"," +
                " "+ transactions.getWallet().getWalletId() +", "+ transactions.getCategory().getCategoryId() +")";
        Query<Transactions> query = session.createSQLQuery(sql);
        query.executeUpdate();
    }

    @Override
    public void updateTransaction(Transactions transactions) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "update Transactions t set t.amount = "+ transactions.getAmount() +"," +
                " t.dateTime = str_to_date(\'"+ transactions.getDateTime() +"\', \'%Y-%m-%d\')," +
                " t.note = \'"+ transactions.getNote() +"\', t.transType = "+ transactions.getTransType() +"," +
                " t.category.categoryId = "+ transactions.getCategory().getCategoryId() +"," +
                " t.users.userId = "+ transactions.getUsers().getUserId() +"," +
                " t.wallet.walletId = "+ transactions.getWallet().getWalletId() +"  where t.transId = "+ transactions.getTransId() +" ";
        Query<Transactions> query = session.createQuery(hql);
        query.executeUpdate();
    }

    @Override
    public Boolean addOneTrans(Transactions transactions) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "insert into transactions(amount, date_time, note, trans_type, category_category_id, " +
                "users_user_id, wallet_wallet_id) value " +
                "("+ transactions.getAmount() +",str_to_date(\'"+ transactions.getDateTime() +"\', \'%Y-%m-%d\')," +
                " \'"+ transactions.getNote() +"\'," +
                " "+ transactions.getTransType() +", "+ transactions.getUsers().getUserId() +"," +
                " "+ transactions.getWallet().getWalletId() +", "+ transactions.getCategory().getCategoryId() +")";
        Query<Transactions> query = session.createSQLQuery(sql);
        try {
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
