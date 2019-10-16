package com.alpha.module.system.mapper;

import com.alpha.module.system.model.RoleModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface RoleInfoMapper extends BaseMapper<RoleModel> {
    /**
     * 查询及分页
     * @param query
     * @return
     */
    List<RoleModel> selectQueryAndPage(RoleModel query);
}
