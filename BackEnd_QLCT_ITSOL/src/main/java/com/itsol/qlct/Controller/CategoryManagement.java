package com.itsol.qlct.Controller;

import com.itsol.qlct.Dto.CategoryDto;
import com.itsol.qlct.Service.Category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CategoryManagement {

    @Autowired
    private CategoryService categoryService;

    //ok
    @GetMapping(path = "/category/showAll")
    public List<CategoryDto> showAll()
    {
        return categoryService.listCategory();
    }
    @GetMapping(path = "/category/findName/{categoryName}")
    public List<CategoryDto> findByName(@PathVariable String categoryName)
    {
        return categoryService.findByName(categoryName);
    }

    //ok
    @PostMapping(path = "/category/add")
    public String addCategory(@RequestBody CategoryDto categoryDto)
    {
        return categoryService.addCategory(categoryDto);
    }

    //ok
    @DeleteMapping(path = "/category/deleteId/{categoryID}")
    public String deleteId(@PathVariable("categoryID") int categoryId)
    {
        return categoryService.deleteCategory(categoryId);
    }

    //ok
    @PutMapping(path = "/category/update")
    public String updateCategory(@RequestBody CategoryDto categoryDto)
    {
        return categoryService.updateCategory(categoryDto);
    }
}
