package com.zjgsu.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.List;

import com.zjgsu.dao.base.BaseDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

/**
 * 通用DAO实现
 *
 * @param <T>
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Transactional(value = "transactionManagerHustOj")
public class HustOjBaseDaoImpl<T> implements BaseDao<T> {
    /**
     * hql ： from 后面跟的 类名＋类对象 where 后 用 对象的属性做条件
     * sql： from 后面跟的是表名 where 后 用表中字段做条件
     */
    @Autowired
    @Qualifier("sessionFactoryHustOj")
    private SessionFactory sessionFactoryHustOj;

    private Class<T> clazz;

    protected Session getSession() {
        return sessionFactoryHustOj.getCurrentSession();
    }

    private static final int MAX_LIMIT = 1000;

    private static final int DEFAULT_PAGE_NUM = 1;

    private static final int GET_RESULT_NUM = 1;

    public HustOjBaseDaoImpl() {
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    @Override
    public int save(T t) {
        return (int) this.getSession().save(t);
    }

    @Override
    public T getById(Serializable id) {
        return (T) this.getSession().get(clazz, id);
    }

    @Override
    public void update(T t) {
        this.getSession().update(t);
    }

    @Override
    public int updateByHql(String hql, Object... params) {
        Query query = this.getHqlQueryByArrParams(hql, params);
        return query.executeUpdate();
    }

    @Override
    public int updateByHql(String hql, List<Object> params) {
        Query query = this.getHqlQueryByListParams(hql, params);
        return query.executeUpdate();
    }

    @Override
    public T getByCriterion(Criterion... criterions) {
        Criteria criteria = this.getCriteria(criterions);
        criteria.setMaxResults(GET_RESULT_NUM);
        List<T> list = criteria.list();
        return (list == null || list.size() == 0) ? null : list.get(0);
    }

    @Override
    public int countByCriterion(Criterion... criterions) {
        Criteria criteria = this.getCriteria(criterions);
        Long count = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
        return count.intValue();
    }

    @Override
    public List<T> listByCriterion(Criterion... criterions) {
        return this.listPageByCriterion(null, null, criterions);
    }

    @Override
    public List<T> listByCriterionAndOrder(List<Order> orders, Criterion... criterions) {
        Criteria criteria = this.getCriteria(criterions);
        if (orders != null && orders.size() > 0) {
            for (Order order : orders) {
                criteria.addOrder(order);
            }
        }
        return this.listResultByCriterion(null, null, criteria);
    }

    @Override
    public List<T> listPageByCriterion(Integer pageNum, Integer rowCount, Criterion... criterions) {
        Criteria criteria = this.getCriteria(criterions);
        return this.listResultByCriterion(pageNum, rowCount, criteria);
    }

    @Override
    public List<T> listPageByCriterionAndOrder(Integer pageNum, Integer rowCount, List<Order> orders, Criterion... criterions) {
        Criteria criteria = this.getCriteria(criterions);
        if (orders != null && orders.size() > 0) {
            for (Order order : orders) {
                criteria.addOrder(order);
            }
        }
        return this.listResultByCriterion(pageNum, rowCount, criteria);
    }

    @Override
    public T getByHqlQuery(String hql, Object... params) {
        Query query = this.getHqlQueryByArrParamsAndSetMaxResults(hql, params);
        return this.getResultByHqlQuery(query);
    }

    @Override
    public T getByHqlQuery(String hql, List<Object> params) {
        Query query = this.getHqlQueryByListParamsAndSetMaxResults(hql, params);
        return this.getResultByHqlQuery(query);
    }

    @Override
    public Object getObjectByHqlQuery(String hql, Object... params) {
        Query query = this.getHqlQueryByArrParamsAndSetMaxResults(hql, params);
        return this.getObjectResultByQuery(query);
    }

    @Override
    public Object getObjectByHqlQuery(String hql, List<Object> params) {
        Query query = this.getHqlQueryByListParamsAndSetMaxResults(hql, params);
        return this.getObjectResultByQuery(query);
    }

    @Override
    public Object[] getObjectArrByHqlQuery(String hql, Object... params) {
        Query query = this.getHqlQueryByArrParamsAndSetMaxResults(hql, params);
        return this.getObjectArrResultBySqlQuery(query);
    }

    @Override
    public Object[] getObjectArrByHqlQuery(String hql, List<Object> params) {
        Query query = this.getHqlQueryByListParamsAndSetMaxResults(hql, params);
        return this.getObjectArrResultBySqlQuery(query);
    }

    @Override
    public int countByHqlQuery(String hql, Object... params) {
        Query query = this.getHqlQueryByArrParams(hql, params);
        return this.getCountResultByHqlQuery(query);
    }

    @Override
    public int countByHqlQuery(String hql, List<Object> params) {
        Query query = this.getHqlQueryByListParams(hql, params);
        return this.getCountResultByHqlQuery(query);
    }

    @Override
    public List<T> listByHqlQuery(String hql, Object... params) {
        return this.listPageByHqlQuery(hql, null, null, params);
    }

    @Override
    public List<T> listByHqlQuery(String hql, List<Object> params) {
        return this.listPageByHqlQuery(hql, null, null, params);
    }

    @Override
    public List<T> listPageByHqlQuery(String hql, Integer pageNum, Integer rowCount, Object... params) {
        Query query = this.getHqlQueryLimitByArrParams(hql, pageNum, rowCount, params);
        return query.list();
    }

    @Override
    public List<T> listPageByHqlQuery(String hql, Integer pageNum, Integer rowCount, List<Object> params) {
        Query query = this.getHqlQueryLimitByListParams(hql, pageNum, rowCount, params);
        return query.list();
    }

    @Override
    public List listObjectByHqlQuery(String hql, Object... params) {
        return this.listPageObjectByHqlQuery(hql, null, null, params);
    }

    @Override
    public List listObjectByHqlQuery(String hql, List<Object> params) {
        return this.listPageObjectByHqlQuery(hql, null, null, params);
    }

    @Override
    public List listPageObjectByHqlQuery(String hql, Integer pageNum, Integer rowCount, Object... params) {
        Query query = this.getHqlQueryLimitByArrParams(hql, pageNum, rowCount, params);
        return query.list();
    }

    @Override
    public List listPageObjectByHqlQuery(String hql, Integer pageNum, Integer rowCount, List<Object> params) {
        Query query = this.getHqlQueryLimitByListParams(hql, pageNum, rowCount, params);
        return query.list();
    }

    @Override
    public List<Object[]> listObjectArrByHqlQuery(String hql, Object... params) {
        return this.listPageObjectArrByHqlQuery(hql, null, null, params);
    }

    @Override
    public List<Object[]> listObjectArrByHqlQuery(String hql, List<Object> params) {
        return this.listPageObjectArrByHqlQuery(hql, null, null, params);
    }

    @Override
    public List<Object[]> listPageObjectArrByHqlQuery(String hql, Integer pageNum, Integer rowCount, Object... params) {
        Query query = this.getHqlQueryLimitByArrParams(hql, pageNum, rowCount, params);
        return query.list();
    }

    @Override
    public List<Object[]> listPageObjectArrByHqlQuery(String hql, Integer pageNum, Integer rowCount, List<Object> params) {
        Query query = this.getHqlQueryLimitByListParams(hql, pageNum, rowCount, params);
        return query.list();
    }

    /**
     * 获取QBC查询对象
     */
    private Criteria getCriteria(Criterion... criterions) {
        Criteria criteria = this.getSession().createCriteria(clazz);
        this.addCriterion(criteria, criterions);
        return criteria;
    }

    /**
     * 获取QBC查询结果
     */
    private List<T> listResultByCriterion(Integer pageNum, Integer rowCount, Criteria criteria) {
        if (pageNum == null || pageNum < DEFAULT_PAGE_NUM) {
            pageNum = DEFAULT_PAGE_NUM;
        }
        if (rowCount == null || rowCount < 1 || rowCount > MAX_LIMIT) {
            rowCount = MAX_LIMIT;
        }
        criteria.setFirstResult((pageNum - 1) * rowCount);
        criteria.setMaxResults(rowCount);
        return criteria.list();
    }

    /**
     * 设置Hql获取单一查询结果
     */
    private Query getHqlQueryByListParamsAndSetMaxResults(String hql, List<Object> params) {
        Query query = this.getHqlQueryByListParams(hql, params);
        query.setMaxResults(GET_RESULT_NUM);
        return query;
    }

    /**
     * 设置Hql获取单一查询结果
     */
    private Query getHqlQueryByArrParamsAndSetMaxResults(String hql, Object... params) {
        Query query = this.getHqlQueryByArrParams(hql, params);
        query.setMaxResults(GET_RESULT_NUM);
        return query;
    }

    /**
     * 获取Hql的Query，分页
     */
    private Query getHqlQueryLimitByListParams(String hql, Integer pageNum, Integer rowCount, List<Object> params) {
        Query query = this.getHqlQueryByListParams(hql, params);
        this.setQueryCountLimit(query, pageNum, rowCount);
        return query;
    }

    /**
     * 获取Hql的Query
     */
    private Query getHqlQueryByListParams(String hql, List<Object> params) {
        Query query = this.getSession().createQuery(hql);
        this.setParams(query, params);
        return query;
    }

    /**
     * 获取Hql的Query，分页
     */
    private Query getHqlQueryLimitByArrParams(String hql, Integer pageNum, Integer rowCount, Object... params) {
        Query query = this.getHqlQueryByArrParams(hql, params);
        this.setQueryCountLimit(query, pageNum, rowCount);
        return query;
    }

    /**
     * 获取Hql的Query
     */
    private Query getHqlQueryByArrParams(String hql, Object... params) {
        Query query = this.getSession().createQuery(hql);
        this.setParams(query, params);
        return query;
    }

    /**
     * 获取Hql泛型查询单个结果
     */
    private T getResultByHqlQuery(Query query) {
        List<T> list = query.list();
        return (list == null || list.size() == 0) ? null : list.get(0);
    }

    /**
     * 获取Hql或者Sql查询单个对象结果
     */
    private Object getObjectResultByQuery(Query query) {
        List list = query.list();
        return (list == null || list.size() == 0) ? null : list.get(0);
    }

    /**
     * 获取Hql或者Sql查询单个数组对象结果
     */
    private Object[] getObjectArrResultBySqlQuery(Query query) {
        List list = query.list();
        return (list == null || list.size() == 0) ? null : (Object[]) list.get(0);
    }

    /**
     * 获取Hql查询count结果
     */
    private int getCountResultByHqlQuery(Query query) {
        List list = query.list();
        return (list == null || list.size() == 0) ? 0 : ((Long) list.get(0)).intValue();
    }


    /**
     * 获取Sql查询count结果
     */
    private int getCountResultBySqlQuery(Query query) {
        List list = query.list();
        return (list == null || list.size() == 0) ? 0 : ((BigInteger) list.get(0)).intValue();
    }


    /**
     * 设置DTO的Query的List查询结果数量
     */
    private List setDTOQueryListMaxResults(Integer pageNum, Integer rowCount, Query query) {
        this.setQueryCountLimit(query, pageNum, rowCount);
        List list = query.list();
        return list;
    }

    /**
     * 设置DTO的Query单一查询结果数量
     */
    private List setDTOQueryGetMaxResults(Query query) {
        query.setMaxResults(GET_RESULT_NUM);
        List list = query.list();
        return list;
    }


    /**
     * 设置查询数量限制
     */
    private void setQueryCountLimit(Query query, Integer pageNum, Integer rowCount) {
        if (pageNum == null || pageNum < DEFAULT_PAGE_NUM) {
            pageNum = DEFAULT_PAGE_NUM;
        }
        if (rowCount == null || rowCount < 1 || rowCount > MAX_LIMIT) {
            rowCount = MAX_LIMIT;
        }
        query.setFirstResult((pageNum - 1) * rowCount);
        query.setMaxResults(rowCount);
    }

    /**
     * 拼装可变数组参数
     */
    protected void setParams(Query query, Object... params) {
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
    }

    /**
     * 拼装可变List参数
     */
    protected void setParams(Query query, List<Object> params) {
        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i, params.get(i));
            }
        }
    }

    /**
     * 拼装QBC条件
     */
    protected void addCriterion(Criteria criteria, Criterion... criterions) {
        for (Criterion criterion : criterions) {
            criteria.add(criterion);
        }
    }

}
