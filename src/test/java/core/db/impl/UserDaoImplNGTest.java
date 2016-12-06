/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.db.impl;

import core.db.entity.User;
import java.util.List;
import static org.junit.Assert.assertEquals;
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
public class UserDaoImplNGTest {
    
    public UserDaoImplNGTest() {
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
     * Test of getAll method, of class UserDaoImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        UserDaoImpl instance = new UserDaoImpl();
        int result = instance.getAll().size();
        int expResult = 7;
        assertEquals(expResult,result);
      
    }

    /**
     * Test of getById method, of class UserDaoImpl.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        Long id = 3L;
        UserDaoImpl instance = new UserDaoImpl();
        User result = instance.getById(id);
        
        User expResult = new User();
        expResult.setId(id);
        expResult.setIdB(2L);
        expResult.setRole("bank");
        expResult.setName("Lukas Ondro");
        assertEquals(result.getId(), expResult.getId());
        assertEquals(result.getIdB(), expResult.getIdB());
					 assertEquals(result.getName(), expResult.getName());
					 assertEquals(result.getRole(), expResult.getRole());
        id = 100L;
        result = instance.getById(id);
        assertEquals(null, result);
    }

    /**
     * Test of getVerifedUser method, of class UserDaoImpl.
     */
    @Test
    public void testGetVerifedUser() {
        System.out.println("getVerifedUser");
        Long id = 3L;
        Long idB= 2L;
        String name = "Lukas Ondro";
        String role = "bank";
        
        UserDaoImpl instance = new UserDaoImpl();
        
        User expResult = new User();
        expResult.setId(id);
        expResult.setIdB(idB);
        expResult.setRole(role);
        expResult.setName(name);
        
        User result = instance.getVerifedUser(name);
        User result2 = instance.getVerifedUser("XXXX");
        
        assertEquals(result.getId(), id);
        assertEquals(result.getIdB(), idB);
        assertEquals(result.getRole(), role);
        assertEquals(result.getName(), name);
        
        assertEquals(result2, null);
    }
    
}
