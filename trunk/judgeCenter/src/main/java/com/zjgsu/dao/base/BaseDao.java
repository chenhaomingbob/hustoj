package com.zjgsu.dao.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

/**
 * 通用DAO接口
 *
 * @param <T>
 */
@SuppressWarnings("rawtypes")
public interface BaseDao<T> {

    /**
     * 保存新记录
     */
    String save(T t);

    /**
     * 根据主键查询
     */
    T getById(Serializable id);

    /**
     * 更新记录
     */
    void update(T t);

    /**
     * HQL更新
     */
    int updateByHql(String hql, Object... params);

    /**
     * HQL更新，重载
     */
    int updateByHql(String hql, List<Object> params);

    /**
     * QBC单表查询单个数据
     */
    T getByCriterion(Criterion... criterions);

    /**
     * QBC单表查询总记录数
     */
    int countByCriterion(Criterion... criterions);

    /**
     * QBC单表查询集合
     */
    List<T> listByCriterion(Criterion... criterions);

    /**
     * QBC单表分页查询集合
     */
    List<T> listPageByCriterion(Integer pageNum, Integer rowCount, Criterion... criterions);

    /**
     * QBC单表分页排序查询集合
     */
    List<T> listPageByCriterionAndOrder(Integer pageNum, Integer rowCount, List<Order> orders, Criterion... criterions);

    /**
     * HQL单表查询单个数据
     */
    T getByHqlQuery(String hql, Object... params);

    /**
     * HQL单表查询单个数据，重载
     */
    T getByHqlQuery(String hql, List<Object> params);

    /**
     * HQL单表或多表查询单个数据或封装的对象，若为单个数据必须为单列数据!!!!!
     */
    Object getObjectByHqlQuery(String hql, Object... params);

    /**
     * HQL单表或多表查询单个数据或封装的对象，重载，若为单个数据必须为单列数据!!!!!
     */
    Object getObjectByHqlQuery(String hql, List<Object> params);

    /**
     * HQL单表或多表查询部分数据，不得为单列数据!!!!!
     */
    Object[] getObjectArrByHqlQuery(String hql, Object... params);

    /**
     * HQL单表或多表查询部分数据，重载，不得为单列数据!!!!!
     */
    Object[] getObjectArrByHqlQuery(String hql, List<Object> params);

    /**
     * HQL单表或多表查询总记录数
     */
    int countByHqlQuery(String hql, Object... params);

    /**
     * HQL单表或多表查询总记录数，重载
     */
    int countByHqlQuery(String hql, List<Object> params);

    /**
     * HQL单表查询数据集合
     */
    List<T> listByHqlQuery(String hql, Object... params);

    /**
     * HQL单表查询数据集合，重载
     */
    List<T> listByHqlQuery(String hql, List<Object> params);

    /**
     * HQL单表分页查询数据集合
     */
    List<T> listPageByHqlQuery(String hql, Integer pageNum, Integer rowCount, Object... params);

    /**
     * HQL单表分页查询数据集合，重载
     */
    List<T> listPageByHqlQuery(String hql, Integer pageNum, Integer rowCount, List<Object> params);

    /**
     * HQL单表或多表查询单个数据集合或者封装的对象，若为单个数据必须为单列数据!!!!!
     */
    List listObjectByHqlQuery(String hql, Object... params);

    /**
     * HQL单表或多表查询单个数据集合或者封装的对象，重载，若为单个数据必须为单列数据!!!!!
     */
    List listObjectByHqlQuery(String hql, List<Object> params);

    /**
     * HQL单表或多表分页查询单个数据集合或者封装的对象，若为单个数据必须为单列数据!!!!!
     */
    List listPageObjectByHqlQuery(String hql, Integer pageNum, Integer rowCount, Object... params);

    /**
     * HQL单表或多表分页查询单个数据集合或者封装的对象，重载，若为单个数据必须为单列数据!!!!!
     */
    List listPageObjectByHqlQuery(String hql, Integer pageNum, Integer rowCount, List<Object> params);

    /**
     * HQL单表或多表查询部分数据集合，不得为单列数据!!!!!
     */
    List<Object[]> listObjectArrByHqlQuery(String hql, Object... params);

    /**
     * HQL单表或多表查询部分数据集合，重载，不得为单列数据!!!!!
     */
    List<Object[]> listObjectArrByHqlQuery(String hql, List<Object> params);

    /**
     * HQL单表或多表分页查询部分数据集合，不得为单列数据!!!!!
     */
    List<Object[]> listPageObjectArrByHqlQuery(String hql, Integer pageNum, Integer rowCount, Object... params);

    /**
     * HQL单表或多表分页查询部分数据集合，重载，不得为单列数据!!!!!
     */
    List<Object[]> listPageObjectArrByHqlQuery(String hql, Integer pageNum, Integer rowCount, List<Object> params);

}
