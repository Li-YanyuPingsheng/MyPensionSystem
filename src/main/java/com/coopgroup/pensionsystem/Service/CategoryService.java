package com.coopgroup.pensionsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coopgroup.pensionsystem.Pojo.Category;

import java.util.HashMap;

public interface CategoryService extends IService<Category> {
    public Boolean addCategory(Category category);
    public Boolean updateCategory(Category category);
    public Boolean deleteCategory(Long UUID);
    public HashMap<Long,Category> getCategoryMap();
    public HashMap<Long,Category> getCategoryMapByFather_UUID(Long father_UUID);
    public HashMap<Long,Category> getCategoryMapByLeafDepth(Long LeafDepth);
}
