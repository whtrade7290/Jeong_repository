package com.example.jeong_repository.model;

import lombok.Data;

@Data
public class PaginationModel {

    private int count;
    private int pageCount;
    private int pageBlock;
    private int startPage;
    private int endPage;
}
