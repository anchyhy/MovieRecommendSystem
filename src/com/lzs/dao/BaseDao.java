package com.lzs.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @ClassName: BaseDao
 * 
 * @param <T>
 */
@Repository("baseDao")
@SuppressWarnings("all")
public class BaseDao<T> extends HibernateDaoSupport {

	public BaseDao() {
		// System.out.println("-- BaseDAOImpl() constructor... ");
	}

	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public Serializable save(T o) {
		return getHibernateTemplate().save(o);
	}

	public void delete(T o) {
		getHibernateTemplate().delete(o);
	}

	public void update(T o) {
		getHibernateTemplate().update(o);
	}

	public void saveOrUpdate(T o) {
		getHibernateTemplate().saveOrUpdate(o);
	}

	public List<T> find(String hql) {
		return (List<T>) getHibernateTemplate().find(hql);
	}

	public List<T> find(String hql, Object[] param) {
		return (List<T>) getHibernateTemplate().find(hql, param);
	}

	public List<T> find(String hql, List<Object> param) {
		return (List<T>) getHibernateTemplate().find(hql, param);
	}

	public List<T> find(String hql, Object[] param, Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		final int p = page, r = rows;

		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				for (int i = 0; i < param.length; i++) {
					query.setParameter(i, param[i]);
				}
				return query.setFirstResult((p - 1) * r).setMaxResults(r).getResultList();
			}
		});

		return list;
	}

	public List<T> find(String hql, List<Object> param, Integer page, Integer rows) {
		return find(hql, param, page, rows);
	}

	public T get(Class<T> c, Serializable id) {
		return (T) getHibernateTemplate().get(c, id);
	}

	public T get(String hql, Object[] param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	public T get(String hql, List<Object> param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	public List<Object> getInfo(String hql) {
		return (List<Object>) getHibernateTemplate().find(hql);
	}

	public List<Object> getInfo(String hql, List<Object> param) {
		return (List<Object>) getHibernateTemplate().find(hql, param);
	}

	public List<Object> getInfo(String hql, Object[] param) {
		return (List<Object>) getHibernateTemplate().find(hql, param);
	}

	public List<Object> getInfo(String hql, List<Object> param, Integer page, Integer rows) {
		return getInfo(hql, param, page, rows);
	}

	public List<Object> getInfo(String hql, Object[] param, Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		final int p = page, r = rows;

		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				for (int i = 0; i < param.length; i++) {
					query.setParameter(i, param[i]);
				}
				return query.setFirstResult((p - 1) * r).setMaxResults(r).getResultList();
			}
		});

		return list;

	}

	public Long count(String hql) {
		return (Long) getHibernateTemplate().find(hql, null).listIterator().next();
	}

	public Long count(String hql, Object[] param) {
		return (Long) getHibernateTemplate().find(hql, param).listIterator().next();
	}

	public Long count(String hql, List<Object> param) {
		return (Long) getHibernateTemplate().find(hql, param).listIterator().next();
	}

	public Integer executeHql(String hql) {
		return getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql).executeUpdate();
	}

	public Integer executeHql(String hql, Object[] param) {
		Query q = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.executeUpdate();
	}

	public Integer executeHql(String hql, List<Object> param) {
		Query q = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.executeUpdate();
	}

	public Double average(String hql) {
		return (Double) getHibernateTemplate().find(hql).listIterator().next();
	}

	public Double average(String hql, Object[] param) {
		return (Double) getHibernateTemplate().find(hql, param).listIterator().next();
	}

	public Double average(String hql, List<Object> param) {
		return (Double) getHibernateTemplate().find(hql, param).listIterator().next();
	}
}
