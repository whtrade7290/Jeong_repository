package com.example.jeong_repository.mapper;

import com.example.jeong_repository.model.LogicTbModel;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogicTbMapper {
    List<LogicTbModel> selectLogicTb();
}
