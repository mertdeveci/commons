package com.github.mertdeveci.converter;

import jakarta.annotation.Nonnull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Converter<I, O> extends Mapper<I, O> {
}
