package com.istudy.aixuetong.api.birth.entity.count.service.impl;


import com.alibaba.fastjson.JSON;
import com.istudy.aixuetong.api.birth.entity.count.mapper.CountMapper;
import com.istudy.aixuetong.api.birth.entity.count.service.CountService;
import com.istudy.aixuetong.api.birth.entity.count.vo.*;
import com.istudy.aixuetong.api.count.vo.*;
import com.istudy.aixuetong.api.count.mapper.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhoushusheng
 * @since 2022-01-27 11:08:39
 */
@Slf4j
@Service
public class CountServiceImpl implements CountService {

    private CountMapper countMapper;

    @Override
    public List<AreaCountVO> listAreaCount(Integer userId) {
        List<AreaCountVO> areaCountVOS = countMapper.listAreaCount(userId);
        log.info("areaCounts: " + JSON.toJSONString(areaCountVOS));
        return areaCountVOS;
    }

    @Override
    public List<EducationCountVO> listEduCount() {
        List<EducationCountVO> educationCount = countMapper.listEduCount();
        log.info("educationCount: " + JSON.toJSONString(educationCount));
        return educationCount;
    }

    @Override
    public List<TitleCountVO> listTitleCount() {
        List<TitleCountVO> titleCount = countMapper.listTitleCount();
        log.info("titleCount: " + JSON.toJSONString(titleCount));
        return titleCount;
    }

    @Override
    public List<TypeCountVO> listTypeCount() {
        List<TypeCountVO> typeCount = countMapper.listTypeCount();
        log.info("typeCount: " + JSON.toJSONString(typeCount));
        return typeCount;
    }

    @Override
    public List<ReciprocalCountVO> listRprlCount() {
        List<ReciprocalCountVO> reciprocalCount = countMapper.listRplCount();
        log.info("reciprocalCount: " + JSON.toJSONString(reciprocalCount));
        return reciprocalCount;
    }

    @Autowired
    public void setCountMapperMapper(CountMapper countMapper) {
        this.countMapper = countMapper;
    }

}
