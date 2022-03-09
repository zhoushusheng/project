package com.istudy.aixuetong.api.birth.entity.count.mapper;

import com.istudy.aixuetong.api.birth.entity.count.vo.*;
import com.istudy.aixuetong.api.count.vo.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhoushusheng
 * @since
 * */
@Repository
public interface CountMapper {

    List<AreaCountVO> listAreaCount(Integer userId);

    List<EducationCountVO> listEduCount();

    List<ReciprocalCountVO> listRplCount();

    List<TitleCountVO> listTitleCount();

    List<TypeCountVO> listTypeCount();
}



