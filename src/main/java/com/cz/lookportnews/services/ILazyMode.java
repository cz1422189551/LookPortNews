package com.cz.lookportnews.services;

import com.cz.lookportnews.entity.News;

import java.util.List;

public interface ILazyMode<T> {
    public List<T> getTypeWithList(List<T> list);

    public List<T> getTypeWithoutList(List<T> list);
}
