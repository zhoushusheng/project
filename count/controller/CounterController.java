package com.istudy.aixuetong.api.birth.entity.count.controller;

import com.istudy.aixuetong.api.birth.entity.count.service.CountService;
import com.istudy.aixuetong.api.birth.entity.count.vo.*;
import com.istudy.aixuetong.common.core.web.BaseController;
import com.istudy.aixuetong.common.core.web.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhoushusheng
 * @since 2022-01-27 11:08:39
 */
@Api(tags = "学校区域统计")
@RestController
@RequestMapping("/api/count/statistic")
public class CounterController extends BaseController {

    private CountService countService;

    @ApiOperation("根据id查询学校区域数量")
    @GetMapping("/getAreaSta")
    public BaseResult<List<AreaCountVO>> getAreaSchoolSta() {
        Integer loginUserId = this.getLoginUserId();
        List<AreaCountVO> records = countService.listAreaCount(loginUserId);
        return BaseResult.ok(records);
    }

    @ApiOperation("统计学历数量")
    @GetMapping("/getEduSta")
    public BaseResult<List<EducationCountVO>> getEduSta() {
        List<EducationCountVO> records = countService.listEduCount();
        return BaseResult.ok(records);
    }

    @ApiOperation("统计普惠园数量（是、否数量）")
    @GetMapping("/getRprlSta")
    public BaseResult<List<ReciprocalCountVO>> getRprlSta() {
        List<ReciprocalCountVO> records = countService.listRprlCount();
        return BaseResult.ok(records);
    }


    @ApiOperation("统计职称数量")
    @GetMapping("/getTitleSta")
    public BaseResult<List<TitleCountVO>> getTitleSta() {
        List<TitleCountVO> records = countService.listTitleCount();
        return BaseResult.ok(records);
    }

    @ApiOperation("统计办学类型数量")
    @GetMapping("/getTypeSta")
    public BaseResult<List<TypeCountVO>> getTypeSta() {
        List<TypeCountVO> records = countService.listTypeCount();
        return BaseResult.ok(records);
    }

    @Autowired
    public void setCountService(CountService countService) {
        this.countService = countService;
    }




}
