/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.db.impl;

import core.db.entity.Bank;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.testng.Assert.*;

/**
 *
 * @author Slavomír
 */
public class BankDaoImplNGTest {
    private Bank bank = new Bank();
    public BankDaoImplNGTest() {
        bank.setName("testSaveBank");
        bank.setPrimeInterestRate(12.0);
        bank.setId(4L);
    }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getAll method, of class BankDaoImpl.
     */
    @org.testng.annotations.Test
    public void testGetAll() {
       System.out.println("getAll");
        BankDaoImpl instance = new BankDaoImpl();
        List<Bank> result = instance.getAll();
        int expected = 3;
        int actual = result.size();
        assertEquals(expected, actual);
    }

    /**
     * Test of getById method, of class BankDaoImpl.
     */
    @org.testng.annotations.Test
    public void testGetById() {
       System.out.println("getById");
        Long id = 1L;
        BankDaoImpl instance = new BankDaoImpl();
        Bank expResult = new Bank();
        Bank result = null;
       
        expResult.setId(id);
        expResult.setName("OTP");
        expResult.setPrimeInterestRate(12.0);
        
        result = instance.getById(id);
        
        assertEquals(expResult.getId(),result.getId() );
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getPrimeInterestRate(), result.getPrimeInterestRate());
        
        id = 100L;
        result = instance.getById(id);
        assertEquals(null, result);
    }

    /**
     * Test of saveBank method, of class BankDaoImpl.
     */
    @org.testng.annotations.Test(dependsOnMethods = "testGetAll")
    public void testSaveBank() {
        System.out.println("saveBank");
       
        BankDaoImpl instance = new BankDaoImpl();
        
        int expCount = instance.getAll().size()+1;
        instance.saveBank(bank);
        int actualCount = instance.getAll().size();
        assertEquals(expCount, actualCount);
    }

    /**
     * Test of deleteBank method, of class BankDaoImpl.
     */
    @org.testng.annotations.Test(dependsOnMethods = "testSaveBank")
    public void testDeleteBank() {
        System.out.println("deleteBank");

        BankDaoImpl instance = new BankDaoImpl();
        int expCount = instance.getAll().size()-1;
        
        instance.deleteBank(bank);
        
        int actualCount = instance.getAll().size();
        assertEquals(expCount, actualCount);  
    }
    
}
