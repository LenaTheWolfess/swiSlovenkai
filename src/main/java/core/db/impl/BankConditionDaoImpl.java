/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.db.impl;

import core.db.HibernateUtil;
import core.db.entity.Bank;
import core.db.entity.BankCondition;
import core.db.ints.BankConditionDao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rastislav
 */
public class BankConditionDaoImpl implements BankConditionDao
{

					/**
					 * prida Podmienku pre Banku do databazy
					 *
					 * @param bankCondition objekt BankCondition na pridanie
					 * @see BankCondition
					 * @throws UnsupportedOperationException
					 */
					@Override
					public void addBankCondition(BankCondition bankCondition)
					{
										Session session = HibernateUtil.getSessionFactory().openSession();
										session.save(bankCondition);
										session.close();
					}

					/**
					 * zmaze Podmienku pre Banku z databazy
					 *
					 * @param bankCondition objekt BankCondition na zmazanie
					 * @see BankCondition
					 * @throws UnsupportedOperationException
					 */
					@Override
					public void deleteBankCondition(BankCondition bankCondition)
					{
										Transaction tx = null;
										Session session = null;
										try
										{
															session = HibernateUtil.getSessionFactory().openSession();
															tx = session.beginTransaction();
															tx.setTimeout(5);

															session.delete(bankCondition);

															tx.commit();

										}
										catch(RuntimeException e)
										{
															try
															{
																				tx.rollback();
															}
															catch(RuntimeException rbe)
															{

															}
															throw e;
										}
										finally
										{
															if(session != null)
															{
																				session.close();
															}

										}
					}

					/**
					 * vrati vsetky Podmienky pre Banku z databazy
					 *
					 * @return zoznam Podmienok pre Banku
					 * @see BankCondition
					 * @throws UnsupportedOperationException
					 */
					@Override
					public List<BankCondition> getAll()
					{
										List<BankCondition> list = new ArrayList<>();
										Session session = HibernateUtil.getSessionFactory().openSession();
										list = session.createCriteria(BankCondition.class).list();
										session.close();
										return list;
					}

					/**
					 * vrati Podmienku pre Banku podla id z databazy
					 *
					 * @param id identifikator Podmienky pre Banku
					 * @return objekt BankCondition
					 * @see BankCondition
					 * @throws UnsupportedOperationException
					 */
					@Override
					public BankCondition getById(Long id)
					{
										Session session = HibernateUtil.getSessionFactory().openSession();
										Criteria criteria = session.createCriteria(BankCondition.class);
										criteria.add(Restrictions.eq("id", id));
										List<BankCondition> bankConditions = criteria.list();
										if(bankConditions.get(0) != null)
										{
															BankCondition bankCondition = bankConditions.get(0);
															session.close();
															return bankCondition;
										}
										else
										{
															session.close();
															return null;
										}
					}

					/**
					 * upravi Podmienku pre Banku v databaze
					 *
					 * @param bankCondition ako sa ma Podmienka pre Banku upravit
					 * @see BankCondition
					 * @throws UnsupportedOperationException
					 */
					@Override
					public void updateBankCondition(BankCondition bankCondition)
					{
										Transaction tx = null;
										Session session = HibernateUtil.getSessionFactory().openSession();
										Criteria criteria = session.createCriteria(BankCondition.class);
										criteria.add(Restrictions.eq("id", bankCondition.getId()));
										try
										{
															tx = session.beginTransaction();
															tx.setTimeout(5);

															session.update(bankCondition);

															tx.commit();
										}
										catch(RuntimeException e)
										{
															try
															{
																				tx.rollback();
															}
															catch(RuntimeException rbe)
															{

															}
															throw e;
										}
										finally
										{
															if(session != null)
															{
																				session.close();
															}

										}
					}

					@Override
					public List<BankCondition> getByBankId(long bankId)
					{
										Session session = HibernateUtil.getSessionFactory().openSession();
										Criteria criteria = session.createCriteria(BankCondition.class);
										criteria.add(Restrictions.eq("idB", bankId));

										List<BankCondition> bankConditions = criteria.list();

										session.close();
										return bankConditions;
					}

}
