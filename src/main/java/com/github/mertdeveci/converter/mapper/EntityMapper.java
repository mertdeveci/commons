package com.github.mertdeveci.converter.mapper;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.vo.BaseVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EntityMapper<E extends AbstractEntity,V extends BaseVo> {
    V toVo(E entity);
    E toEntity(V vo);

    default List<V> toVo(List<E> entities){
        return entities.stream().map(this::toVo).toList();
    }

    default Page<V> toVo(Page<E> entityPage){
        List<V> voList = entityPage.getContent().stream().map(this::toVo).toList();
        Pageable pageable = entityPage.getPageable();
        long totalElements = entityPage.getTotalElements();
        return new PageImpl<>(voList, pageable, totalElements);
    }

    default List<E> toEntity(List<V> vos){
        return vos.stream().map(this::toEntity).toList();
    }

    default Page<E> toEntity(Page<V> voPage){
        List<E> entityList = voPage.getContent().stream().map(this::toEntity).toList();
        Pageable pageable = voPage.getPageable();
        long totalElements = voPage.getTotalElements();
        return new PageImpl<>(entityList, pageable, totalElements);
    }

}
