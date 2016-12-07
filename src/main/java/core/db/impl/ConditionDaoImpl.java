/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.db.impl;

import core.db.HibernateUtil;
import core.db.entity.Bank;
import core.db.entity.Condition;
import core.db.ints.ConditionDao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rastislav
 */
public class ConditionDaoImpl implements ConditionDao {

    /**
     * prida podmienku do databazy
     *
     * @param condition objekt Condition ktory sa prida do databazy
     * @see Condition
     */
    @Override
    public void addCondition(Condition condition) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(condition);
        session.close();
    }

    /**
     * zmaze podmienku z databazy
     *
     * @param condition objekt Condition ktory ma byt zmazany z databazy
     * @see Condition
     */
    @Override
    public void deleteCondition(Condition condition) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            tx.setTimeout(5);

            session.delete(condition);
            tx.commit();

        } catch (RuntimeException e) {
            try {
                tx.rollback();
            } catch (RuntimeException rbe) {

            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }

        }
    }

    /**
     * vrati vsetky podmienky z databazy
     *
     * @return zoznam podmienok
     * @see Condition
     * @throws UnsupportedOperationException
     */
    @Override
    public List<Condition> getAll() {
        List<Condition> conditions = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            conditions = session.createCriteria(Condition.class).list();
        } catch (HibernateException e) {

        } finally {
            session.close();
            return conditions;
        }
    }

    /**
     * vrati podmienku podla id z databazy
     *
     * @param id id podmienky
     * @return vracia podmienku
     * @see Condition
     * @throws UnsupportedOperationException
     */
    @Override
    public Condition getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Condition.class);
        criteria.add(Restrictions.eq("id", id));
        List<Condition> conditions = criteria.list();
        if (conditions == null) {
            return null;
        }
        if (conditions.isEmpty()) {
            return null;
        }
        if (conditions.get(0) != null) {
            Condition condition = conditions.get(0);
            session.close();
            return condition;
        } else {
            session.close();
            return null;
        }
    }

    /**
     * upravi parametre podmienky s danym id z databazy
     *
     * @param condition podmienka s tymto id sa upravi podla tohto objektu
     * @see Condition
     * @throws UnsupportedOperationException
     */
    @Override
    public void updateCondition(Condition condition) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Condition.class);
        criteria.add(Restrictions.eq("id", condition.getId()));

        try {
            tx = session.beginTransaction();
            tx.setTimeout(5);

            session.update(condition);

            tx.commit();
        } catch (RuntimeException e) {
            try {
                tx.rollback();
            } catch (RuntimeException rbe) {

            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }

        }
    }

}
