package com.ln.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyrj.common.service.impl.BaseServiceImpl;
import com.ln.mapper.CrmUserMapper;
import com.ln.pojo.CrmUser;
import com.ln.service.CrmUserService;


/**
 * 
 * @author lhq
 * @version 创建时间：2019-06-25 11:29:35
 */
@Service("crmUserService")
public class CrmUserServiceImpl extends BaseServiceImpl<CrmUser> implements CrmUserService {

    @Autowired
    CrmUserMapper crmUserMapper;
}