package com.itsol.qlct.Dao.Users;

import com.itsol.qlct.Entity.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class UsersDaoImp implements UsersDao {


    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<Users> showAllExceptPass() {
        Session session = entityManager.unwrap(Session.class);
        String hql = "from Users";
        Query<Users> query = session.createQuery(hql);
        List<Users> users = query.getResultList();
        return users;
    }

    @Override
    public Users findByUserName(String username) {

        Session session = entityManager.unwrap(Session.class);
        String hql = "select u from Users u where u.userName = :username";
        Query<Users> query = session.createQuery(hql);
        query.setParameter("username", username);
        Users users = query.getSingleResult();
        return users;
    }

    @Override
    public String saveUser(Users users) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "insert into users(name, user_name, pass_word, phone_number, gender, path_ava) value" +
                "(\'"+ users.getName() +"\', \'"+ users.getUserName() +"\', \'"+ users.getPassWord() +"\', "+ users.getPhoneNumber() +" , "+ users.getGender() +" , \'"+ users.getPathAva() +"\')";
        Query<Users> query = session.createSQLQuery(sql);
        query.executeUpdate();
        return "ok";
    }

    @Override
    public String updateUser(Users users) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "update Users u set u.gender = \'"+ users.getGender() +"\', u.name = \'"+ users.getName() +"\'," +
                " u.passWord = \'"+ users.getPassWord() +"\', u.pathAva = \'"+ users.getPathAva() +"\', u.phoneNumber = \'"+ users.getPhoneNumber() +"\'," +
                " u.userName = \'"+ users.getUserName() +"\' where u.userId = \'"+ users.getUserId() +"\' ";
        Query<Users> query = session.createQuery(hql);
        query.executeUpdate();
        return "ok";
    }

    @Override
    public String deleteUser(int userId) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "delete from Users u where u.userId = :id";
        Query<Users> query = session.createQuery(hql);
        query.setParameter("id",userId);
        query.executeUpdate();
        return "ok";
    }

    @Override
    public Users findUserId(int userId) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "select u from Users u where u.userId = "+ userId +" ";
        Query<Users> query = session.createQuery(hql);
        Users users = query.getSingleResult();
        return users;
    }

    @Override
    public Users findByUserNamePass(String userName, String passWord) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "select u from Users u where u.userName = \'"+ userName +"\' and u.passWord = \'"+ passWord +"\'";
        System.out.println(hql);
        Query<Users> query = session.createQuery(hql);
        Users users = query.getSingleResult();
        return users;
    }

    @Override
    public String findByIdReturnName(int userId) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "select u from Users u where u.userId = "+ userId +"";
        Query<Users> query = session.createQuery(hql);
        Users users = query.getSingleResult();
        String name = users.getName();
        return name;
    }
}
