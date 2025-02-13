package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.converter.Converter;
import com.github.mertdeveci.converter.mapper.EntityMapper;
import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.enums.Status;
import com.github.mertdeveci.exceptions.business.NotFoundBusinessException;
import com.github.mertdeveci.functional.ExceptionSupplier;
import com.github.mertdeveci.functional.ThenGet;
import jakarta.annotation.Nonnull;

import java.util.Optional;
import java.util.function.Consumer;

public interface RetrieveService<T extends AbstractEntity> {
    Optional<T> retrieveByIdAndStatus(Long id, Status status);

    default Optional<T> retrieveById(@Nonnull Long id){
        return retrieveByIdAndStatus(id, Status.ACTIVE);
    }

    default <E extends NotFoundBusinessException> T retrieveByIdOrElseThrow(@Nonnull Long id, @Nonnull ExceptionSupplier<E> notFoundException){
        return retrieveById(id).orElseThrow(notFoundException);
    }

    default <V> V retrieveByIdAndMapToVo(@Nonnull Long id, @Nonnull EntityMapper<T,V> mapper){
        return retrieveById(id).map(mapper::toVo).orElse(null);
    }

    default <V, E extends NotFoundBusinessException> V retrieveByIdAndMapToVo(@Nonnull Long id, @Nonnull EntityMapper<T, V> mapper, @Nonnull ExceptionSupplier<E> notFoundException){
        T t = retrieveByIdOrElseThrow(id, notFoundException);
        return mapper.toVo(t);
    }

    default <E extends NotFoundBusinessException> void findByIdAndThen(@Nonnull Long id, @Nonnull Consumer<T> consumer, @Nonnull ExceptionSupplier<E> notFoundException){
        T t = retrieveByIdOrElseThrow(id, notFoundException);
        consumer.accept(t);
    }

    default <K, E extends NotFoundBusinessException> K retrieveByIdAndThenGet(@Nonnull Long id, @Nonnull ThenGet<T,K> thenGet, @Nonnull ExceptionSupplier<E> notFoundException){
        T t = retrieveByIdOrElseThrow(id, notFoundException);
        return thenGet.applyAndRetrieve(t);
    }

    default <V> void findByIdAndMapToVoAndThen(@Nonnull Long id, @Nonnull EntityMapper<T,V> mapper, @Nonnull Consumer<V> consumer){
        retrieveById(id).map(mapper::toVo).ifPresent(consumer);
    }

    default <V,K> K retrieveByIdAndMapToVoAndThenGet(@Nonnull Long id, @Nonnull EntityMapper<T,V> mapper, @Nonnull ThenGet<V,K> thenGet){
        return retrieveById(id).map(mapper::toVo).map(thenGet::applyAndRetrieve).orElse(null);
    }

    default <V,E extends NotFoundBusinessException> void findByIdAndMapToVoAndThen(@Nonnull Long id, @Nonnull EntityMapper<T,V> mapper, @Nonnull Consumer<V> consumer, @Nonnull ExceptionSupplier<E> notFoundException){
        T t = retrieveByIdOrElseThrow(id, notFoundException);
        V V = mapper.toVo(t);
        consumer.accept(V);
    }

    default <V,K,E extends NotFoundBusinessException> K retrieveByIdAndMapToVoAndThenGet(@Nonnull Long id, @Nonnull EntityMapper<T,V> mapper, @Nonnull ThenGet<V,K> thenGet, @Nonnull ExceptionSupplier<E> notFoundException){
        T t = retrieveByIdOrElseThrow(id, notFoundException);
        V v = mapper.toVo(t);
        return thenGet.applyAndRetrieve(v);
    }

    default <V,K> V retrieveByIdAndThenGetAndMapToVo(@Nonnull Long id, @Nonnull ThenGet<T,K> then, @Nonnull Converter<K,V> converter){
        return retrieveById(id).map(then::applyAndRetrieve).map(converter::convert).orElse(null);
    }

    default <V,K,E extends NotFoundBusinessException> V retrieveByIdAndThenGetAndMapToVo(@Nonnull Long id, @Nonnull ThenGet<T,K> then, @Nonnull Converter<K,V> mapper, @Nonnull ExceptionSupplier<E> notFoundException){
        T t = retrieveByIdOrElseThrow(id, notFoundException);
        K k = then.applyAndRetrieve(t);
        return mapper.convert(k);
    }

}
