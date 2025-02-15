package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.converter.Converter;
import com.github.mertdeveci.converter.mapper.EntityMapper;
import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.enums.Status;
import com.github.mertdeveci.exceptions.business.NotFoundBusinessException;
import com.github.mertdeveci.functional.ExceptionSupplier;
import com.github.mertdeveci.functional.ThenGet;
import com.github.mertdeveci.vo.BaseVo;
import jakarta.annotation.Nonnull;

import java.util.Optional;
import java.util.function.Consumer;

public abstract class RetrieveService<T extends AbstractEntity, V extends BaseVo> {
    private final EntityMapper<T,V> entityMapper;

    public RetrieveService(EntityMapper<T,V> entityMapper) {
        this.entityMapper = entityMapper;
    }

    public abstract Optional<T> retrieveByIdAndStatus(Long id, Status status);

    public Optional<T> retrieveById(@Nonnull Long id) {
        return retrieveByIdAndStatus(id, Status.ACTIVE);
    }

    public <E extends NotFoundBusinessException> T retrieveByIdOrElseThrow(@Nonnull Long id, @Nonnull ExceptionSupplier<E> notFoundException) {
        return retrieveById(id).orElseThrow(notFoundException);
    }

    public V retrieveByIdAndMapToVo(@Nonnull Long id) {
        return retrieveById(id).map(entityMapper::toVo).orElse(null);
    }

    public <E extends NotFoundBusinessException> V retrieveByIdAndMapToVo(@Nonnull Long id, @Nonnull ExceptionSupplier<E> notFoundException) {
        return retrieveById(id).map(entityMapper::toVo).orElseThrow(notFoundException);
    }

    public <E extends NotFoundBusinessException> void findByIdAndThen(@Nonnull Long id, @Nonnull Consumer<T> consumer, @Nonnull ExceptionSupplier<E> notFoundException) {
        T t = retrieveByIdOrElseThrow(id, notFoundException);
        consumer.accept(t);
    }

    public <K, E extends NotFoundBusinessException> K retrieveByIdAndThenGet(@Nonnull Long id, @Nonnull ThenGet<T, K> thenGet, @Nonnull ExceptionSupplier<E> notFoundException) {
        T t = retrieveByIdOrElseThrow(id, notFoundException);
        return thenGet.applyAndRetrieve(t);
    }

    public void findByIdAndMapToVoAndThen(@Nonnull Long id,  @Nonnull Consumer<V> consumer) {
        retrieveById(id)
                .map(entityMapper::toVo)
                .ifPresent(baseVo -> consumer.accept((V) baseVo));
    }

    public <K> K retrieveByIdAndMapToVoAndThenGet(@Nonnull Long id, @Nonnull ThenGet<V, K> thenGet) {
        return retrieveById(id)
                .map(entityMapper::toVo)
                .map(baseVo -> thenGet.applyAndRetrieve((V) baseVo))
                .orElse(null);
    }

    public <E extends NotFoundBusinessException> void findByIdAndMapToVoAndThen(@Nonnull Long id, @Nonnull Consumer<V> consumer, @Nonnull ExceptionSupplier<E> notFoundException) {
        retrieveById(id)
                .map(entityMapper::toVo)
                .ifPresent(baseVo -> consumer.accept((V) baseVo));
    }

    public <K, E extends NotFoundBusinessException> K retrieveByIdAndMapToVoAndThenGet(@Nonnull Long id, @Nonnull ThenGet<V, K> thenGet, @Nonnull ExceptionSupplier<E> notFoundException) {
        return retrieveById(id)
                .map(entityMapper::toVo)
                .map(baseVo -> thenGet.applyAndRetrieve((V) baseVo))
                .orElseThrow(notFoundException);
    }

    public <K> V retrieveByIdAndThenGetAndMapToVo(@Nonnull Long id, @Nonnull ThenGet<T, K> then, @Nonnull Converter<K, V> converter) {
        return retrieveById(id).map(then::applyAndRetrieve).map(converter::convert).orElse(null);
    }

    public <K, E extends NotFoundBusinessException> V retrieveByIdAndThenGetAndMapToVo(@Nonnull Long id, @Nonnull ThenGet<T, K> then, @Nonnull Converter<K, V> mapper, @Nonnull ExceptionSupplier<E> notFoundException) {
        T t = retrieveByIdOrElseThrow(id, notFoundException);
        K k = then.applyAndRetrieve(t);
        return mapper.convert(k);
    }

}
