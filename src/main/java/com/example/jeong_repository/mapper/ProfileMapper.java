package com.example.jeong_repository.mapper;

import com.example.jeong_repository.model.ProfileModel;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProfileMapper {
    List<ProfileModel> selectProfile();

    long profileInsert(ProfileModel paramProfileModel);
}
