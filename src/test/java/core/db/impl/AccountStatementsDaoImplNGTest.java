/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.db.impl;

import core.db.entity.AccountStatements;
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
public class AccountStatementsDaoImplNGTest {
    AccountStatements saveUpdateDeleteAccountStatement = new AccountStatements();
    AccountStatements exestedAccountStatement = new AccountStatements();
    public AccountStatementsDaoImplNGTest() {
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
     * Test of addAccountStatements method, of class AccountStatementsDaoImpl.
     */
    @Test(dependsOnMethods = "testGetAll")
    public void testAddAccountStatements() {
        System.out.println("addAccountStatements");
        AccountStatementsDaoImpl instance = new AccountStatementsDaoImpl();
        int expResult = instance.getAll().size()+1;
        instance.addAccountStatements(saveUpdateDeleteAccountStatement);
        int result = instance.getAll().size();
        
        assertEquals(result, expResult);
    }

    /**
     * Test of deleteAccountStatements method, of class AccountStatementsDaoImpl.
     */
    @Test(dependsOnMethods = {"testAddAccountStatements","testUpdateAccountStatements"})
    public void testDeleteAccountStatements() {
        System.out.println("deleteAccountStatements");
        AccountStatementsDaoImpl instance = new AccountStatementsDaoImpl();
        int expResult = instance.getAll().size()-1;
        instance.deleteAccountStatements(saveUpdateDeleteAccountStatement);
        int result = instance.getAll().size();
        
        assertEquals(result, expResult);
    }

    /**
     * Test of getAll method, of class AccountStatementsDaoImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        AccountStatementsDaoImpl instance = new AccountStatementsDaoImpl();
        int expResult = 48;
        int result = instance.getAll().size();
        assertEquals(result, expResult);
    }

    /**
     * Test of getById method, of class AccountStatementsDaoImpl.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        Long id = 0L;
        AccountStatementsDaoImpl instance = new AccountStatementsDaoImpl();
       /*
        id=exestedAccountStatement.getId();
     */
        AccountStatements result = instance.getById(id);
        /*
        porovnanie po zlozkach
        */
        fail("core.db.entity.AccountStatement is empty !!!");     
    }

    /**
     * Test of updateAccountStatements method, of class AccountStatementsDaoImpl.
     */
    @Test(dependsOnMethods = {"testGetById","testAddAccountStatements"})
    public void testUpdateAccountStatements() {
        System.out.println("updateAccountStatements");
        AccountStatementsDaoImpl instance = new AccountStatementsDaoImpl();
        long id = 0L;
        /*
        id = saveUpdateDeleteAccountStatement.getId();
      */
        
        instance.updateAccountStatements(saveUpdateDeleteAccountStatement);
        AccountStatements result = instance.getById(id);
        
        assertEquals(result, saveUpdateDeleteAccountStatement);
        
         fail("core.db.entity.AccountStatement is empty !!!");
        
    }
    
}
