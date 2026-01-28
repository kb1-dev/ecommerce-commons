package com.kbl.ecommerce.commons.data.mapper;

import com.kbl.ecommerce.commons.data.dto.PageDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class PageMapper {

    /**
     * Maps a Spring Data Page of entities to PageDto of DTOs.
     *
     * @param page        the Page of entities
     * @param mapperFunc  a function to convert each entity to DTO
     * @param <E>         Entity type
     * @param <D>         DTO type
     * @return PageDto containing DTOs and pagination info
     */
    public <E, D> PageDto<D> toPageDto(Page<E> page, Function<E, D> mapperFunc) {
        if (page == null) {
            return null;
        }

        List<D> dtoList = page.getContent().stream()
                .map(mapperFunc)
                .toList();

        PageDto<D> pageDto = new PageDto<>();
        pageDto.setItems(dtoList);
        pageDto.setPage(page.getNumber());
        pageDto.setSize(page.getSize());
        pageDto.setTotalItems(page.getTotalElements());
        pageDto.setTotalPages(page.getTotalPages());

        return pageDto;
    }
}
