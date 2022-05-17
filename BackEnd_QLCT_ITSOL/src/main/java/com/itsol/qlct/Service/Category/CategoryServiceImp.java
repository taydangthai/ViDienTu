package com.itsol.qlct.Service.Category;

import com.itsol.qlct.Dao.Category.CategoryDao;
import com.itsol.qlct.Dto.CategoryDto;
import com.itsol.qlct.Entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Transactional
    @Override
    public List<CategoryDto> listCategory() {
        List<Category> categories = categoryDao.listCategory();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        for(Category c : categories)
        {
            categoryDtos.add(modelMapper.map(c, CategoryDto.class));
        }
        return categoryDtos;
    }

    @Transactional
    @Override
    public List<CategoryDto> findByName(String categoryName) {
        List<Category> categories = categoryDao.findName(categoryName);
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for(Category c : categories)
        {
            CategoryDto categoryDto = new CategoryDto();
                categoryDto.setCategoryId(c.getCategoryId());
                categoryDto.setCategoryName(c.getCategoryName());

                categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }

    @Transactional
    @Override
    public String addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        category = modelMapper.map(categoryDto, Category.class);
        String s = categoryDao.addCategory(category);
        return s;
    }

    @Transactional
    @Override
    public String deleteCategory(int categoryId) {
        categoryDao.deleteCategory(categoryId);
        return "ok";
    }

    @Transactional
    @Override
    public String updateCategory(CategoryDto categoryDto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        Category category = modelMapper.map(categoryDto, Category.class);
        categoryDao.updateCategory(category);
        return "ok men";
    }
}
