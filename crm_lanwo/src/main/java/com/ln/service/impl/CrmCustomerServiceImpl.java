package com.ln.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cyrj.common.service.impl.BaseServiceImpl;
import com.ln.mapper.CrmCustomerMapper;
import com.ln.service.CrmCustomerService;
import com.ln.pojo.CrmCustomer;


/**
 * 
 * @author lhq
 * @version 创建时间：2019-06-26 09:36:58
 */
@Service("crmCustomerService")
public class CrmCustomerServiceImpl extends BaseServiceImpl<CrmCustomer> implements CrmCustomerService {

    @Autowired
    CrmCustomerMapper crmCustomerMapper;
}