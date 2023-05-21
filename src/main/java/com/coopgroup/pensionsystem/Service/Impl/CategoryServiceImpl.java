package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coopgroup.pensionsystem.Mapper.CategoryMapper;
import com.coopgroup.pensionsystem.Pojo.Category;
import com.coopgroup.pensionsystem.Service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Override
    public Boolean addCategory(Category category) {
        Boolean valueReturn=false;
        valueReturn=this.saveOrUpdate(category);
        return valueReturn;
    }

    @Override
    public Boolean updateCategory(Category category) {
        Boolean valueReturn=false;
        valueReturn=this.saveOrUpdate(category);
        return valueReturn;
    }

    @Override
    public Boolean deleteCategory(Long UUID) {
        Boolean valueReturn=false;
        valueReturn=this.removeById(UUID);
        return valueReturn;
    }

    @Override
    public HashMap<Long, Category> getCategoryMap() {
        HashMap<Long,Category> categoryHashMap=new HashMap<>();
        ArrayList<Category> categoryArrayList= (ArrayList<Category>) this.list();
        categoryArrayList.forEach(e->{
            categoryHashMap.put(e.getUUID(),e);
        });
        return categoryHashMap;
    }

    @Override
    public HashMap<Long, Category> getCategoryMapByFather_UUID(Long father_UUID) {
        HashMap<Long,Category> categoryHashMap=new HashMap<>();
        QueryWrapper<Category> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("Father_UUID",father_UUID);
        ArrayList<Category> categoryArrayList= (ArrayList<Category>) this.list(queryWrapper);
        categoryArrayList.forEach(e->{
            categoryHashMap.put(e.getUUID(),e);
        });
        return categoryHashMap;
    }

    @Override
    public HashMap<Long, Category> getCategoryMapByLeafDepth(Long LeafDepth) {
        HashMap<Long,Category> categoryHashMap=new HashMap<>();
        QueryWrapper<Category> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("LeafDepth",LeafDepth);
        ArrayList<Category> categoryArrayList= (ArrayList<Category>) this.list(queryWrapper);
        categoryArrayList.forEach(e->{
            categoryHashMap.put(e.getUUID(),e);
        });
        return categoryHashMap;
    }
}
