package com.alpha.module.system.mapper;

import com.alpha.module.system.bean.ResourceTreeBean;
import com.alpha.module.system.model.ResourceModel;
import com.alpha.module.system.model.RoleModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface ResourceInfoMapper extends BaseMapper<ResourceModel> {
    /**
     * 查询及分页
     * @param query
     * @return
     */
    List<ResourceTreeBean> selectQueryAndPage(ResourceTreeBean query);
}
