package com.example.jeong_repository.service;

import com.example.jeong_repository.mapper.CommunityMapper;
import com.example.jeong_repository.model.CommunityModel;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityService {
    private static final Logger log = Logger.getLogger(com.example.jeong_repository.service.CommunityService.class.getName());

    @Autowired
    private CommunityMapper communityMapper;

    public List<CommunityModel> selectCommunity(int startRow, int pageSize) {
        return this.communityMapper.selectCommunity(startRow, pageSize);
    }

    public int selectCount() {
        int count = this.communityMapper.selectCount();
        return count;
    }
}
