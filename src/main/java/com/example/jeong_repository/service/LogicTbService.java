package com.example.jeong_repository.service;

import com.example.jeong_repository.mapper.LogicTbMapper;
import com.example.jeong_repository.model.LogicTbModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogicTbService {
    @Autowired
    private LogicTbMapper logicTbMapper;

    public List<LogicTbModel> selectLogicTb() {
        return this.logicTbMapper.selectLogicTb();
    }
}
