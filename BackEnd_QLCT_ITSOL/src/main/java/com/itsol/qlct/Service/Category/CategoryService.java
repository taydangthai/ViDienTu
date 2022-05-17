package com.itsol.qlct.Service.Category;

import com.itsol.qlct.Dto.CategoryDto;


import java.util.List;

public interface CategoryService {

    List<CategoryDto> listCategory();

    List<CategoryDto> findByName(String categoryName);

    String addCategory(CategoryDto categoryDto);

    String deleteCategory(int categoryId);

    String updateCategory(CategoryDto categoryDto);
}
