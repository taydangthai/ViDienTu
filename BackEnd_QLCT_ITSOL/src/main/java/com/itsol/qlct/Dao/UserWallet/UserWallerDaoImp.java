package com.itsol.qlct.Dao.UserWallet;

import com.itsol.qlct.Entity.UserWallet;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserWallerDaoImp implements UserWallerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserWallet> showAll(UserWallet userWaller) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "select uw from UserWallet uw";
        Query<UserWallet> query = session.createQuery(hql);
        List list = query.getResultList();
        return list;
    }

    @Override
    public List<UserWallet> findById(int userWalletId) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "select uw from UserWallet uw where uw.userWalletId = :id";
        Query<UserWallet> query = session.createQuery(hql);
        query.setParameter("id", userWalletId);
        List<UserWallet> list = query.getResultList();
        return list;
    }

    @Override
    public String addUW(UserWallet userWaller) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "insert into users_wallet(role, users_user_id, wallet_wallet_id) value("+ userWaller.getRole() +" ," +
                " "+ userWaller.getUsers().getUserId() +", "+ userWaller.getWallet().getWalletId() +")";
        Query<UserWallet> query = session.createQuery(sql);
        query.executeUpdate();
        return "ok";
    }



    @Override
    public String deleteUW(int userWalletId) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "delete from UserWallet uw where uw.userWalletId = :id";
        Query<UserWallet> query = session.createQuery(hql);
        query.setParameter("id", userWalletId);
        query.executeUpdate();
        return "ok";
    }

    @Override
    public String deleteUWWalletId(int walletId) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "delete from UserWallet uw where uw.wallet.walletId = "+ walletId +"";
        Query<UserWallet> query = session.createQuery(hql);
        query.executeUpdate();
        return "ok";
    }

    @Override
    public String updateUW(UserWallet userWaller) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "update UserWallet uw set uw.role = "+ userWaller.getRole() +" , uw.users.userId = "+ userWaller.getUsers().getUserId() +"," +
                " uw.wallet.walletId = "+ userWaller.getWallet().getWalletId() +" where uw.userWalletId = "+ userWaller.getUserWalletId() +" ";
        Query<UserWallet> query = session.createQuery(hql);
        query.executeUpdate();
        return "ok";
    }

    @Override
    public List<UserWallet> hienThiTheoUserId(int userId) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "select uw from UserWallet uw where uw.users.userId = "+ userId +" ";
        Query<UserWallet> query = session.createQuery(hql);
        List<UserWallet> list = query.getResultList();
        return list;
    }

    @Override
    public UserWallet checkRole(int walletId, int userId) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "select uw from UserWallet uw where uw.wallet.walletId = "+ walletId +" and uw.users.userId = "+ userId +" ";
        Query<UserWallet> query = session.createQuery(hql);
        UserWallet singleResult = query.getSingleResult();
        return singleResult;
    }


}
