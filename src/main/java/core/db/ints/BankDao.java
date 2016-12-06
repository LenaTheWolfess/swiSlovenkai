/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.db.ints;

import core.db.entity.Bank;
import java.util.List;

/**
 *
 * @author Rastislav
 */
public interface BankDao {
    /**
     * vracia zoznam bank
     * @return zoznam bank
     */
   List<Bank> getAll();
   /**
    * vracia banku podla id
    * @param id id banky
    * @return vracia banku s danym id
    * @see Bank
    */
    Bank getById(Long id);
    /**
     * prida banku 
     * @param bank objekt Bank, ktory bude pridany
     * @see Bank
     */
    void saveBank(Bank bank);
    /**
     * maze banku
     * @param bank objekt Bank, ktory bude zmazany
     * @see Bank
     */
    void deleteBank(Bank bank);

			/**
				* upravuje banku
				* @param bank objekt Bank, ktory bude upraveny
				* @see Bank
				*/
				public void updadeBank(Bank bank);

}
