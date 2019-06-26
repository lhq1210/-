package com.ln.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class CrmCustomer {
    @ApiModelProperty(value = "客户id")
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer uid;

    @ApiModelProperty(value = "客户公司id")
    private Integer companyId;

    @ApiModelProperty(value = "客户公司名称")
    private String companyName;

    @ApiModelProperty(value = "客户地址")
    private String address;

    @ApiModelProperty(value = "跟进状态")
    private Integer followState;

    @ApiModelProperty(value = "跟进时间", example = "2018-10-01 12:18:48")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date followTime;

    @ApiModelProperty(value = "商机来源")
    private Integer businessSource;

    @ApiModelProperty(value = "销售阶段")
    private Integer saleStage;

    @ApiModelProperty(value = "合作情况")
    private Integer cooperation;

    @ApiModelProperty(value = "名片路径")
    private String businissCardPath;

    @ApiModelProperty(value = "客户位置经度")
    private Double longitude;

    @ApiModelProperty(value = "客户位置纬度")
    private Double latitude;

    @ApiModelProperty(value = "0-停用 1-正常")
    private Integer status;

    @ApiModelProperty(value = "作废标记 -0 删除 -1 正常")
    private Integer delflag;

    @ApiModelProperty(value = "创建人id")
    private Integer createrId;

    @ApiModelProperty(value = "创建人名称")
    private String creater;

    @ApiModelProperty(value = "创建时间", example = "2018-10-01 12:18:48")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createrTime;

    @ApiModelProperty(value = "修改人id")
    private Integer modifyId;

    @ApiModelProperty(value = "修改人名称")
    private String modify;

    @ApiModelProperty(value = "修改时间", example = "2018-10-01 12:18:48")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getFollowState() {
        return followState;
    }

    public void setFollowState(Integer followState) {
        this.followState = followState;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public Integer getBusinessSource() {
        return businessSource;
    }

    public void setBusinessSource(Integer businessSource) {
        this.businessSource = businessSource;
    }

    public Integer getSaleStage() {
        return saleStage;
    }

    public void setSaleStage(Integer saleStage) {
        this.saleStage = saleStage;
    }

    public Integer getCooperation() {
        return cooperation;
    }

    public void setCooperation(Integer cooperation) {
        this.cooperation = cooperation;
    }

    public String getBusinissCardPath() {
        return businissCardPath;
    }

    public void setBusinissCardPath(String businissCardPath) {
        this.businissCardPath = businissCardPath == null ? null : businissCardPath.trim();
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelflag() {
        return delflag;
    }

    public void setDelflag(Integer delflag) {
        this.delflag = delflag;
    }

    public Integer getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Integer createrId) {
        this.createrId = createrId;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getCreaterTime() {
        return createrTime;
    }

    public void setCreaterTime(Date createrTime) {
        this.createrTime = createrTime;
    }

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public String getModify() {
        return modify;
    }

    public void setModify(String modify) {
        this.modify = modify == null ? null : modify.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}