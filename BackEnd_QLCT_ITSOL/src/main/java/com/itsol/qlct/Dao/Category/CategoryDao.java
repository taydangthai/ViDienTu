package com.itsol.qlct.Dao.Category;

import com.itsol.qlct.Entity.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> listCategory();

    List<Category> findName(String categoryName);

    String addCategory(Category category);

    String deleteCategory(int categoryId);

    String updateCategory(Category category);

    Category findIdCate(int categoryId);

    //them
    String findByCategoryIdReturnCategoryName(int categoryId);
}
