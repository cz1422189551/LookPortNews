package com.cz.lookportnews.util;

import org.hibernate.cfg.ImprovedNamingStrategy;

/**
 * 自定义生成字段名策略
 */
public class MPSNameingStrategy extends ImprovedNamingStrategy {
    private static final long serialVersionUID = 1L;

    @Override
    public String classToTableName(String className) {
        return className;
    }

    @Override
    public String propertyToColumnName(String propertyName) {
        return propertyName;
    }

    @Override
    public String tableName(String tableName) {
        return tableName;
    }

    @Override
    public String columnName(String columnName) {
        return columnName;
    }
}
