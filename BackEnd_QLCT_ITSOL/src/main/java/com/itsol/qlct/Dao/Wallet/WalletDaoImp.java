package com.itsol.qlct.Dao.Wallet;

import com.itsol.qlct.Entity.Wallet;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class WalletDaoImp implements WalletDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Wallet> listWallet() {
        Session session = entityManager.unwrap(Session.class);
        String hql = "FROM Wallet";
        Query<Wallet> q = session.createQuery(hql);
        List list = q.getResultList();
        return list;
    }

    @Override
    public List<Wallet> searchByName(String walletName) {
        Session session = entityManager.unwrap(Session.class);
        //select * from wallet where wallet_name ='vca'
        //select * from wallet where wallet_name like '%'
        String hql = "select w from Wallet w where w.walletName like concat('%',:walletName,'%') ";
        Query<Wallet> query = session.createQuery(hql);
        query.setParameter("walletName", walletName);
        List list = query.getResultList();
        return list;
    }



    @Override
    public void addWallet(Wallet wallet) {
//        entityManager.persist(wallet);
        Session session = entityManager.unwrap(Session.class);

        String sql = "insert into wallet(balance,currency,wallet_name,create_date) value ("+ wallet.getBalance() +"," +
                " "+ wallet.getCurrency() +", \'"+ wallet.getWalletName() +"\', str_to_date(\'"+ wallet.getCreateDate() +"\', \'%Y-%m-%d\'))";
         Query<Wallet> query = session.createSQLQuery(sql);
        query.executeUpdate();
    }

    @Override
    public Wallet checkWalletName(String walletName) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "select w from Wallet w where w.walletName = \'"+ walletName  +"\'  ";
        Query<Wallet> query = session.createQuery(hql);
        return query.getSingleResult();
    }

    @Override
    public void deleteWallet(int walletId) {
        Session session = entityManager.unwrap(Session.class);
        //DELETE FROM wallet WHERE wallet_id = 2;
        String hql = "delete from Wallet w where w.walletId = :deleteId ";
        Query<Wallet> query = session.createQuery(hql);
        query.setParameter("deleteId", walletId);
        query.executeUpdate();
    }

    @Override
    public void updateWallet(Wallet wallet) {
        Session session = entityManager.unwrap(Session.class);
        //update wallet set wallet_name = 'phongmax', balance = 181818 ,currency = 969696, create_date = date_format('30-09-20','%d-%m-%y') where wallet_id = 11;
        String hql = "update Wallet w set w.walletName = \'"+ wallet.getWalletName() +"\', w.balance = "+ wallet.getBalance() +", w.currency = "+ wallet.getCurrency() +", w.createDate = str_to_date(\'"+ wallet.getCreateDate() +"\', \'%d-%m-%Y\')" +
                " where w.walletId = "+ wallet.getWalletId() +" ";
        Query<Wallet> query = session.createQuery(hql);
        query.executeUpdate();
    }

    @Override
    public String findByWalletIdReturnWalletName(int walletId) {
        Session session = entityManager.unwrap(Session.class);
        //select w.wallet_name from wallet w where wallet_id = 1;
        String hql = "select w from Wallet w where w.walletId = "+ walletId +" ";
        Query<Wallet> query = session.createQuery(hql);
        Wallet wallet = query.getSingleResult();
        String walletName = wallet.getWalletName();
        return walletName;// the nay thoi
    }

    @Override
    public List<Wallet> listNameAndId() {
        Session session = entityManager.unwrap(Session.class);
//        select wallet_name, wallet_id from wallet;
        String sql = "select wallet_id, wallet_name from wallet";
        Query<Wallet> query = session.createSQLQuery(sql);
        List list = query.getResultList();
        return list;
    }

    @Override
    public Wallet findWalletId(int walletId) {

        Session session = entityManager.unwrap(Session.class);
        String hql = "select w from Wallet w where w.walletId = :id";
        Query<Wallet> query = session.createQuery(hql);
        query.setParameter("id", walletId);
        Wallet wallet= query.getSingleResult();
        return wallet;
        }
}
