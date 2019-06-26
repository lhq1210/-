package com.ln.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class CrmUser {
    @ApiModelProperty(value = "用户id")
    private Integer id;

    @ApiModelProperty(value = "openId")
    private String openId;

    @ApiModelProperty(value = "unionId")
    private String unionId;

    @ApiModelProperty(value = "区号")
    private String countryCode;

    @ApiModelProperty(value = "联系电话")
    private String phoneNumber;

    @ApiModelProperty(value = "头像")
    private String avatarUrl;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "昵称拼音")
    private String nickNameSpell;

    @ApiModelProperty(value = "性别 -0 未知 - 1 男 - 2 女")
    private String gender;

    @ApiModelProperty(value = "国家")
    private String country;

    @ApiModelProperty(value = "省份")
    private String provice;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "岗位名称")
    private String jobsName;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "部门")
    private String department;

    @ApiModelProperty(value = "微信号")
    private String weChat;

    @ApiModelProperty(value = "个人简介")
    private String personalProfile;

    @ApiModelProperty(value = "作废标记 -0 删除 -1 正常")
    private Integer delflag;

    @ApiModelProperty(value = "创建人Id")
    private Integer createrId;

    @ApiModelProperty(value = "创建人名称")
    private String creater;

    @ApiModelProperty(value = "创建时间", example = "2018-10-01 12:18:48")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createrTime;

    @ApiModelProperty(value = "修改人Id")
    private Integer modifyId;

    @ApiModelProperty(value = "创建人名称")
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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getNickNameSpell() {
        return nickNameSpell;
    }

    public void setNickNameSpell(String nickNameSpell) {
        this.nickNameSpell = nickNameSpell == null ? null : nickNameSpell.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice == null ? null : provice.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getJobsName() {
        return jobsName;
    }

    public void setJobsName(String jobsName) {
        this.jobsName = jobsName == null ? null : jobsName.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat == null ? null : weChat.trim();
    }

    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile == null ? null : personalProfile.trim();
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