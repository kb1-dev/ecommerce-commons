package com.kbl.ecommerce.commons.data.mapper;

import com.kbl.ecommerce.commons.data.dto.PageDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;

public class PageMapper {

    private PageMapper() {
        // Private constructor to prevent instantiation
    }

    /**
     * Convert Spring Data Page to PageDTO
     *
     * @param page Spring Data Page object
     * @param <T> Type of content
     * @return PageDTO with the same content
     */
    public static <T> PageDto<T> toPageDTO(Page<T> page) {
        return PageDto.<T>builder()
                .content(page.getContent())
                .pageNumber(page.getNumber())
                .pageSize(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .first(page.isFirst())
                .last(page.isLast())
                .hasNext(page.hasNext())
                .hasPrevious(page.hasPrevious())
                .numberOfElements(page.getNumberOfElements())
                .empty(page.isEmpty())
                .build();
    }

    /**
     * Convert Spring Data Page to PageDTO with content transformation
     * Useful when you need to convert entities to DTOs
     *
     * @param page Spring Data Page object with entities
     * @param mapper Function to transform content (e.g., entity to DTO)
     * @param <S> Source type (usually entity)
     * @param <T> Target type (usually DTO)
     * @return PageDTO with transformed content
     */
    public static <S, T> PageDto<T> toPageDTO(Page<S> page, Function<S, T> mapper) {
        List<T> transformedContent = page.getContent().stream()
                .map(mapper)
                .toList();

        return PageDto.<T>builder()
                .content(transformedContent)
                .pageNumber(page.getNumber())
                .pageSize(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .first(page.isFirst())
                .last(page.isLast())
                .hasNext(page.hasNext())
                .hasPrevious(page.hasPrevious())
                .numberOfElements(page.getNumberOfElements())
                .empty(page.isEmpty())
                .build();
    }

    /**
     * Convert Spring Data Page to PageDTO with content list transformation
     * Useful when you already have the transformed list
     *
     * @param page Spring Data Page object (for metadata)
     * @param transformedContent Already transformed content list
     * @param <T> Type of transformed content
     * @return PageDTO with transformed content
     */
    public static <T> PageDto<T> toPageDTO(Page<?> page, List<T> transformedContent) {
        return PageDto.<T>builder()
                .content(transformedContent)
                .pageNumber(page.getNumber())
                .pageSize(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .first(page.isFirst())
                .last(page.isLast())
                .hasNext(page.hasNext())
                .hasPrevious(page.hasPrevious())
                .numberOfElements(transformedContent.size())
                .empty(transformedContent.isEmpty())
                .build();
    }
}
