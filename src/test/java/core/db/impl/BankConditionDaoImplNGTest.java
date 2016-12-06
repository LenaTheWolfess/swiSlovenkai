/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.db.impl;

import core.db.entity.BankCondition;
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
public class BankConditionDaoImplNGTest {
    BankCondition bankConditionExisted = new BankCondition();
    BankCondition saveUpdateDeleteBankCondition = new BankCondition();
    
    public BankConditionDaoImplNGTest() {
        bankConditionExisted.setIdBC(2L);
        bankConditionExisted.setIdB(3L);
        bankConditionExisted.setIdC(2L);
        bankConditionExisted.setMark(2L);
        bankConditionExisted.setValue(15000);
        bankConditionExisted.setChangeInterestRate(-2.5);
        
        saveUpdateDeleteBankCondition.setIdBC(8L);
        saveUpdateDeleteBankCondition.setIdB(3L);
        saveUpdateDeleteBankCondition.setIdC(2L);
        saveUpdateDeleteBankCondition.setMark(2L);
        saveUpdateDeleteBankCondition.setValue(30000);
        saveUpdateDeleteBankCondition.setChangeInterestRate(-2.5);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of addBankCondition method, of class BankConditionDaoImpl.
     */
    @Test(dependsOnMethods = "testGetAll")
    public void testAddBankCondition() {
        System.out.println("addBankCondition");
        BankConditionDaoImpl instance = new BankConditionDaoImpl();
        int expResult = instance.getAll().size()+1;
        instance.addBankCondition(saveUpdateDeleteBankCondition);
        int result = instance.getAll().size();
        
        assertEquals(result, expResult);
    }

    /**
     * Test of deleteBankCondition method, of class BankConditionDaoImpl.
     */
    @Test(dependsOnMethods = {"testAddBankCondition","testUpdateBankCondition"})
    public void testDeleteBankCondition() {
        System.out.println("deleteBankCondition");
         BankConditionDaoImpl instance = new BankConditionDaoImpl();
        int expResult = instance.getAll().size()-1;
        instance.deleteBankCondition(saveUpdateDeleteBankCondition);
        int result = instance.getAll().size();
        
        assertEquals(result, expResult);
    }

    /**
     * Test of getAll method, of class BankConditionDaoImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        BankConditionDaoImpl instance = new BankConditionDaoImpl();
        int expResult = 7;
        int result = instance.getAll().size();
        
        assertEquals(result, expResult);
    }

    /**
     * Test of getById method, of class BankConditionDaoImpl.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        BankConditionDaoImpl instance = new BankConditionDaoImpl();
        
        BankCondition result = instance.getById(bankConditionExisted.getId());
        BankCondition result2 = instance.getById(100L);
        
        assertEquals(result.getId(), bankConditionExisted.getId());
        assertEquals(result.getIdB(), bankConditionExisted.getIdB());
        assertEquals(result.getIdC(), bankConditionExisted.getIdC());
        assertEquals(result.getMark(), bankConditionExisted.getMark());
        assertEquals(result.getValue(), bankConditionExisted.getValue());
        assertEquals(result.getChangeInterestRate(), bankConditionExisted.getChangeInterestRate());
        
        assertEquals(result2, null);
        
        
    }

    /**
     * Test of updateBankCondition method, of class BankConditionDaoImpl.
     */
    @Test(dependsOnMethods = {"testAddBankCondition","testGetById"})
    public void testUpdateBankCondition() {
        System.out.println("updateBankCondition");
        BankConditionDaoImpl instance = new BankConditionDaoImpl();
        saveUpdateDeleteBankCondition.setChangeInterestRate(-10.0);
        instance.updateBankCondition(saveUpdateDeleteBankCondition);
        BankCondition result = instance.getById(saveUpdateDeleteBankCondition.getId());
        
        assertEquals(result, saveUpdateDeleteBankCondition);
    }
    
}
