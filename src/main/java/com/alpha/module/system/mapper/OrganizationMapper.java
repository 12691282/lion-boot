package com.alpha.module.system.mapper;

import com.alpha.module.system.bean.OrganizationTreeBean;
import com.alpha.module.system.model.OrganizationModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface OrganizationMapper extends BaseMapper<OrganizationModel> {
    /**
     * 查询及分页
     * @param query
     * @return
     */
    List<OrganizationTreeBean> getOrganizationPageList(Map param);
}
