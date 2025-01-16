package com.github.mertdeveci.converter;

import jakarta.annotation.Nonnull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Converter<I, O> {
    O convert(I input);

    default List<O> convert(@Nonnull List<I> input){
        return input.stream().map(this::convert).toList();
    }

    default Page<O> convert(@Nonnull Page<I> page){
        List<O> oList = page.getContent().stream().map(this::convert).toList();
        Pageable pageable = page.getPageable();
        long totalElements = page.getTotalElements();
        return new PageImpl<>(oList, pageable, totalElements);
    }
}
