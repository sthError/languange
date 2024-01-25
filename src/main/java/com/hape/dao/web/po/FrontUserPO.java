package com.hape.dao.web.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 个人端用户
 * </p>
 *
 * @author hape
 * @since 2024-01-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("front_user")
@ApiModel(value = "FrontUserPO对象", description = "个人端用户")
public class FrontUserPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("性别")
    @TableField("gender")
    private String gender;

    @ApiModelProperty("昵称")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty("头像")
    @TableField("picture")
    private String picture;

    @ApiModelProperty("国籍")
    @TableField("country")
    private String country;

    @ApiModelProperty("手机号")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("证件类型")
    @TableField("id_type")
    private String idType;

    @ApiModelProperty("证件号码")
    @TableField("id_number")
    private String idNumber;

    @ApiModelProperty("生日")
    @TableField("birthday")
    private Date birthday;

    @ApiModelProperty("爱好")
    @TableField("hobby")
    private String hobby;

    @ApiModelProperty("个人简介")
    @TableField("personal_profile")
    private String personalProfile;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("创建人")
    @TableField("create_by")
    private String createBy;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty("更新人")
    @TableField("update_by")
    private String updateBy;


}
