package com.kbl.ecommerce.commons.data.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageDto<T> {

    /**
     * The actual page content/data
     */
    private List<T> content;

    /**
     * Current page number (0-indexed)
     */
    private int pageNumber;

    /**
     * Number of items per page
     */
    private int pageSize;

    /**
     * Total number of elements across all pages
     */
    private long totalElements;

    /**
     * Total number of pages
     */
    private int totalPages;

    /**
     * Whether this is the first page
     */
    private boolean first;

    /**
     * Whether this is the last page
     */
    private boolean last;

    /**
     * Whether there is a next page
     */
    private boolean hasNext;

    /**
     * Whether there is a previous page
     */
    private boolean hasPrevious;

    /**
     * Number of elements in the current page
     */
    private int numberOfElements;

    /**
     * Whether the page is empty
     */
    private boolean empty;
}
