package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.converter.mapper.EntityMapper;
import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.enums.Status;
import com.github.mertdeveci.exceptions.business.NotFoundBusinessException;
import com.github.mertdeveci.functional.ExceptionSupplier;
import com.github.mertdeveci.functional.Then;
import com.github.mertdeveci.functional.ThenGet;
import jakarta.annotation.Nonnull;

import java.util.Optional;

public interface RetrieveService<T extends AbstractEntity> {
    Optional<T> retrieveByIdAndStatus(Long id, Status status);

    default Optional<T> retrieveById(@Nonnull Long id){
        return retrieveByIdAndStatus(id, Status.ACTIVE);
    }

    default <E extends NotFoundBusinessException> T retrieveByIdOrElseThrow(@Nonnull Long id, @Nonnull ExceptionSupplier<E> notFoundException){
        return retrieveById(id).orElseThrow(notFoundException);
    }

    default <E extends NotFoundBusinessException> void findByIdAndThen(@Nonnull Long id, @Nonnull Then<T> then, @Nonnull ExceptionSupplier<E> notFoundException){
        T t = retrieveByIdOrElseThrow(id, notFoundException);
        then.apply(t);
    }

    default <K, E extends NotFoundBusinessException> K retrieveByIdAndThenGet(@Nonnull Long id, @Nonnull ThenGet<T, K> thenGet, @Nonnull ExceptionSupplier<E> notFoundException){
        T t = retrieveByIdOrElseThrow(id, notFoundException);
        return thenGet.applyAndRetrieve(t);
    }

    default <R extends AbstractEntity> void findByIdAndMapAndThen(@Nonnull Long id, @Nonnull EntityMapper<T, R> mapper, @Nonnull Then<R> then){
        retrieveById(id).map(mapper::toEntity).map(then::apply);
    }

    default <R extends AbstractEntity, K> K retrieveByIdAndMapAndThenGet(@Nonnull Long id, @Nonnull EntityMapper<T, R> mapper, @Nonnull ThenGet<R, K> thenGet){
        return retrieveById(id).map(mapper::toEntity).map(thenGet::applyAndRetrieve).orElse(null);
    }

    default <R extends AbstractEntity, E extends NotFoundBusinessException> void findByIdAndMapAndThen(@Nonnull Long id, @Nonnull EntityMapper<T, R> mapper, @Nonnull Then<R> then, @Nonnull ExceptionSupplier<E> notFoundException){
        T t = retrieveByIdOrElseThrow(id, notFoundException);
        R mapped = mapper.toEntity(t);
        then.apply(mapped);
    }

    default <R extends AbstractEntity, K, E extends NotFoundBusinessException> K retrieveByIdAndMapAndThenGet(@Nonnull Long id, @Nonnull EntityMapper<T, R> mapper, @Nonnull ThenGet<R,K> thenGet, @Nonnull ExceptionSupplier<E> notFoundException){
        T t = retrieveByIdOrElseThrow(id, notFoundException);
        R r = mapper.toEntity(t);
        return thenGet.applyAndRetrieve(r);
    }

    default <R extends AbstractEntity> R retrieveByIdAndMap(@Nonnull Long id, @Nonnull EntityMapper<T, R> mapper){
        return retrieveById(id).map(mapper::toEntity).orElse(null);
    }

    default <R extends AbstractEntity, E extends NotFoundBusinessException> R retrieveByIdAndMap(@Nonnull Long id, @Nonnull EntityMapper<T, R> mapper, @Nonnull ExceptionSupplier<E> notFoundException){
        return retrieveById(id).map(mapper::toEntity).orElseThrow(notFoundException);
    }

    default <R extends AbstractEntity, K> R retrieveByIdAndThenGetAndMap(@Nonnull Long id, @Nonnull ThenGet<T,K> then, @Nonnull EntityMapper<K,R> mapper){
        return retrieveById(id).map(then::applyAndRetrieve).map(mapper::toEntity).orElse(null);
    }

    default <R extends AbstractEntity, K, E extends NotFoundBusinessException> R retrieveByIdAndThenGetAndMap(@Nonnull Long id, @Nonnull ThenGet<T,K> then, @Nonnull EntityMapper<K,R> mapper, @Nonnull ExceptionSupplier<E> notFoundException){
        T t = retrieveByIdOrElseThrow(id, notFoundException);
        K k = then.applyAndRetrieve(t);
        return mapper.toEntity(k);
    }

}
