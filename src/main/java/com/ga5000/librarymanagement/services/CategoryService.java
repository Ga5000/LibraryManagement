package com.ga5000.librarymanagement.services;

import com.ga5000.librarymanagement.model.Category;
import com.ga5000.librarymanagement.repositories.CategoryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void saveCategory(Category category){
        categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){
        Sort sort = Sort.by("categoryName").ascending();
        return categoryRepository.findAll(sort);
    }

    public void deleteCategory(UUID id){
        categoryRepository.deleteById(id);
    }

    public Optional<Category> checkIfCategoryExists(UUID id){
        return categoryRepository.findById(id);
    }
}
