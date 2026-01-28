package com.kbl.ecommerce.commons.data.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageDto<T> {
    private List<T> items;
    private int page;
    private int size;
    private long totalItems;
    private int totalPages;
}
