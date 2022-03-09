package com.istudy.aixuetong.api.birth.entity.count.service;

import com.istudy.aixuetong.api.birth.entity.count.vo.*;
import com.istudy.aixuetong.api.count.vo.*;

import java.util.List;
/**
 * @author zhoushusheng
 * @since 2022-01-27 11:08:39
 */
public interface CountService  {

    List<AreaCountVO> listAreaCount(Integer userId);
    List<EducationCountVO> listEduCount();
    List<TitleCountVO> listTitleCount();
    List<TypeCountVO> listTypeCount();
    List<ReciprocalCountVO> listRprlCount();

}
