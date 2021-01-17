package com.epms.dao.CheckOnDao;

import com.epms.entity.CheckOn;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CheckOnDao {

    int insertIntoCheckOn(CheckOn checkOn);

    int updateWorkTime(CheckOn checkOn);

    CheckOn getToday(CheckOn checkOn);
}
