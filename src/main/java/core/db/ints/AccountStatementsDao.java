/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.db.ints;

import core.db.entity.AccountStatements;
import java.util.List;

/**
 *
 * @author Rastislav
 */
public interface AccountStatementsDao {
    /**
     * prida stav uctu
     * @param accountStatements stav uctu na pridanie
     * @see AccountStatements
     */
    void addAccountStatements(AccountStatements accountStatements);
    /**
     * zmaze stav uctu
     * @param accountStatements stav uctu na zmazanie
     * @see AccountStatements
     */
    void deleteAccountStatements(AccountStatements accountStatements);
    /**
     * vrati vsetky stavy uctu
     * @return zoznam stavov uctov
     */
    List<AccountStatements> getAll();
    /**
     * vrati stav uctu podla id
     * @param id identifikator stavu uctu
     * @return vracia stav uctu podla zadaneho id
     * @see AccountStatements
     */
    AccountStatements getById(Long id);
    /**
     * upravi stav uctu s danym id
     * @param accountStatements ako sa ma stav uctu upravit
     * @see AccountStatements
     */
    void updateAccountStatements(AccountStatements accountStatements);

}
