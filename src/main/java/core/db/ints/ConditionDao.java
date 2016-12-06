/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.db.ints;

import core.db.entity.Condition;
import java.util.List;

/**
 *
 * @author Rastislav
 */
public interface ConditionDao {
    /**
     * prida podmienku
     * @param condition objekt Condition 
     * @see Condition
     */
    void addCondition(Condition condition);
    /**
     * zmaze podmienku
     * @param condition objekt Condition 
     * @see Condition
     */
    void deleteCondition(Condition condition);
    /**
     * vrati vsetky podmienky
     * @return zoznam podmienok
     * @see Condition
     */
    List<Condition> getAll();
    /**
     * vrati podmienku podla id
     * @param id id podmienky
     * @return vracia podmienku
     * @see Condition
     */
    Condition getById(Long id);
    /**
     * upravi parametre podmienky s danym id
     * @param condition podmienka s tymto id sa upravi podla tohto objektu
     * @see Condition
     */
    void updateCondition(Condition condition);

		
}
