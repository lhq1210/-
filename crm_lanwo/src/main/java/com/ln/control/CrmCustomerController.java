package com.ln.control;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.cyrj.common.constant.ValidationMessge;
import com.cyrj.common.control.BaseController;
import com.cyrj.common.util.Response;
import com.cyrj.common.util.IgnoreSecurity;
import com.github.pagehelper.PageInfo;
import com.ln.service.CrmCustomerService;
import com.ln.pojo.CrmCustomer;


/**
 * 
 * @author lhq
 * @version 创建时间：2019-06-26 09:36:58
 */
@RestController
@RequestMapping(value = "/api/pojo/crmCustomer")
@Api(description = "客户记录接口")
public class CrmCustomerController extends BaseController{

    @Autowired
    CrmCustomerService crmCustomerService;

    @ApiOperation(value = "查找客户记录列表")
    @IgnoreSecurity(val = false)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Response list(HttpServletRequest request,@ApiParam(value = "关键字", required = false) @RequestParam(required = false, value = "keyword") String keyword) {
        Map map = new HashMap();
        map.put("keyword", keyword);
        map.put("tenantId", getTenantId(request));
        List<Map> list = crmCustomerService.findListByMap(map);
        Response response = new Response();
        return response.success(list);
    }

    @ApiOperation(value = "查找客户记录列表(分页)")
    @IgnoreSecurity(val = false)
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Response page(HttpServletRequest request,@ApiParam(value = "页码", required = true) @RequestParam(required = true, value = "pageNum") Integer pageNum,@ApiParam(value = "每页显示数量", required = true) @RequestParam(required = true, value = "pageSize") Integer pageSize,@ApiParam(value = "关键字", required = false) @RequestParam(required = false, value = "keyword") String keyword) {
        Map map = new HashMap();
        map.put("keyword", keyword);
        map.put("tenantId", getTenantId(request));
        PageInfo<Map> page = crmCustomerService.findListPageByMap(map,pageNum,pageSize);
        Response response = new Response();
        return response.success(page);
    }

    @ApiOperation(value = "根据Id查找客户记录")
     @IgnoreSecurity(val = false)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Response get(HttpServletRequest request,@ApiParam(value = "id", required = true) @PathVariable(required = true, value = "id") Integer id){
        CrmCustomer crmCustomer = new CrmCustomer();
        crmCustomer.setId(id);
        return getResult(crmCustomerService.getMapById(crmCustomer));
    }

    @ApiOperation(value ="新增客户记录")
    @IgnoreSecurity(val = false)
    @RequestMapping(method = RequestMethod.POST)
    public Response save(HttpServletRequest request,@RequestBody CrmCustomer crmCustomer) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        crmCustomer.setCreater(getEmployeeName(request));
        crmCustomer.setCreaterId(getEmployeeId(request));
        crmCustomer.setModify(crmCustomer.getCreater());
        crmCustomer.setModifyId(crmCustomer.getCreaterId());
        return getResult(crmCustomerService.add(crmCustomer));
    }

    @ApiOperation(value = "修改客户记录")
    @IgnoreSecurity(val = false)
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Response update(HttpServletRequest request,@RequestBody CrmCustomer crmCustomerForm) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if(crmCustomerForm.getId() <= 0)
        {
            return getResultError(ValidationMessge.ID_RRROR);
        }
        CrmCustomer crmCustomer = new CrmCustomer();
        crmCustomer.setId(crmCustomerForm.getId());
        crmCustomer = crmCustomerService.getById(crmCustomer);
        if(crmCustomer == null)
        {
            return getResultError(ValidationMessge.QUERY_ERROR);
        }
        crmCustomer.setModify(getEmployeeName(request));
        crmCustomer.setModifyId(getEmployeeId(request));
        return getResult(crmCustomerService.update(crmCustomer));

    }

    @ApiOperation(value = "删除客户记录")
    @IgnoreSecurity(val = false)
    @RequestMapping(method = RequestMethod.DELETE)
    public Response delete(HttpServletRequest request,@ApiParam(value = "ids", required = true) @RequestParam(required = true, value = "ids") Integer ids){
        Map map = new HashMap();
        map.put("ids", ids);
        map.put("modify", getEmployeeName(request));
        map.put("modifyId", getEmployeeId(request));
        return getResult(crmCustomerService.delete(map));
    }
}