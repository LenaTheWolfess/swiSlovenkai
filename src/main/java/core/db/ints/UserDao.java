package core.db.ints;

import core.db.entity.User;
import java.util.List;

/**
 * The UserDao is a data access object interface. Interface contains methods for
 * implementation(adding, deleting, getting, updating).
 *
 * @author Rastislav Vocko, Martin Stofa
 * @version 1.0
 * @since 2016-04-25
 */
public interface UserDao {
    /**
     * vracia zoznam vsetkych uzivatelov
     * @return zoznam uzlivatelov
     */
    List<User> getAll();
    /**
     * vrati uzivatela podla id
     * @param id id uzivatela
     * @return vrati uzivatela podla zadaneho id
     * @see User
     */
    User getById(Long id);
    /**
     * overuje ci uzivatel so zadanym menom splna podmienky verifikacie ak ano, vrati ho ako objekt, inak vracia null
     * @param name meno uzivatela ktory sa chce prihlasit
     * @return vracia objekt User s menom name ak splna podmienky verifikacie, inak vracia null
     * @see User
     */
    User getVerifedUser(String name);
    /**
     * prida usera 
     * @param user objekt User, ktory bude pridany
     * @see User
     */
    void saveUser(User user);
    /**
     * maze usera
     * @param user objekt User, ktory bude zmazany
     * @see User
     */
    void deleteUser(User user);

}
