package com.itsol.qlct.Dao.Category;

import com.itsol.qlct.Entity.Category;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDaoImp implements CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Category> listCategory() {
        Session session = entityManager.unwrap(Session.class);
        String hql = "SELECT c FROM Category c";
        Query<Category> query = session.createQuery(hql);
        List list = query.getResultList();
        return list;
    }

    @Override
    public List<Category> findName(String categoryName) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "select c from Category c where c.categoryName like concat('%',:categoryName,'%')";
        Query<Category> query = session.createQuery(hql);
        query.setParameter("categoryName", categoryName);
        List list = query.getResultList();
        return list;
    }

    @Override
    public Category findIdCate(int categoryId) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "select c from Category c where c.categoryId = :id";
        Query<Category> query = session.createQuery(hql);
        query.setParameter("id", categoryId);
        Category category = query.getSingleResult();
        return category;
    }

    @Override
    public String findByCategoryIdReturnCategoryName(int categoryId) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "select c from Category c where c.categoryId = "+ categoryId +"";
        Query<Category> query = session.createQuery(hql);
        Category category = query.getSingleResult();
        String categoryName = category.getCategoryName();
        return categoryName;
    }

    @Override
    public String addCategory(Category category) {
        /*Session session = entityManager.unwrap(Session.class);
        String sql = "insert into category(category_name) value (\'"+ category.getCategoryName() +"\')";
        Query<Category> query = session.createSQLQuery(sql);
        query.executeUpdate();
        return "Chac la dc r day :))";*/
        
        entityManager.persist(category);
        return "ok";
    }

    @Override
    public String deleteCategory(int categoryId) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "delete from Category c where c.categoryId = :id";
        Query<Category> query = session.createQuery(hql);
        query.setParameter("id",categoryId);
        query.executeUpdate();
        return "ok ping";
    }

    @Override
    public String updateCategory(Category category) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "update Category c set c.categoryName = \'"+ category.getCategoryName() +"\' where c.categoryId = "+ category.getCategoryId() +"  ";
        Query<Category> query = session.createQuery(hql);
        query.executeUpdate();
        return "ok chua?";
    }
}
