package core.db.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * The User class represent object with instances(Long id, String role, String
 * name, String userName, String surname, String password, String email, Date
 * contractStart, Date contractEnd, Long idProject). Object contains
 * toString,getter and setters. Object defines one of users(admin, manager,
 * student).
 *
 * @author Rastislav Vocko
 * @version 1.0
 * @since 2016-04-25
 */
@Entity
@Table(name = "myuser")
public class User implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "idB")
    private Long idB;

    @Column(name = "role")
    @Size(min = 1, max = 25)
    private String role;

    @NotNull
    @Column(name = "name")
    @Size(min = 1, max = 25)
    private String name;
    /**
     * vracia id uzivatela odpovedajuce identifikatoru v tabulke user
     * @return id uzivatela
     */
    public Long getId() {
        return id;
    }
/**
 * nastavuje id uzivatela odpovedajuce identifikatoru v tabulke user, AUTOINCREMENT
 * @param id id uzivatela
 */
    public void setId(Long id) {
        this.id = id;
    }
/**
 * vracia id banky - vyznam sa lisi od role uzivatela
 * <p>
 * rola = "administrator" -  id banky ??
 * <p>
 * rola = "bank" -  id banky ktoru spravuje
 * <p>
 * rola = "user" -  id banky v ktorej ma ucet
 * @return vracia id banky 
 * @see getRole
 * @see setRole
 */
    public Long getIdB() {
        return idB;
    }
/**
 * nastavuje id banky - vyznam sa lisi od role uzivatela
 * <p>
 * rola = "administrator" - nastavuje id banky ??
 * <p>
 * rola = "bank" -  id banky ktoru spravuje
 * <p>
 * rola = "user" -  id banky v ktorej ma ucet
 * @see getRole()
 * @see setRole(String role)
 */
    public void setIdB(Long idB) {
        this.idB = idB;
    }
/**
 * vracia rolu uzivatela
 * <p>
 * "administrator" - ma prava administratora
 * <p>
 * "bank" - spravuje danu banku
 * <p>
 * "user" - klient 
 * @return vracia rolu uzivatela
 */
    public String getRole() {
        return role;
    }
/**
 * nastavuje rolu uzivatela
 * <p>
 * "administrator" - ma prava administratora
 * <p>
 * "bank" - spravuje danu banku
 * <p>
 * "user" - klient 
 * @param role rola uzivatela, lenght = <1,25>,NotNull,Set{"administrator","bank","user"}
 */
    public void setRole(String role) {
        this.role = role;
    }
/**
 * vracia meno uzivatela
 * @return meno uzivatela
 */
    public String getName() {
        return name;
    }
/**
 * nastavuje meno uzivatela
 * @param name meno uzivatela,NotNull,lenght=<1,25>
 */
    public void setName(String name) {
        this.name = name;
    }

    
}
