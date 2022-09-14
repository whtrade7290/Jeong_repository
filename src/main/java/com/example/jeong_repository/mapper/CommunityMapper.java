package com.example.jeong_repository.mapper;

import com.example.jeong_repository.model.CommunityModel;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityMapper {
    int selectCount();

    List<CommunityModel> selectCommunity(int startRow, int pageSize);
}
