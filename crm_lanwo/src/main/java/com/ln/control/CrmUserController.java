package com.ln.control;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cyrj.common.constant.ValidationMessge;
import com.cyrj.common.control.BaseController;
import com.cyrj.common.util.IgnoreSecurity;
import com.cyrj.common.util.Response;
import com.github.pagehelper.PageInfo;
import com.ln.pojo.CrmUser;
import com.ln.service.CrmUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * 
 * @author lhq
 * @version 创建时间：2019-06-25 11:29:35
 */
@RestController
@RequestMapping(value = "/api/pojo/crmUser")
@Api(description = "用户记录接口")
public class CrmUserController extends BaseController{

    @Autowired
    CrmUserService crmUserService;

    @ApiOperation(value = "查找用户记录列表")
    @IgnoreSecurity(val = false)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Response list(HttpServletRequest request,@ApiParam(value = "关键字", required = false) @RequestParam(required = false, value = "keyword") String keyword) {
        Map map = new HashMap();
        map.put("keyword", keyword);
        map.put("tenantId", getTenantId(request));
        List<Map> list = crmUserService.findListByMap(map);
        Response response = new Response();
        return response.success(list);
    }

    @ApiOperation(value = "查找用户记录列表(分页)")
    @IgnoreSecurity(val = false)
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Response page(HttpServletRequest request,@ApiParam(value = "页码", required = true) @RequestParam(required = true, value = "pageNum") Integer pageNum,@ApiParam(value = "每页显示数量", required = true) @RequestParam(required = true, value = "pageSize") Integer pageSize,@ApiParam(value = "关键字", required = false) @RequestParam(required = false, value = "keyword") String keyword) {
        Map map = new HashMap();
        map.put("keyword", keyword);
        map.put("tenantId", getTenantId(request));
        PageInfo<Map> page = crmUserService.findListPageByMap(map,pageNum,pageSize);
        Response response = new Response();
        return response.success(page);
    }

    @ApiOperation(value = "根据Id查找用户记录")
     @IgnoreSecurity(val = false)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Response get(HttpServletRequest request,@ApiParam(value = "id", required = true) @PathVariable(required = true, value = "id") Integer id){
        CrmUser crmUser = new CrmUser();
        crmUser.setId(id);
        return getResult(crmUserService.getMapById(crmUser));
    }

    @ApiOperation(value ="新增用户记录")
    @IgnoreSecurity(val = false)
    @RequestMapping(method = RequestMethod.POST)
    public Response save(HttpServletRequest request,@RequestBody CrmUser crmUser) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        crmUser.setCreater(getEmployeeName(request));
        crmUser.setCreaterId(getEmployeeId(request));
        crmUser.setModify(crmUser.getCreater());
        crmUser.setModifyId(crmUser.getCreaterId());
        //crmUser.setTenantId(getTenantId(request));
        return getResult(crmUserService.add(crmUser));
    }

    @ApiOperation(value = "修改用户记录")
    @IgnoreSecurity(val = false)
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Response update(HttpServletRequest request,@RequestBody CrmUser crmUserForm) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if(crmUserForm.getId() <= 0)
        {
            return getResultError(ValidationMessge.ID_RRROR);
        }
        CrmUser crmUser = new CrmUser();
        crmUser.setId(crmUserForm.getId());
        crmUser = crmUserService.getById(crmUser);
        if(crmUser == null)
        {
            return getResultError(ValidationMessge.QUERY_ERROR);
        }
        crmUser.setModify(getEmployeeName(request));
        crmUser.setModifyId(getEmployeeId(request));
        return getResult(crmUserService.update(crmUser));

    }

    @ApiOperation(value = "删除用户记录")
    @IgnoreSecurity(val = false)
    @RequestMapping(method = RequestMethod.DELETE)
    public Response delete(HttpServletRequest request,@ApiParam(value = "ids", required = true) @RequestParam(required = true, value = "ids") Integer ids){
        Map map = new HashMap();
        map.put("ids", ids);
        map.put("modify", getEmployeeName(request));
        map.put("modifyId", getEmployeeId(request));
        return getResult(crmUserService.delete(map));
    }
}