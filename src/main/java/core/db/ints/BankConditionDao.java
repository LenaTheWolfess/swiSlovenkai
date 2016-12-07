/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.db.ints;

import core.db.entity.BankCondition;
import java.util.List;

/**
 *
 * @author Rastislav
 */
public interface BankConditionDao {

    /**
     * prida Podmienku pre Banku
     *
     * @param bankCondition objekt BankCondition na pridanie
     * @see BankCondition
     */
    void addBankCondition(BankCondition bankCondition);

    /**
     * zmaze Podmienku pre Banku
     *
     * @param bankCondition objekt BankCondition na zmazanie
     * @see BankCondition
     */
    void deleteBankCondition(BankCondition bankCondition);

    /**
     * vrati vsetky Podmienky pre Banku
     *
     * @return zoznam Podmienok pre Banku
     * @see BankCondition
     */
    List<BankCondition> getAll();

    /**
     * vrati Podmienku pre Banku podla id
     *
     * @param id identifikator Podmienky pre Banku
     * @return objekt BankCondition
     * @see BankCondition
     */
    BankCondition getById(Long id);

    /**
     * upravi Podmienku pre Banku
     *
     * @param bankCondition ako sa ma Podmienka pre Banku upravit
     * @see BankCondition
     */
    void updateBankCondition(BankCondition bankCondition);
    /**
     * vrati podmienky nastavene danou bankou
     * @param bankId id banky pre ktoru chceme aktivne podmienky
     * @return List<BankCondition> zoznam podmienok nastavenych bankou
     */
    public List<BankCondition> getByBankId(long bankId);
}
