/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.db.impl;

import core.db.entity.Condition;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Slavomír
 */
public class ConditionDaoImplNGTest
{

					Condition condition = new Condition();

					public ConditionDaoImplNGTest()
					{
										condition.setId(5L);
										condition.setDescription("testCondition");
										condition.setExpression("lala");

					}

					@BeforeClass
					public static void setUpClass() throws Exception
					{
					}

					@AfterClass
					public static void tearDownClass() throws Exception
					{
					}

					@BeforeMethod
					public void setUpMethod() throws Exception
					{
					}

					@AfterMethod
					public void tearDownMethod() throws Exception
					{
					}

					/**
					 * Test of addCondition method, of class ConditionDaoImpl.
					 */
					@Test(dependsOnMethods = "testGetAll")
					public void testAddCondition()
					{
										System.out.println("addCondition");

										ConditionDaoImpl instance = new ConditionDaoImpl();
										int expResult = instance.getAll().size() + 1;
										instance.addCondition(condition);
										int result = instance.getAll().size();
										assertEquals(result, expResult);
					}

					/**
					 * Test of deleteCondition method, of class ConditionDaoImpl.
					 */
					@Test(dependsOnMethods =
					{
										"testAddCondition", "testUpdateCondition"
					})
					public void testDeleteCondition()
					{
										System.out.println("deleteCondition");
										ConditionDaoImpl instance = new ConditionDaoImpl();
										int expResult = instance.getAll().size() - 1;
										instance.deleteCondition(condition);
										int result = instance.getAll().size();
										assertEquals(result, expResult);
					}

					/**
					 * Test of getAll method, of class ConditionDaoImpl.
					 */
					@Test
					public void testGetAll()
					{
										System.out.println("getAll");
										ConditionDaoImpl instance = new ConditionDaoImpl();
										int expResult = 4;
										int result = instance.getAll().size();
										assertEquals(result, expResult);
					}

					/**
					 * Test of getById method, of class ConditionDaoImpl.
					 */
					@Test
					public void testGetById()
					{
										System.out.println("getById");
										ConditionDaoImpl instance = new ConditionDaoImpl();

										Condition expCondition = new Condition();
										for(Condition cn : instance.getAll())
										{
															expCondition = cn;
										}

										Condition result = instance.getById(expCondition.getId());
										Condition result2 = instance.getById(100L);

										assertEquals(result.getId(), expCondition.getId());
										assertEquals(result.getDescription(), expCondition.getDescription());
										assertEquals(result.getExpression(), expCondition.getExpression());

										assertEquals(result2, null);
					}

					/**
					 * Test of updateCondition method, of class ConditionDaoImpl.
					 */
					@Test(dependsOnMethods =
					{
										"testAddCondition", "testGetById"
					})
					public void testUpdateCondition()
					{
										System.out.println("updateCondition");
										ConditionDaoImpl instance = new ConditionDaoImpl();

										Condition condition = new Condition();
										for(Condition cn : instance.getAll())
										{
															condition = cn;
										}
										condition.setDescription("testUpdatedCondition");

										instance.updateCondition(condition);
										Condition result = instance.getById(condition.getId());

										assertEquals(result.getId(), condition.getId());
										assertEquals(result.getDescription(), condition.getDescription());
										assertEquals(result.getExpression(), condition.getExpression());

										this.condition = condition;

					}

}
