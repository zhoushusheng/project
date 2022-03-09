package com.istudy.aixuetong.api.birth.entity.count.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhoushusheng
 * @since 2022-01-27 11:08:39
 */
@Data
public class TitleCountVO {


    @ApiModelProperty("titleCount")
    private Integer titleCount;

    @ApiModelProperty("professionalTitle")
    private String professionalTitle;


}
